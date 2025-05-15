package co.za.ubuntu.ubuntubackend.dto.InsightDTOs;

import co.za.ubuntu.ubuntubackend.dto.InsightDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class BudgetInsightDTO extends InsightDTO {

    private Long budgetId;
    private String budgetName;
    private BigDecimal totalBudgeted;
    private BigDecimal totalSpent;
    private Double overallPercentageSpent; // totalSpent / totalBudgeted * 100
    private LocalDate startDate;
    private LocalDate endDate;

    private List<CategoryInsightDTO> insights;

    // Optional high-level metadata
    private CategoryInsightDTO highestSpendingCategory;
    private List<CategoryInsightDTO> underUtilizedCategories;
    private List<CategoryInsightDTO> trendingTowardsOverspend;

}