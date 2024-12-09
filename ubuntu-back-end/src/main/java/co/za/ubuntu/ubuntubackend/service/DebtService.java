package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.ubuntubackend.domain.UserDebt;

import java.util.List;

/**
 * Service interface for managing debts related to users.
 * <p>
 * This service provides methods to interact with user budgets, including retrieving, creating,
 * updating, and deleting budgets.
 *
 * @since 0.0.1
 */

public interface DebtService {

    /**
     * Retrieves a list of budgets associated with a user.
     *
     * @param userId The unique identifier of the user.
     * @return A list of the debts associated with the user.
     */
    List<UserDebt> getUserDebts(Integer userId);

    /**
     * Retrieves a a user's debt by its unique identifier.
     *
     * @param userDebtId The unique identifier of the budget to retrieve.
     * @return The budget object if found; otherwise, null.
     */
    UserDebt getBudget(Integer userDebtId);

    /**
     * Creates a new user debt.
     *
     * @param userDebt The budget object to create.
     */
    BudgetResponse createDebt(UserDebt userDebt);

    /**
     * Updates an existing budget.
     *
     * @param budget The updated budget object to save.
     */
    void updateBudget(Budget budget);

    /**
     * Deletes a budget by its unique identifier.
     *
     * @param userDebtId The unique identifier of the budget to delete.
     */
    void deleteUserDebt(Integer userDebtId);

    /**
     * @param budgetId budget to add transaction to
     * @param transaction Transaction domain object
     * @return
     */
    TransactionResponse addTransactionToBudget(Long budgetId, Transaction transaction);

    List<TransactionResponse> getBudgetTransactions(Long budgetId);

    /**
     * When a budget needs to be linked to an account
     * @param budgetId
     * @param accountId
     */
    void linkBudgetToAccount(Long budgetId, Long accountId);
}
