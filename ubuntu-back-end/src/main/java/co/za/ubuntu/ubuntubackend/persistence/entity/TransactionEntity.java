package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "transaction", schema = "budgetbuddy")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Size(max = 50)
    @NotNull
    @Column(name = "currency", nullable = false, length = 50)
    private String currency;

    @Size(max = 50)
    @NotNull
    @Column(name = "identifier", nullable = false, length = 50)
    private String identifier;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @NotNull
    @Column(name = "date_updated", nullable = false)
    private Instant dateUpdated;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity categoryEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity accountEntity;

}