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

    public BigDecimal getBudgetedAmount() {
        return budgetedAmount;
    }

    public void setBudgetedAmount(BigDecimal budgetedAmount) {
        this.budgetedAmount = budgetedAmount;
    }

    public BigDecimal getCurrentTotalSpentAmount() {
        return currentTotalSpentAmount;
    }

    public void setCurrentTotalSpentAmount(BigDecimal currentTotalSpentAmount) {
        this.currentTotalSpentAmount = currentTotalSpentAmount;
    }

    public BigDecimal getVariance() {
        return variance;
    }

    public void setVariance(BigDecimal variance) {
        this.variance = variance;
    }

    public Boolean getOverBudget() {
        return isOverBudget;
    }

    public void setOverBudget(Boolean overBudget) {
        isOverBudget = overBudget;
    }

    public Double getPercentageUsed() {
        return percentageUsed;
    }

    public void setPercentageUsed(Double percentageUsed) {
        this.percentageUsed = percentageUsed;
    }

    public Double getPercentageRemaining() {
        return percentageRemaining;
    }

    public void setPercentageRemaining(Double percentageRemaining) {
        this.percentageRemaining = percentageRemaining;
    }
}
