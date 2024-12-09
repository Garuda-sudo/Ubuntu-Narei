package co.za.ubuntu.ubuntubackend.persistence.repository;

import co.za.ubuntu.ubuntubackend.persistence.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//TODO: Add back once feature is designed
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
}
