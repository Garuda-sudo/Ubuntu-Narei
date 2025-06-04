package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.ubuntubackend.dto.AuthRequest;
import co.za.ubuntu.ubuntubackend.dto.AuthResponse;
import co.za.ubuntu.ubuntubackend.dto.RegisterRequest;

public interface KeycloakService {

    void register(RegisterRequest request);
    AuthResponse login(AuthRequest request);

}
