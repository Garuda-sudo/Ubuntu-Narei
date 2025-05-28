package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.ubuntubackend.domain.exception.NotFoundException;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetCategoryEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.CategoryEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.TransactionEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.AccountRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.BudgetRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.TransactionRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.UserRepository;
import co.za.ubuntu.ubuntubackend.service.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;
    UserRepository userRepository;
    AccountRepository accountRepository;
    BudgetRepository budgetRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  UserRepository userRepository,
                                  AccountRepository accountRepository,
                                  BudgetRepository budgetRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.budgetRepository = budgetRepository;
    }

    @Override
    @Transactional
    public TransactionResponse createTransaction(Long budgetId, Transaction transaction) {

        //TODO: NB! Any changes via a transaction HAS to update the respective actualSpend value on the budgetCategory
        // entity and this is enforced on the domain design level. The actualSpend field may only be affected via a
        // transaction.

        //TODO: The flow: The transaction object should have the budget ID. This budget ID
        // is linked to the new transaction.
        Instant currentDateTime = Instant.now();

        //Get the budget and link it to the transaction
        BudgetEntity budgetEntity = budgetRepository.findById(budgetId.intValue()).orElseThrow();

        //Create transaction object to save away
        TransactionEntity transactionEntity = new TransactionEntity();
        //TODO: The budget category needs to be set for every transaction
        //transactionEntity.setBudget(budgetEntity);
        transactionEntity.setAmount(BigDecimal.valueOf(transaction.getAmount()));
        transactionEntity.setDate(currentDateTime);
        //transactionEntity.setUserEntity(budgetEntity.getUserEntity());
        transactionEntity.setCurrency("ZAR"); //TODO: Need to add currency enums
        //transactionEntity.setCategoryEntity(new CategoryEntity()); //TODO: Add category data
//        transactionEntity.setBudgets(
//            Stream.of(budgetEntity).collect(Collectors.toCollection(HashSet::new))
//        );

        //Add transaction to budget
        //The transaction will be linked to the budget category so it needs to be added there
        budgetEntity.getBudgetCategories().stream().map(BudgetCategoryEntity::getTransactions).collect(Collectors.toList()); //TODO

        //Cascade should flush linked budget to the transaction entity when saving to the database
        var response = transactionRepository.save(transactionEntity);

        //Convert to DTO
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setAmount(response.getAmount().doubleValue());
        transactionResponse.setUserId(transactionResponse.getUserId());
        transactionResponse.setDate(currentDateTime.atZone(ZoneId.systemDefault()).toLocalDateTime());

        return transactionResponse;
    }

    @Override
    public void deleteTransaction(Long id) {

        //TODO: NB! Any changes via a transaction HAS to update the respective actualSpend value on the budgetCategory
        // entity and this is enforced on the domain design level. The actualSpend field may only be affected via a
        // transaction.

        TransactionEntity transactionEntity = transactionRepository.findById(id.intValue()).orElseThrow();

        //Transactions should be soft deleted
        //Set is Deleted column to true


    }

    @Override
    @Transactional
    public List<TransactionResponse> getAllUserTransactions(Long userId) {

//        Set<TransactionEntity> transactionEntities = transactionRepository.findByUser(userId.intValue());
//
//        var transactions = transactionEntities.stream().map(
//            transactionEntity -> {
//
//                TransactionResponse transactionResponse = new TransactionResponse();
//                transactionResponse.setAmount(transactionEntity.getAmount().doubleValue());
//
//
//                return transactionResponse;
//            }
//        ).toList();
//
//        return new ArrayList<>(transactions);
        return null;
    }

    @Override
    public TransactionResponse getTransactionById(Long id) {

        TransactionEntity transactionEntity = transactionRepository.findById(id.intValue()).orElseThrow();
        return null;
    }

    @Override
    public TransactionResponse updateTransaction(Long id, Transaction transaction) {

        //TODO: NB! Any changes via a transaction HAS to update the respective actualSpend value on the budgetCategory
        // entity and this is enforced on the domain design level. The actualSpend field may only be affected via a
        // transaction.

        //TODO: In the current case, only the last update can be seen. Do we need to have the entire history
        // of updates, as this will change the implementation?

        TransactionEntity transactionEntity = transactionRepository.findById(id.intValue()).orElseThrow();

        //DTO to domain. Tedious in the beginning but will help in the long run

        //Domain to DTO and persist

        return null;
    }

}
