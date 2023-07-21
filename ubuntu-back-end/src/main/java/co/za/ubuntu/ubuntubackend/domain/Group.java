package co.za.ubuntu.ubuntubackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {

    private String groupName;
    private String addressLine1;
    private String addressLine2;
    private List<User> users;

    /**
     * Owning side of the many-to-many relationship
     * @param user
     */
    public void addUser(User user) {
        users.add(user);
    }

}
