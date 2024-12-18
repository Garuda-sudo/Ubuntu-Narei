package co.za.ubuntu.ubuntubackend.persistence.entity;

import co.za.ubuntu.model.Account;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * The BudgetIncomeSplitEntity keeps track of how much from each account
 * a user intends to use in their respective linked budget.
 */
@NoArgsConstructor
@Entity
@Table(name = "budget_income_split", schema = "budgetbuddy")
public class BudgetIncomeSplitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "income_amount", nullable = false)
    private Double incomeAmount;
    @Column(name = "split_type")
    private String splitType;
    @Column(name = "allocation_percentage")
    private BigDecimal allocationPercentage;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "budget_id", nullable = false)
    private BudgetEntity budget;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false, unique = true)
    private AccountEntity account;

}
