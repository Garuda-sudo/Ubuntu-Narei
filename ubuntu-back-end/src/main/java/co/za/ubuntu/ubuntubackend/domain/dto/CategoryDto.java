package co.za.ubuntu.ubuntubackend.domain.dto;

import co.za.ubuntu.ubuntubackend.persistence.entity.CategoryEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link CategoryEntity}
 */
@Value
@Data
public class CategoryDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 50)
    String name;
    @NotNull
    UserDto user;
    @NotNull
    Instant dateCreated;
    @NotNull
    Instant dateUpdated;
}