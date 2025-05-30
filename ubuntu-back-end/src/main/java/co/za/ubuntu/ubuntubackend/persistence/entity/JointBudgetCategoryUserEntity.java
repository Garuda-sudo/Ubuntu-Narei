package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * This entity is used to allocate how much each user in the joint group has been allocated to spend
 * on a specific category. For e.g. if I am responsible for 50% of our groceries category this is the
 * entity/table used to keep track of that.
 */
@Entity
@Table(name = "joint_budget_category_user")
@Getter
@Setter
public class JointBudgetCategoryUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "joint_budget_category_id", nullable = false)
    private JointBudgetCategoryEntity jointBudgetCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private BigDecimal allocatedAmount;

    private BigDecimal amountSpent;

}
