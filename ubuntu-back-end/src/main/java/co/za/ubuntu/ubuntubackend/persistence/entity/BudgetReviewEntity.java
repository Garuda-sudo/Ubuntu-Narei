package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


/**
 * The budget review needs to give something unique otherwise its the same thing as the dashboard.
 * What should it have to make it unique? I'm thinking that it gives the complete holistic view of
 * the users finances.What they put as a goal, what debt, what savings and how their budgets have
 * tracked and if they are on track to hit their targets.
 *
 * The review entity’s biggest unique value might be storing milestone summaries, key insights, and recommendations —
 * stuff that can’t be easily recreated on the fly.
 */
@Entity
@Getter
@Setter
@Table(name = "budget_review", schema = "budgetbuddy")
public class BudgetReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "budget_review_budgets",
        schema = "budgetbuddy",
        joinColumns = @JoinColumn(name = "budget_review_id"),
        inverseJoinColumns = @JoinColumn(name = "budget_id")
    )
    private List<BudgetEntity> budgets;

    @ManyToMany
    @JoinTable(
        name = "budget_review_goals",
        schema = "budgetbuddy",
        joinColumns = @JoinColumn(name = "budget_review_id"),
        inverseJoinColumns = @JoinColumn(name = "goal_id")
    )
    private List<GoalEntity> goals;

    private BigDecimal totalBudgetedAmount;

    private BigDecimal totalSpentAmount;

    private BigDecimal totalSavings;

    private BigDecimal totalDebt;

    private String insights;

    private LocalDate reviewDate = LocalDate.now();
}