package co.za.ubuntu.ubuntubackend.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.za.ubuntu.ubuntubackend.persistence.entity.Transactionbudget}
 */
@Value
@Data
public class TransactionbudgetDto implements Serializable {
    Integer id;
    @NotNull
    BudgetDto budget;
    @NotNull
    TransactionDto transaction;
}