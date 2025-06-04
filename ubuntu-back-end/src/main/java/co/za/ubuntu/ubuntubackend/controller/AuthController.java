package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.ubuntubackend.dto.AuthRequest;
import co.za.ubuntu.ubuntubackend.dto.AuthResponse;
import co.za.ubuntu.ubuntubackend.dto.RegisterRequest;
import co.za.ubuntu.ubuntubackend.service.KeycloakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final KeycloakService keycloakService;

    public AuthController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        keycloakService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(keycloakService.login(request));
    }
}

