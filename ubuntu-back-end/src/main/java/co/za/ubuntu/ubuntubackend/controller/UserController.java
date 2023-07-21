package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.ubuntubackend.domain.User;
import co.za.ubuntu.ubuntubackend.domain.UserRequest;
import co.za.ubuntu.ubuntubackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ubuntu/user")
public class UserController {

    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest
    ) {

        return ResponseEntity.ok(
                User.builder().build()
        );

    }

    @GetMapping("/retrieve")
    public ResponseEntity<User> retrieveUser(
            @RequestParam("userId") UUID userId
    ) {

        var user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

}
