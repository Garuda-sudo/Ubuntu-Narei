package co.za.ubuntu.ubuntubackend.services;


import co.za.ubuntu.ubuntubackend.domain.Budget;
import co.za.ubuntu.ubuntubackend.domain.BudgetRequest;
import co.za.ubuntu.ubuntubackend.domain.User;

import java.util.UUID;

public interface BudgetService {

    public Budget createBudget(BudgetRequest budgetRequest);

    public Budget getBudget(UUID budgetId);

    public Budget updateBudget(BudgetRequest budgetRequest, UUID budgetId);

    public void deleteBudget(UUID budgetId);
}
