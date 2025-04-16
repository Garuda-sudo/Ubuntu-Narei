package co.za.ubuntu.ubuntubackend.dto;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.ubuntubackend.domain.enums.RolloverType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class DiscountDTO {

    private LocalDate startDate;
    private LocalDate endDate;
    private String discountType;

    //Short term goal details
    private Integer shortTermGoalId;
    private Integer budgetId;
    private Integer budgetCategoryId;
    private Integer userId;

    //Long term goal details
    private Integer longTermGoalId;
    private List<Integer> userIds;

}
