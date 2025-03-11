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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getSplitType() {
        return splitType;
    }

    public void setSplitType(String splitType) {
        this.splitType = splitType;
    }

    public BigDecimal getAllocationPercentage() {
        return allocationPercentage;
    }

    public void setAllocationPercentage(BigDecimal allocationPercentage) {
        this.allocationPercentage = allocationPercentage;
    }

    public BudgetEntity getBudget() {
        return budget;
    }

    public void setBudget(BudgetEntity budget) {
        this.budget = budget;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
}
