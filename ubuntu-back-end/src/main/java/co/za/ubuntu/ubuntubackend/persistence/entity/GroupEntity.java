package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class GroupEntity {
    @Id
    private UUID id;
}