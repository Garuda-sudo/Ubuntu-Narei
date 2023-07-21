package co.za.ubuntu.ubuntubackend.services;


import co.za.ubuntu.ubuntubackend.domain.User;

import java.util.UUID;

public interface UserService {

    public void createUser();

    public User getUser(UUID uuid);
}
