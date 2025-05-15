package co.za.ubuntu.ubuntubackend.dto.InsightDTOs;

import co.za.ubuntu.ubuntubackend.dto.InsightDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class CategoryInsightDTO {

    private Long categoryId;
    private String name;
    private BigDecimal allocatedAmount;
    private BigDecimal actualSpent;

    private Double percentOfTotalBudget;      // allocatedAmount / totalBudgeted * 100
    private Double percentOfAllocatedUsed;    // actualSpent / allocatedAmount * 100
    private Double percentageOfTotalSpent;       // actualSpent / totalSpent * 100

    private boolean isOverBudget;
    private Double percentageChange; // trend: change compared to previous budget period
}
