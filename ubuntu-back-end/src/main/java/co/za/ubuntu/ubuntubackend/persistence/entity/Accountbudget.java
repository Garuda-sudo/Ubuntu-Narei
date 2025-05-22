package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "account_budget", schema = "budgetbuddy")
public class Accountbudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "budget_id", nullable = false)
    private BudgetEntity budgetEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity accountEntity;

    // Amount the user *intended* to contribute to this budget from this account
    @Column(name = "planned_amount", precision = 19, scale = 2)
    private BigDecimal plannedAmount;

    // Amount *actually spent* from this account in the context of this budget
    @Column(name = "actual_spent_amount", precision = 19, scale = 2)
    private BigDecimal actualSpentAmount;

    // When the account was linked to this budget
    @Column(name = "linked_date")
    private LocalDateTime linkedDate;

    // Whether this is the default account for spending in this budget
    @Column(name = "is_default")
    private Boolean isDefault;

    // Optional priority field for fallback or display order
    @Column(name = "priority")
    private Integer priority;

    // Optional notes
    @Column(name = "notes", length = 500)
    private String notes;

}