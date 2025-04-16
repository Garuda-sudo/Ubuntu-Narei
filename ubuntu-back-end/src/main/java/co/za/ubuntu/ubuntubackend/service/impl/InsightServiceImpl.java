package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.Account;
import co.za.ubuntu.ubuntubackend.dto.InsightDTOs.CategoryInsightDTO;
import co.za.ubuntu.ubuntubackend.dto.InsightDTOs.TotalVsSpentInsightDTO;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetCategoryEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.AccountRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.BudgetRepository;
import co.za.ubuntu.ubuntubackend.service.AccountService;
import co.za.ubuntu.ubuntubackend.service.InsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("insightService")
public class InsightServiceImpl implements InsightService {

    AccountRepository accountRepository;

    @Autowired
    BudgetRepository budgetRepository;


    @Override
    public List<TotalVsSpentInsightDTO> getBudgetVsActualSpending(Integer budgetId) {

        TotalVsSpentInsightDTO totalVsSpentInsightDTO = new TotalVsSpentInsightDTO();

        //Get the budget
        BudgetEntity budget = budgetRepository.findById(budgetId).orElseThrow();

        //The total amount allocated for the budget
        BigDecimal totalBudgetAllocatedAmount = budget.getAmountLimit();
        //The amount allocated so far in the budget. Go through the allocated amounts so far
        BigDecimal totalCategorySpend = budget.getBudgetCategories().stream()
            .map(BudgetCategoryEntity::getActualSpent)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        //Calculate the difference
        BigDecimal variance = totalBudgetAllocatedAmount.subtract(totalCategorySpend);

        totalVsSpentInsightDTO.setTitle("Allocated vs Spent Budget"); //Create enum for Insights types
        totalVsSpentInsightDTO.setBudgetedAmount(totalBudgetAllocatedAmount);
        totalVsSpentInsightDTO.setCurrentTotalSpentAmount(totalCategorySpend);
        totalVsSpentInsightDTO.setVariance(variance);
        totalVsSpentInsightDTO.setIsOverBudget(variance.compareTo(BigDecimal.ZERO) < 0);

        return null;
    }

    @Override
    public CategoryInsightDTO getCategoryInsights(Integer budgetId) {
        return null;
    }
}