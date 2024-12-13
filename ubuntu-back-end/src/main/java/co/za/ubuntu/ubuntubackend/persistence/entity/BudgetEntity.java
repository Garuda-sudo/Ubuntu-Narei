package co.za.ubuntu.ubuntubackend.persistence.entity;

import co.za.ubuntu.model.Category;
import co.za.ubuntu.model.Transaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "budget", schema = "budgetbuddy")
public class BudgetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @NotNull
//    @Column(name = "budget_income", nullable = false, precision = 9, scale = 2)
//    private BigDecimal budgetIncome;

    @Size(max = 50)
    @NotNull
    @Column(name = "budget_name", nullable = false, length = 50)
    private String budgetName;

    @NotNull
    @Column(name = "amount_limit", nullable = false, precision = 9, scale = 2)
    private BigDecimal amountLimit;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Size(max = 10)
    @NotNull
    @Column(name = "period_type", nullable = false, length = 10)
    private String periodType;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @NotNull
    @Column(name = "date_updated", nullable = false)
    private Date dateUpdated;

//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity userEntity;

    @NotNull
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "account_budget",
        joinColumns = { @JoinColumn(name = "budget_id") },
        inverseJoinColumns = { @JoinColumn(name = "account_id") }
    )
    private Set<AccountEntity> accounts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "budget_category",
        joinColumns = { @JoinColumn(name = "category_id") },
        inverseJoinColumns = { @JoinColumn(name = "budget_id") }
    )
    private CategoryEntity category;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
    private BudgetIncomeSplitEntity budgetIncomeSplitEntity;

    @OneToMany(mappedBy = "budget")
    private Set<TransactionEntity> transactions = new HashSet<>();

    public Set<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

//    public BigDecimal getBudgetIncome() {
//        return budgetIncome;
//    }
//
//    public void setBudgetIncome(BigDecimal budgetIncome) {
//        this.budgetIncome = budgetIncome;
//    }

    public BigDecimal getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(BigDecimal amountLimit) {
        this.amountLimit = amountLimit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public BudgetIncomeSplitEntity getBudgetIncomeSplitEntity() {
        return budgetIncomeSplitEntity;
    }

    public void setBudgetIncomeSplitEntity(BudgetIncomeSplitEntity budgetIncomeSplitEntity) {
        this.budgetIncomeSplitEntity = budgetIncomeSplitEntity;
    }
}