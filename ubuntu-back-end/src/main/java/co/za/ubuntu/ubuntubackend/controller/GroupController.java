package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.ubuntubackend.domain.Group;
import co.za.ubuntu.ubuntubackend.domain.GroupRequest;
import co.za.ubuntu.ubuntubackend.domain.User;
import co.za.ubuntu.ubuntubackend.domain.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ubuntu/group")
public class GroupController {

    @PostMapping("/create")
    public ResponseEntity<Group> createGroup(@RequestBody GroupRequest groupRequest) {

        return ResponseEntity.ok(
                Group.builder().build()
        );

    }

}
