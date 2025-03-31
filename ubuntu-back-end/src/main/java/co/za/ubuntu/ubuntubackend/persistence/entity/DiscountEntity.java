package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "discount", schema = "budgetbuddy",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "budget_category_id"),
        @UniqueConstraint(columnNames = "joint_budget_category_id")
    }
)
@Getter
@Setter
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link discount to either individual or joint budget category
    @ManyToOne
    @JoinColumn(name = "budget_category_id", nullable = true)
    private BudgetCategoryEntity budgetCategory;

    @ManyToOne
    @JoinColumn(name = "joint_budget_category_id", nullable = true)
    private JointBudgetCategoryEntity jointBudgetCategory;

    @Column(nullable = false)
    private String discountType; // e.g., "10% Discount", "Cashback"

    @Column(nullable = false)
    private boolean redeemed = false;

    @ManyToMany
    @JoinTable(
        name = "discount_users",
        joinColumns = @JoinColumn(name = "discount_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> eligibleUsers = new HashSet<>(); // Users who can redeem in joint budgets

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;  // User who can redeem for a single budget

    @Column(nullable = false)
    private LocalDate expiryDate;

    public DiscountEntity() {}

    public DiscountEntity(BudgetCategoryEntity budgetCategory,
                          JointBudgetCategoryEntity jointBudgetCategory,
                          UserEntity user,
                          String discountType,
                          LocalDate expiryDate) {
        this.budgetCategory = budgetCategory;
        this.jointBudgetCategory = jointBudgetCategory;
        this.user = user;
        this.discountType = discountType;
        this.expiryDate = expiryDate;
        this.redeemed = false;
    }
}
