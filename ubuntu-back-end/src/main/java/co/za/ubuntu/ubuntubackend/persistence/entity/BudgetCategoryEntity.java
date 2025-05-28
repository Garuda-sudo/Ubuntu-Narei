package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "budget_category")
public class BudgetCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

}