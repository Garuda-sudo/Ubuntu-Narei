package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    @Query(value = "Select a.* from budgetbuddy.account a " +
        "inner join budgetbuddy.user u on u.id = a.user_id " +
        "where u.id in :userIds", nativeQuery = true)
    public Set<AccountEntity> findByUserId(@Param("userIds") List<Integer> userIds);
}