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
public class BudgetCategoryInsightDTO extends InsightDTO {

    private Long budgetId;
    private String budgetName;
    private BigDecimal allocatedTotal;
    private BigDecimal spentTotal;
    private double percentUsed;
    private List<CategoryInsightDTO> insights;

    private String topSpendingCategory;
    private List<String> underutilizedCategories;
    private List<String> trendingOverspend;
}
