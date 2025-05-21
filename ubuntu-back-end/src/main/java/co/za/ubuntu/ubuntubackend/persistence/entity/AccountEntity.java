package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "account", schema = "budgetbuddy")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal balance;

    @Size(max = 50)
    @NotNull
    @Column(name = "institution", nullable = false, length = 50)
    private String institution;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @NotNull
    @Column(name = "date_updated", nullable = false)
    private Instant dateUpdated;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IncomeEntity> incomes;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BudgetIncomeSplitEntity> budgetIncomeSplit;

    @OneToMany(mappedBy = "account")
    private Set<TransactionEntity> transactions = new HashSet<>();

    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    //    private Set<TransactionEntity> transactions;

}