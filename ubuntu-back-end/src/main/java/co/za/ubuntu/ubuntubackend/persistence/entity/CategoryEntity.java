package co.za.ubuntu.ubuntubackend.persistence.entity;

import co.za.ubuntu.ubuntubackend.domain.enums.CategoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category", schema = "budgetbuddy")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType type; // Enum type for predefined categories

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "category")
    private Set<BudgetCategoryEntity> budgetCategories;

    @OneToMany(mappedBy = "category")
    private Set<TransactionEntity> transactions;

    @Column(name = "priority")
    private Integer priorityLevel;

    @Column(name = "notes")
    private String notes;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @NotNull
    @Column(name = "date_updated", nullable = false)
    private Instant dateUpdated;

}