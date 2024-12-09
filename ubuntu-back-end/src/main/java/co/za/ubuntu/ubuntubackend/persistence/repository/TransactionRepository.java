package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    @Query(value = "Select * from budgetbuddy.transaction t " +
        "inner join budgetbuddy.budget b on t.budget_id = b.id WHERE b.id =:budgetId", nativeQuery = true)
    Optional<Set<TransactionEntity>> findByBudget(Integer budgetId);

    //    @Query(value = "Select * from budgetbuddy.transaction t " +
    //        "inner join budgetbuddy.budget b on t.budget_id = b.id WHERE b.id =:budgetId " +
    //        "inner join budgetbuddy.", nativeQuery = true)
    //TODO: Create query to get all transactions for a user later
    //        Set<TransactionEntity> findByUser(Integer userId);
}