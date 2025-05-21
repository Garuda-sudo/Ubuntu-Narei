package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * The income entity represents an income source for an user, and is linked to
 * an account. A user/group can have multiple incomes linked to multiple accounts.
 * The end goal for the income is for income projection that allows users a
 * holistic view on the amount of projected income in the future and to eventually
 * add AI/ML models to predict future incomes
 */
@Getter
@Setter
@Entity
@Table(name = "income", schema = "budgetbuddy")
public class IncomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "income_amount", nullable = false, length = 50)
    private BigDecimal incomeAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @Column(name = "source_name")
    private String sourceName;

    @Column(name = "frequency")
    private String frequency;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @NotNull
    @Column(name = "last_updated", nullable = false)
    private Instant lastUpdated;

}