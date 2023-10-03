package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.Transactionbudget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionbudgetRepository extends JpaRepository<Transactionbudget, Integer> {
}