package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.ubuntubackend.dto.InsightDTOs.BudgetInsightDTO;
import co.za.ubuntu.ubuntubackend.dto.InsightDTOs.IncomeSplitInsightDTO;
import co.za.ubuntu.ubuntubackend.dto.InsightDTOs.SpendingTrendInsightDTO;
import co.za.ubuntu.ubuntubackend.dto.InsightDTOs.TotalVsSpentInsightDTO;

/**
 * Service interface for managing budget insights related to users.
 * <p>
 * This service provides methods to interact with user budget spendings and graph data to display
 * regarding the budget queried.
 *
 * @since 0.0.1
 */

public interface InsightService {

    /**
     * How much has the user spent on the Budget so far vs how much they have budgeted in total
     * @param budgetId
     * @return Two variables within the InsightDTO, those being the budgetedTotal and the currentTotal
     */
    TotalVsSpentInsightDTO getBudgetVsActualSpending(Integer budgetId);

    /**
     * How the specified budgets' categories have been spent relative to the amounts budgeted
     * @param budgetId
     * @return Two variables within the InsightDTO, those being the budgetedTotal and the currentTotal
     */
    BudgetInsightDTO getCategoryInsights(Integer budgetId);

    IncomeSplitInsightDTO getIncomeSplitInsights(Integer accountId);

    SpendingTrendInsightDTO getSpendingTrendInsights(Integer budgetId);

}
