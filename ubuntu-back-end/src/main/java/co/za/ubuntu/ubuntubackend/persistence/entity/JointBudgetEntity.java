package co.za.ubuntu.ubuntubackend.persistence.entity;

import co.za.ubuntu.ubuntubackend.domain.enums.RolloverType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Quick note: When a user gets a discount code on reaching a goal and uses it, they need to submit
 * a button saying they have made the purchase and the store also needs to scan the code saying that
 * the coupon has been used. The store is then invoiced each month on the number of sales.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "joint_budget", schema = "budgetbuddy")
@DiscriminatorValue("JOINT")
public class JointBudgetEntity extends BudgetEntity {

    // For a joint budget, we have a list of members who participate.
    @ManyToMany
    @JoinTable(
        name = "joint_budget_members",
        joinColumns = @JoinColumn(name = "joint_budget_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> members = new HashSet<>();

    @OneToMany(mappedBy = "jointBudget", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JointBudgetCategoryEntity> jointBudgetCategories = new HashSet<>();

    // Other joint-specific fields here, such as group chat IDs, approval statuses, etc.
    private Integer chatId;
}