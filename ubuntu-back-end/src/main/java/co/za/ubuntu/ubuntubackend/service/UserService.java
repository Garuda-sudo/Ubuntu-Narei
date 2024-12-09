package co.za.ubuntu.ubuntubackend.service;


import co.za.ubuntu.model.User;

public interface UserService {

    User createUser(User userDTO);
    User getUser(Integer userId);

}
