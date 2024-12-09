package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the Joint Group Budgeting Entity. A room can be linked to multiple budgets and/or multiple accounts.
 * It is essentially the heart of coming together to budget towards a goal with others. TODO: Add this back at a
 * later stage
 */
@NoArgsConstructor
@Entity
@Table(name = "room", schema = "budgetbuddy")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "room_name", nullable = false, length = 50)
    private String roomName;

    @NotNull
    @Column(name = "group_goal", nullable = false, precision = 9, scale = 2)
    private BigDecimal groupGoal;

//    @NotNull
//    @Column(name = "users", nullable = false)
//    private Set<UserEntity> users;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Size(max = 10)
    @NotNull
    @Column(name = "period_type", nullable = false, length = 10)
    private String periodType;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @NotNull
    @Column(name = "date_updated", nullable = false)
    private Date dateUpdated;

    @NotNull
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "room_budget",
        joinColumns = { @JoinColumn(name = "room_id") },
        inverseJoinColumns = { @JoinColumn(name = "budget_id") }
    )
    private Set<BudgetEntity> budgets = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public BigDecimal getGroupGoal() {
        return groupGoal;
    }

    public void setGroupGoal(BigDecimal groupGoal) {
        this.groupGoal = groupGoal;
    }

//    public Set<UserEntity> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<UserEntity> users) {
//        this.users = users;
//    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Set<BudgetEntity> getBudgets() {
        return budgets;
    }

    public void setBudgets(Set<BudgetEntity> budgets) {
        this.budgets = budgets;
    }
}