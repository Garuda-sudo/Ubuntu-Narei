package co.za.ubuntu.ubuntubackend.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class BudgetEntity {
    @Id
    private UUID id;
    private String name;
    private LocalDate dateCreated;
    private String goals;
}
