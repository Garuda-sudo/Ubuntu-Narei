package co.za.ubuntu.ubuntubackend.domain.dto;

import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */
@Value
@Data
public class UserDto {
    Integer id;
    @NotNull
    @Size(max = 50)
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be blank")
    String username;
    @NotNull
    @Size(max = 50)
    @Email(message = "Email needs to be in a valid email format", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    String email;
    @Size(max = 50)
    String name;
    @Size(max = 50)
    String surname;
}