package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
}