package co.za.ubuntu.ubuntubackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String identificationNumber;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private List<Group> groups;

}
