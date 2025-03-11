package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetIncomeSplitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BudgetIncomeSplitRepository extends JpaRepository<BudgetIncomeSplitEntity, Integer> {

    Optional<BudgetIncomeSplitEntity> findByAccountIdAndBudgetId(Long accountId, Long budgetId);

    Optional<List<BudgetIncomeSplitEntity>> findByBudgetId(Long budgetId);

}