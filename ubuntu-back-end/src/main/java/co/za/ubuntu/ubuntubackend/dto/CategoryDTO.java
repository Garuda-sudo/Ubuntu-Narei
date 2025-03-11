package co.za.ubuntu.ubuntubackend.dto;

import co.za.ubuntu.ubuntubackend.domain.enums.CategoryType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private Integer categoryId;
    private CategoryType categoryType;
    private String categoryName;

    private BigDecimal totalAmount;
    private Integer budgetId;

    private String notes;
    private Integer priorityLevel;

    private ShortTermGoalDTO shortTermGoalDTO;

    //For joint budgets specifically
    private Map<Integer, BigDecimal> userAmountSplits;
}
