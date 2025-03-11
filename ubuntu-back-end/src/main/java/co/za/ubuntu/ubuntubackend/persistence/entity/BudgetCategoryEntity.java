package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "budget_category")
public class BudgetCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_id", nullable = false)
    private BudgetEntity budget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column
    private String notes;

    @Column(nullable = false)
    private BigDecimal allocatedAmount; // The budgeted amount for this category

    @Column(nullable = false)
    private BigDecimal actualSpent = BigDecimal.ZERO; // Updated as transactions are added

    @Column
    private Integer priorityLevel;

    @OneToOne
    @JoinColumn(name = "short_term_goal_id")
    private GoalEntity shortTermGoal; // This is only set for categories with a short-term goal

    @Column
    private BigDecimal rolloverAmount = BigDecimal.ZERO; //Amount left at the end of the budget

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BudgetEntity getBudget() {
        return budget;
    }

    public void setBudget(BudgetEntity budget) {
        this.budget = budget;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public BigDecimal getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(BigDecimal allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public GoalEntity getShortTermGoal() {
        return shortTermGoal;
    }

    public void setShortTermGoal(GoalEntity shortTermGoal) {
        this.shortTermGoal = shortTermGoal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getActualSpent() {
        return actualSpent;
    }

    public void setActualSpent(BigDecimal actualSpent) {
        this.actualSpent = actualSpent;
    }

    public BigDecimal getRolloverAmount() {
        return rolloverAmount;
    }

    public void setRolloverAmount(BigDecimal rolloverAmount) {
        this.rolloverAmount = rolloverAmount;
    }
}