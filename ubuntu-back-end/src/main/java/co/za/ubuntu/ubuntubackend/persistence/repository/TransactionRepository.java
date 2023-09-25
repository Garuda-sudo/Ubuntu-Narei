package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}