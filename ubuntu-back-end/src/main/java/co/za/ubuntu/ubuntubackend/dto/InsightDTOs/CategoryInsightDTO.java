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
public class CategoryInsightDTO extends InsightDTO {

    private List<BudgetCategorySummary> dataPoints;

    public static class BudgetCategorySummary {
        private Long budgetId;
        private String budgetName;
        private List<CategorySummaryItem> categories;
    }

    public static class CategorySummaryItem {
        private Long categoryId;
        private String name;
        private BigDecimal spentAmount;
        private BigDecimal budgetedAmount;
        private boolean isOverBudget;
        private BigDecimal percentageChange; // for trends
    }

}