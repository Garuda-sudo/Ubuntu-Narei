package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.UserApi;
import co.za.ubuntu.model.User;
import co.za.ubuntu.ubuntubackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    UserService userService;

    @Override
    public ResponseEntity<User> getUser(Long userId) {

        var user = userService.getUser(Math.toIntExact(userId));

        return ResponseEntity.ok().body(user);
    }
}
