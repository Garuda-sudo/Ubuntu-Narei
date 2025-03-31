package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetCategoryEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BudgetCategoryRepository extends JpaRepository<BudgetCategoryEntity, Integer> {

    //Optional<Set<BudgetCategoryEntity>> findBudgetEntitiesByAccountIds(@Param("accountIds") List<Integer> accountIds);
}