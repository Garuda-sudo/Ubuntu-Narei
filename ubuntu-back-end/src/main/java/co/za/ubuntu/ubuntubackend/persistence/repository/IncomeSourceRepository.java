package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetIncomeSplitEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.IncomeSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeSourceRepository extends JpaRepository<IncomeSourceEntity, Integer> {
    List<IncomeSourceEntity> findByAccountId(Integer accountId);
}