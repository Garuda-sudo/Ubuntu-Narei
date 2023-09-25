package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<BudgetEntity, Integer> {

    public Optional<List<BudgetEntity>> findBudgetEntitiesByUserEntity(UserEntity userEntity);
}