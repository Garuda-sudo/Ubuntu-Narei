package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.ubuntubackend.dto.InsightDTOs.*;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetCategoryEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.AccountRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.BudgetRepository;
import co.za.ubuntu.ubuntubackend.service.InsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service("insightService")
public class InsightServiceImpl implements InsightService {

    AccountRepository accountRepository;

    @Autowired
    BudgetRepository budgetRepository;


    @Override
    public TotalVsSpentInsightDTO getBudgetVsActualSpending(Integer budgetId) {

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

        Double percentageUsed = totalCategorySpend
            .divide(totalBudgetAllocatedAmount, 2, RoundingMode.HALF_UP) // divide to 2 decimal places
            .multiply(BigDecimal.valueOf(100)).doubleValue();
        totalVsSpentInsightDTO.setPercentageUsed(percentageUsed);

        Double percentageRemaining = totalBudgetAllocatedAmount
            .subtract(totalCategorySpend)
            .divide(totalBudgetAllocatedAmount, 2, RoundingMode.HALF_UP)
            .multiply(BigDecimal.valueOf(100)).doubleValue();
        totalVsSpentInsightDTO.setPercentageRemaining(percentageRemaining);

        return totalVsSpentInsightDTO;
    }

    @Override
    public BudgetInsightDTO getCategoryInsights(Integer budgetId) {

        //Given the single budget or joint budget get all the categories linked
        BudgetEntity budget = budgetRepository.findById(budgetId).orElseThrow();
        Set<BudgetCategoryEntity> budgetCategories = budget.getBudgetCategories();

        //Create a custom DTO to return a map which gives a category and its respective amount
        BigDecimal totalBudgetAllocated = budget.getAmountLimit();
        BigDecimal totalBudgetSpent = budgetCategories.stream()
            .map(BudgetCategoryEntity::getActualSpent)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<CategoryInsightDTO> categoryInsights = budgetCategories.stream().map(budgetCategory -> {
            BigDecimal allocated = budgetCategory.getAllocatedAmount();
            BigDecimal spent = Optional.ofNullable(budgetCategory.getActualSpent()).orElse(BigDecimal.ZERO);

            double percentOfTotalBudget = allocated
                .divide(totalBudgetAllocated, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();

            double percentOfAllocatedUsed = spent
                .divide(allocated, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();

            double percentOfTotalSpent = 0.0;

            if (totalBudgetSpent.compareTo(BigDecimal.ZERO) > 0) {
                percentOfTotalSpent = spent
                    .divide(totalBudgetSpent, 4, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100))
                    .doubleValue();
            }

            CategoryInsightDTO insight = new CategoryInsightDTO();
            insight.setName(budgetCategory.getCategory().getName());
            insight.setAllocatedAmount(allocated);
            insight.setActualSpent(spent);
            insight.setPercentOfTotalBudget(percentOfTotalBudget); //how much of the total allocated budget was assigned to this category
            insight.setPercentOfAllocatedUsed(percentOfAllocatedUsed); //how much of the category’s own budget has been used
            insight.setPercentageOfTotalSpent(percentOfTotalSpent);

            return insight;
        }).collect(Collectors.toList());

        BudgetCategoryInsightDTO result = new BudgetCategoryInsightDTO();
        result.setInsights(categoryInsights);

        //Add the percentage for each category relative to the entire budget spent so far

        //Add percentage of total allocated budget for each category vs the total allocated budget

        //Give a map/DTO of the amount spent vs the amount allocated for each category

        return null;
    }

    @Override
    public IncomeSplitInsightDTO getIncomeSplitInsights(Integer accountId) {
        return null;
    }

    @Override
    public SpendingTrendInsightDTO getSpendingTrendInsights(Integer budgetId) {

        //Spending trend for a budget over a given period e.g. 3 months, 9 months etc

        //Get all archived/active budgets for the given budget over a time period
        Set<BudgetEntity> budgetVersions = budgetRepository.findAllBudgetVersions(budgetId).orElseThrow();

        SpendingTrendInsightDTO spendingTrendInsightDTO = new SpendingTrendInsightDTO();
        spendingTrendInsightDTO.setBaseBudgetName("Example"); //Might need to get the latest budget
        // version name for ultimate accuracy

        //For the period, get the amount spent across the entire budgets as well as for each
        //category over the budget period and add them to the overall spending insight DTO
        List<BudgetVersionSummaryDTO> budgetVersionSummaryDTOList = new ArrayList<>();
        budgetVersions.forEach(
            budgetEntity -> {

                //Now create the trend specific info for each budget version
                BudgetVersionSummaryDTO budgetVersionSummaryDTO = new BudgetVersionSummaryDTO();
                budgetVersionSummaryDTO.setVersionName(budgetEntity.getBudgetName());
                budgetVersionSummaryDTO.setVersionId(budgetEntity.getVersionNumber());
                budgetVersionSummaryDTO.setStartDate(budgetEntity.getStartDate());
                budgetVersionSummaryDTO.setEndDate(budgetEntity.getEndDate());
                budgetVersionSummaryDTO.setTotalPlanned(budgetEntity.getAmountLimit());
                budgetVersionSummaryDTO.setTotalActual(budgetEntity.getTotalActualAmountSpent());

                budgetVersionSummaryDTOList.add(budgetVersionSummaryDTO);

            }
        );

        spendingTrendInsightDTO.setBudgetVersions(budgetVersionSummaryDTOList);

        return null;
    }
}