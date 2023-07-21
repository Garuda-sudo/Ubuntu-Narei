package co.za.ubuntu.ubuntubackend.persistence;

import co.za.ubuntu.ubuntubackend.persistence.entity.GroupEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {
}
