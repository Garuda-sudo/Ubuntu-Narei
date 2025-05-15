package co.za.ubuntu.ubuntubackend.persistence.entity;

import co.za.ubuntu.model.Category;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.ubuntubackend.domain.enums.BudgetStatus;
import co.za.ubuntu.ubuntubackend.domain.enums.RolloverType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Quick note: When a user gets a discount code on reaching a goal and uses it, they need to submit
 * a button saying they have made the purchase and the store also needs to scan the code saying that
 * the coupon has been used. The store is then invoiced each month on the number of sales.
 */
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "budget_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "budget", schema = "budgetbuddy")
public class BudgetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "budget_name", nullable = false, length = 50)
    private String budgetName;

    @NotNull
    @Column(name = "amount_limit", nullable = false, precision = 9, scale = 2)
    private BigDecimal amountLimit; //The total amount budgeted on creation of this budget. Name might not be clear
    // enough

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BudgetStatus status;

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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @ManyToMany
    @JoinTable(
        name = "budget_goal",
        joinColumns = @JoinColumn(name = "budget_id"),
        inverseJoinColumns = @JoinColumn(name = "goal_id")
    )
    private List<GoalEntity> longTermGoals = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private Set<BudgetCategoryEntity> budgetCategories;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
    private List<BudgetIncomeSplitEntity> budgetIncomeSplitEntity;

    @OneToMany(mappedBy = "budget")
    private Set<TransactionEntity> transactions = new HashSet<>();

    @Column(name = "version_number")
    private Integer versionNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_version_id")
    private BudgetEntity previousVersion;

    @Column(name = "auto_rollover")
    private Boolean autoRollover; // If true, rollover happens automatically

    @Column(name = "rollover_type")
    @Enumerated(EnumType.STRING)
    private RolloverType rolloverType; // Enum defining how rollover happens

    @Column(name = "rollover_group_id")
    private UUID rolloverGroupId;

    public Set<BudgetCategoryEntity> getBudgetCategories() {
        return budgetCategories;
    }

    public void setBudgetCategories(Set<BudgetCategoryEntity> budgetCategories) {
        this.budgetCategories = budgetCategories;
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

    public List<GoalEntity> getLongTermGoals() {
        return longTermGoals;
    }

    public void setLongTermGoals(List<GoalEntity> longTermGoals) {
        this.longTermGoals = longTermGoals;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

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

    public BudgetStatus getStatus() {
        return status;
    }

    public void setStatus(BudgetStatus status) {
        this.status = status;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public BudgetEntity getPreviousVersion() {
        return previousVersion;
    }

    public void setPreviousVersion(BudgetEntity previousVersion) {
        this.previousVersion = previousVersion;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<BudgetIncomeSplitEntity> getBudgetIncomeSplitEntity() {
        return budgetIncomeSplitEntity;
    }

    public void setBudgetIncomeSplitEntity(List<BudgetIncomeSplitEntity> budgetIncomeSplitEntity) {
        this.budgetIncomeSplitEntity = budgetIncomeSplitEntity;
    }

    public Boolean getAutoRollover() {
        return autoRollover;
    }

    public void setAutoRollover(Boolean autoRollover) {
        this.autoRollover = autoRollover;
    }

    public RolloverType getRolloverType() {
        return rolloverType;
    }

    public void setRolloverType(RolloverType rolloverType) {
        this.rolloverType = rolloverType;
    }

    public UUID getRolloverGroupId() {
        return rolloverGroupId;
    }

    public void setRolloverGroupId(UUID rolloverGroupId) {
        this.rolloverGroupId = rolloverGroupId;
    }
}