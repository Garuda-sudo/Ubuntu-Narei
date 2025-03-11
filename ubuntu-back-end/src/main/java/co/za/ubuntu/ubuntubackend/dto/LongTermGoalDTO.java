package co.za.ubuntu.ubuntubackend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class LongTermGoalDTO {

    private Integer goalId;
    private BigDecimal targetAmount;
    private LocalDate targetDate;
    private String description;
    private String goalName;

}
