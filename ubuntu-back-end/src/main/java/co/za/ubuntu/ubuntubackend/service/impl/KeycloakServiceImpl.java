package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.ubuntubackend.dto.AuthRequest;
import co.za.ubuntu.ubuntubackend.dto.AuthResponse;
import co.za.ubuntu.ubuntubackend.dto.RegisterRequest;
import co.za.ubuntu.ubuntubackend.service.KeycloakService;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.core.Response;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.authServerUrl}")
    private String authServerUrl;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Override
    public void register(RegisterRequest request) {
        UsersResource usersResource;
        try (Keycloak keycloakAdmin = KeycloakBuilder.builder()
            .serverUrl(authServerUrl)
            .realm("master")
            .clientId("admin-cli")
            .username("admin")
            .password("admin") // TODO: Replace with env or secure config
            .build()) {

            usersResource = keycloakAdmin.realm(realm).users();
        }

        UserRepresentation user = new UserRepresentation();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEnabled(true);

        String userId;

        try (Response response = usersResource.create(user)) {
            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed to create user: " + response.getStatusInfo());
            }

            // Set password
            userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        }
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(request.getPassword());
        credential.setTemporary(false);

        usersResource.get(userId).resetPassword(credential);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Keycloak keycloak = KeycloakBuilder.builder()
            .serverUrl(authServerUrl)
            .realm(realm)
            .clientId(clientId)
            .clientSecret(clientSecret)
            .username(request.getUsername())
            .password(request.getPassword())
            .grantType("password")
            .build();

        AccessTokenResponse token = keycloak.tokenManager().getAccessToken();

        return new AuthResponse(
            token.getToken(),
            token.getRefreshToken(),
            token.getExpiresIn()
        );
    }
}
