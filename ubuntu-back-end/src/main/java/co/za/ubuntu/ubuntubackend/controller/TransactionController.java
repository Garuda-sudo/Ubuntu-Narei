package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.TransactionApi;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController implements TransactionApi {
    /**
     * @param transaction Transaction object that needs to be added (optional)
     * @return
     */
    @Override
    public ResponseEntity<TransactionResponse> _createTransaction(Transaction transaction) {
        return null;
    }

    /**
     * @param id id of transaction to delete (required)
     * @return
     */
    @Override
    public ResponseEntity<Void> _deleteTransaction(Long id) {
        return null;
    }

    /**
     * @param userId id of user to return transactions for (required)
     * @return
     */
    @Override
    public ResponseEntity<List<TransactionResponse>> _getAllTransactions(Long userId) {
        return null;
    }

    /**
     * @param id id of transaction to return (required)
     * @return
     */
    @Override
    public ResponseEntity<TransactionResponse> _getTransactionById(Long id) {
        return null;
    }

    /**
     * @param id          id of transaction to update (required)
     * @param transaction Transaction object that needs to be updated (optional)
     * @return
     */
    @Override
    public ResponseEntity<TransactionResponse> _updateTransaction(Long id, Transaction transaction) {
        return null;
    }
}
