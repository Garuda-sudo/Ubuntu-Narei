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
public class IncomeSplitInsightDTO extends InsightDTO {

    private Long userId;
    private List<BudgetFundingBreakdown> budgetFundingBreakdowns;

    public static class BudgetFundingBreakdown {
        private Long budgetId;
        private String budgetName;
        private BigDecimal totalPlannedFunding;  // Sum of planned contributions from all accounts
        private BigDecimal totalActualFunding;   // Sum of actual amounts spent per account for this budget
        private List<AccountFundingDetail> accountFundingDetails;
    }

    public static class AccountFundingDetail {
        private Long accountId;
        private String accountName;

        private BigDecimal plannedAmount;   // What the user intended to fund this budget with from this account
        private BigDecimal actualSpent;     // How much actually got spent from this account toward this budget

        private double percentageOfPlanned; // actual / planned (%)
        private double percentageOfTotalBudgetSpent; // How much this account contributed relative to total budget spent
    }
}
