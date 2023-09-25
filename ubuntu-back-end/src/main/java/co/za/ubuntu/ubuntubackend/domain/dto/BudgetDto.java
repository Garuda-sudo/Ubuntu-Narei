package co.za.ubuntu.ubuntubackend.domain.dto;

import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * DTO for {@link BudgetEntity}
 */
@Value
@Data
public class BudgetDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 50)
    String budgetName;
    @NotNull
    BigDecimal amountLimit;
    @NotNull
    LocalDate startDate;
    @NotNull
    LocalDate endDate;
    @NotNull
    @Size(max = 10)
    String periodType;
    @NotNull
    Instant dateCreated;
    @NotNull
    Instant dateUpdated;
    @NotNull
    UserDto user;
}