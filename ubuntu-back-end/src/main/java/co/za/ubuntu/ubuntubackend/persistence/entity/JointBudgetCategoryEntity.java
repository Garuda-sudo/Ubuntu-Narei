package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "joint_budget_category")
@Getter
@Setter
public class JointBudgetCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "joint_budget_id", nullable = false)
    private JointBudgetEntity jointBudget;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "jointBudgetCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JointBudgetCategoryUserEntity> members = new HashSet<>();

    private BigDecimal totalAllocation;
}