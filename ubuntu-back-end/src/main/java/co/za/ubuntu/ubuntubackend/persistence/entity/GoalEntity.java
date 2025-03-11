package co.za.ubuntu.ubuntubackend.persistence.entity;

import co.za.ubuntu.ubuntubackend.domain.enums.CategoryType;
import co.za.ubuntu.ubuntubackend.domain.enums.GoalType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "goal", schema = "budgetbuddy")
public class GoalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal targetAmount;
    private LocalDate targetDate;
    private String description;
    private int durationMonths;

    @Enumerated(EnumType.STRING)
    private GoalType goalType; // SHORT_TERM or LONG_TERM

    // For short-term goals (e.g., 50% spending)
    private Integer triggerPercentage;

    @ManyToMany(mappedBy = "longTermGoals")
    private List<BudgetEntity> budgets;

    @ManyToMany(mappedBy = "goals")
    private List<UserEntity> users;

}