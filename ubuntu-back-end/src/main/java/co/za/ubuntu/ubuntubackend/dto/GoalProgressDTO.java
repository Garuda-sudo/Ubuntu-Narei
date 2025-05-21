package co.za.ubuntu.ubuntubackend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class GoalProgressDTO {

    private LocalDate startDate;
    private LocalDate endDate;

}
