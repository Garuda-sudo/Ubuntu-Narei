package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;

import java.util.List;

/**
 * Service interface for managing budgets related to users.
 * <p>
 * This service provides methods to interact with user budgets, including retrieving, creating,
 * updating, and deleting budgets.
 *
 * @since 0.0.1
 */
public interface BudgetService {

    /**
     * Retrieves a list of budgets associated with a user.
     *
     * @param userId The unique identifier of the user.
     * @return A list of budgets associated with the user.
     */
    List<BudgetResponse> getUserBudgets(Integer userId);

    /**
     * Retrieves a budget by its unique identifier.
     *
     * @param budgetId The unique identifier of the budget to retrieve.
     * @return The budget object if found; otherwise, null.
     */
    BudgetResponse getBudget(Integer budgetId);

    /**
     * Creates a new budget.
     *
     * @param budget The budget object to create.
     */
    BudgetResponse createBudget(Budget budget);

    /**
     * Updates an existing budget.
     *
     * @param budget The updated budget object to save.
     */
    void updateBudget(Budget budget);

    /**
     * Deletes a budget by its unique identifier.
     *
     * @param budgetId The unique identifier of the budget to delete.
     */
    void deleteBudget(Integer budgetId);
}
