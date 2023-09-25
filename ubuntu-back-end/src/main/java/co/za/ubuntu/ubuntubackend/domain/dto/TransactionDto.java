package co.za.ubuntu.ubuntubackend.domain.dto;

import co.za.ubuntu.ubuntubackend.persistence.entity.TransactionEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link TransactionEntity}
 */
@Value
@Data
public class TransactionDto implements Serializable {
    Integer id;
    @NotNull
    BigDecimal amount;
    @NotNull
    @Size(max = 50)
    String currency;
    @NotNull
    @Size(max = 50)
    String identifier;
    @NotNull
    Instant date;
    @NotNull
    Instant dateCreated;
    @NotNull
    Instant dateUpdated;
    @NotNull
    CategoryDto category;
    @NotNull
    UserDto user;
    @NotNull
    AccountDto account;
}