package co.za.ubuntu.ubuntubackend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class ShortTermGoalDTO {

    private Integer triggerAmount;
    private LocalDate startDate;

}
