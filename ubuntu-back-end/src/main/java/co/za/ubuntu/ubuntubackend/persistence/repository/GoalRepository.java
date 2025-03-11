package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.domain.enums.CategoryType;
import co.za.ubuntu.ubuntubackend.persistence.entity.CategoryEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, Integer> {

}