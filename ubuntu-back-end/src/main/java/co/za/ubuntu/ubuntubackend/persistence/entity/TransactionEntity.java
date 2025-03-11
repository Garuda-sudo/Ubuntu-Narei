package co.za.ubuntu.ubuntubackend.persistence.entity;

import co.za.ubuntu.ubuntubackend.domain.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A transaction will only be associated to 1 account even though an account
 * may fund multiple budgets. When a user adds a transaction to a budget that
 * is funded by 2 accounts, a popup will be displayed to ask which account
 * the transaction will be debited to. Analysis will then display how each
 * account has funded the respective budgets they are linked to.
 *
 * A transaction will be linked to a single category that the user will choose
 *
 * A transaction will only be associated to a single budget, and a budget may
 * be associated with many transactions.
 */
@Entity
@Table(name = "transaction", schema = "budgetbuddy")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Size(max = 50)
    @NotNull
    @Column(name = "currency", nullable = false, length = 50)
    private String currency;

    @Size(max = 50)
    @NotNull
    @Column(name = "identifier", nullable = false, length = 50)
    private String identifier;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(nullable = false)
    private LocalDate transactionDate;

    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(name = "date_updated", nullable = false)
    private Instant dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_category_id", nullable = false)
    private BudgetCategoryEntity budgetCategory;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "budget_id", nullable = false)
    private BudgetEntity budget;

    public BudgetEntity getBudgets() {
        return budget;
    }

    public void setBudget(BudgetEntity budget) {
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Instant dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public BudgetEntity getBudget() {
        return budget;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BudgetCategoryEntity getBudgetCategory() {
        return budgetCategory;
    }

    public void setBudgetCategory(BudgetCategoryEntity budgetCategory) {
        this.budgetCategory = budgetCategory;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}