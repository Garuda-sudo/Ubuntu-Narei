package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
     * @param accountId The unique identifier of the user.
     * @return A list of budgets associated with the user.
     */
    List<BudgetResponse> getUserBudgets(Integer accountId);

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

    /**
     * This will allow an user to directly use funds they have allocated to their various budget
     * categories to make payments. Essentially, the beginning of an e-wallet journey. This lets
     * users add their debit orders as well, which will then reflect their running balance. E.g.
     * If they want to pay their netflix debit order from Budget Buddy they can make it directly
     * deduct it from their subscriptions pool lets say.
     * @param amount
     * @param budgetId
     * @param category
     * @return
     */
    BigDecimal budgetTransact(BigDecimal amount, Long budgetId, Category category);
}
