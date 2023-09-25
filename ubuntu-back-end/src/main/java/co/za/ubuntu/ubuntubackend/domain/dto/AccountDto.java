package co.za.ubuntu.ubuntubackend.domain.dto;

import co.za.ubuntu.ubuntubackend.persistence.entity.AccountEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link AccountEntity}
 */
@Value
@Data
public class AccountDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 50)
    String name;
    @NotNull
    BigDecimal balance;
    @NotNull
    @Size(max = 50)
    String institution;
    @NotNull
    Instant dateCreated;
    @NotNull
    Instant dateUpdated;
}