package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "discount", schema = "budgetbuddy")
@Getter
@Setter
@NoArgsConstructor
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Link to the goal that determines budget & categories
    @ManyToOne
    @JoinColumn(name = "goal_id")
    private GoalEntity goal;

    // Main redeemer (usually the single user or group lead)
    @ManyToOne(optional = false)
    @JoinColumn(name = "redeemed_by_user_id", nullable = false)
    private UserEntity redeemedBy;

    @Column(name = "discount_type", nullable = false)
    private String discountType; // e.g., "10% OFF", "Cashback"

    @Column(nullable = false)
    private boolean redeemed = false;

    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate;

    public DiscountEntity(GoalEntity goal,
                          UserEntity user,
                          String discountType,
                          LocalDateTime expiryDate) {
        this.goal = goal;
        this.redeemedBy = user;
        this.discountType = discountType;
        this.expiryDate = expiryDate;
        this.redeemed = false;
    }
}
