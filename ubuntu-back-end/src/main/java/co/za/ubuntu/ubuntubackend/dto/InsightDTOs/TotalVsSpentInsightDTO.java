package co.za.ubuntu.ubuntubackend.dto.InsightDTOs;

import co.za.ubuntu.ubuntubackend.dto.InsightDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
public class TotalVsSpentInsightDTO extends InsightDTO {

    private BigDecimal budgetedAmount;
    private BigDecimal currentTotalSpentAmount;
    //Difference between total budgeted and total spent
    private BigDecimal variance;
    private Boolean isOverBudget;
    private Double percentageUsed;
    private Double percentageRemaining;
}
