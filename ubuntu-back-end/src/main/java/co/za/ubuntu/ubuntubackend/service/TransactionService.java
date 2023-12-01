package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;

import java.util.List;

/**
 * Service interface for managing transactions.
 * <p>
 * This service provides methods to interact with transactions, including creating, retrieving,
 * updating, and deleting transactions.
 *
 * @since 0.0.1
 */
public interface TransactionService {

    /**
     * Creates a new transaction.
     *
     * @param transaction The transaction object to create.
     * @return The created transaction response.
     */
    TransactionResponse createTransaction(Transaction transaction);

    /**
     * Deletes a transaction by its unique identifier.
     *
     * @param id The unique identifier of the transaction to delete.
     */
    void deleteTransaction(Long id);

    /**
     * Retrieves a list of all transactions associated with a user.
     *
     * @param userId The unique identifier of the user.
     * @return A list of transaction responses associated with the user.
     */
    List<TransactionResponse> getAllTransactions(Long userId);

    /**
     * Retrieves a transaction by its unique identifier.
     *
     * @param id The unique identifier of the transaction to retrieve.
     * @return The transaction response object if found; otherwise, null.
     */
    TransactionResponse getTransactionById(Long id);

    /**
     * Updates an existing transaction.
     *
     * @param id The unique identifier of the transaction to update.
     * @param transaction The updated transaction object to save.
     * @return The updated transaction response.
     */
    TransactionResponse updateTransaction(Long id, Transaction transaction);
}

