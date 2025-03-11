package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class BudgetReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "budget_id")
    private BudgetEntity budget;

    private double totalBudgeted;

    private double totalSpent;

    private double leftoverAmount;

    private String insights;

    private LocalDate reviewDate = LocalDate.now();

}
