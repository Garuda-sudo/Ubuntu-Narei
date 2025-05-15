package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetEntity, Integer> {

    @Query(value = "Select b.* from budgetbuddy.budget b " +
                   "inner join budgetbuddy.account a " +
                   "on b.account_id = a.id " +
                   "where b.account_id in :accountIds", nativeQuery = true)
    Optional<Set<BudgetEntity>> findBudgetEntitiesByAccountIds(@Param("accountIds") List<Integer> accountIds);

    @Query(value = "SELECT * FROM budgetbuddy.budget b " +
        "WHERE b.rollover_group_id = (" +
        "SELECT b2.rollover_group_id FROM budgetbuddy.budget b2 WHERE b2.id = :budgetId) " +
        "ORDER BY b.start_date", nativeQuery = true)
    Optional<Set<BudgetEntity>> findAllBudgetVersions(@Param("budgetId") Integer budgetId);
}