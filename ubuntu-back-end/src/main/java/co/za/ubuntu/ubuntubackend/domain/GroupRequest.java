package co.za.ubuntu.ubuntubackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupRequest {

    private List<User> userList;
    private String groupName;
    private String groupStatus;
    private String a;
    private LocalDateTime createdDate;

}
