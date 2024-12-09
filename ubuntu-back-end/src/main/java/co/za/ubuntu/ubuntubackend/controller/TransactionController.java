package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.TransactionApi;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.ubuntubackend.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController implements TransactionApi {

    TransactionService transactionService;

    /**
     * @param transaction Transaction object that needs to be added (optional)
     * @return
     */
    @Override
    public ResponseEntity<TransactionResponse> createTransaction(Transaction transaction) {

        //Get the actual budget ID from the transaction object
        transactionService.createTransaction(1L, transaction);

        return null;
    }

    /**
     * @param id id of transaction to delete (required)
     * @return
     */
    @Override
    public ResponseEntity<Void> deleteTransaction(Long id) {
        return null;
    }

    /**
     * @param userId id of user to return transactions for (required)
     * @return
     */
    @Override
    public ResponseEntity<List<TransactionResponse>> getAllTransactions(Long userId) {
        return null;
    }

    /**
     * @param id id of transaction to return (required)
     * @return
     */
    @Override
    public ResponseEntity<TransactionResponse> getTransactionById(Long id) {
        return null;
    }

    /**
     * @param id          id of transaction to update (required)
     * @param transaction Transaction object that needs to be updated (optional)
     * @return
     */
    @Override
    public ResponseEntity<TransactionResponse> updateTransaction(Long id, Transaction transaction) {
        return null;
    }

    /**
     * @param id          id of transaction to update (required)
     * @param transaction Transaction object that needs to be updated (optional)
     */
    //End point to add transaction to a budget
}
