package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "joint_budget_category_user")
@Getter
@Setter
public class JointBudgetCategoryUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "joint_budget_category_id", nullable = false)
    private JointBudgetCategoryEntity jointBudgetCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private BigDecimal allocatedAmount;

    private BigDecimal amountSpent;

}
