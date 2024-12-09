package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.*;
import co.za.ubuntu.ubuntubackend.domain.exception.NotFoundException;
import co.za.ubuntu.ubuntubackend.persistence.entity.AccountEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.TransactionEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.AccountRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.BudgetRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.TransactionRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.UserRepository;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service("budgetService")
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;

    /**
     * @param accountId The unique identifier of the user.
     * @return List<Budget>
     */
    @Override
    public List<BudgetResponse> getUserBudgets(Integer accountId) {
        AccountEntity accountEntity = accountRepository.findById(accountId).orElseThrow(
            () -> new NotFoundException("No user found with account ID: " + accountId)
        );

        Set<BudgetEntity> budgetEntities =
            budgetRepository.findBudgetEntitiesByAccountIds(List.of(accountId)).orElseThrow(
                () -> new NotFoundException("No budgets found for user with account ID: " + accountId)
        );

        List<BudgetResponse> budgetResponses = new ArrayList<>();

        budgetEntities.forEach(
            budget -> {
                //map to domain DTO
                BudgetResponse budgetResponse = new BudgetResponse();
                budgetResponse.setName(budget.getBudgetName());

                budgetResponses.add(budgetResponse);
            }
        );

        return budgetResponses;
    }

    /**
     * @param budgetId The unique identifier of the budget to retrieve.
     * @return Budget
     */
    @Override
    public BudgetResponse getBudget(Integer budgetId) {
        BudgetEntity budgetEntity = budgetRepository.findById(budgetId).orElseThrow(
                () -> new NotFoundException("No budget found with ID: " + budgetId)
        );

//        return budgetDomainMapper.map(budgetMapper.map(budgetEntity));
        BudgetResponse budgetResponse = new BudgetResponse();
        budgetResponse.setAmountLimit(budgetEntity.getAmountLimit().doubleValue());
        budgetResponse.setName(budgetEntity.getBudgetName());

        return budgetResponse;
    }

    /**
     * @param budget The budget object to create.
     */
    @Override
    @Transactional
    public BudgetResponse createBudget(Budget budget) {

        var user = userRepository.findById(budget.getUserId()).orElseThrow();

        //TODO: Get the accounts linked to this budget as well
        Set<AccountEntity> userAccounts =
            accountRepository.findByUserId(budget.getAccounts().stream().map(account -> account.getId().intValue()).collect(Collectors.toList()));;

        budget.setAccounts(userAccounts.stream().map(this::domainToDTO).collect(Collectors.toList()));

        var savedBudget = budgetRepository.save(dtoToDomain(budget));

        //map entity to DTO
        BudgetResponse budgetResponse = new BudgetResponse();
        budgetResponse.setAmountLimit(savedBudget.getAmountLimit().doubleValue());

        return budgetResponse;
    }

    /**
     * @param budget The updated budget object to save.
     */
    @Override
    @Transactional
    public void updateBudget(Budget budget) {

        var be = budgetRepository.findById(Math.toIntExact(budget.getId()));

        if (be.isEmpty()) {
            throw new NotFoundException("Budget with id %s not found" + budget.getId());
        }

        var budgetEntity = be.get();
        budgetEntity.setBudgetName(budget.getName());
        budgetEntity.setAmountLimit(BigDecimal.valueOf(budget.getAmountLimit()));

        budgetRepository.save(budgetEntity);
    }

    /**
     * @param budgetId The unique identifier of the budget to delete.
     */
    @Override
    public void deleteBudget(Integer budgetId) {

        //TODO: Data should be soft deleted and not hard deleted
        budgetRepository.deleteById(budgetId);

    }

    @Override
    @CacheEvict(value="budgetTransactions", allEntries=true)
    @Transactional
    public TransactionResponse addTransactionToBudget(Long budgetId, Transaction transaction) {

        //find the budget you want to add transaction to
        BudgetEntity budgetEntity = budgetRepository.findById(Math.toIntExact(budgetId)).orElseThrow(
            () -> new NotFoundException("No budget found with ID: " + budgetId)
        );

        //Create transaction and add it to budget
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(BigDecimal.valueOf(transaction.getAmount()));
        //transactionEntity.setAccountEntity(budgetEntity.getAccount()); //Get accounts linked to user
        //transactionEntity.setUserEntity(budgetEntity.getUserEntity());
        //transactionEntity.getBudgets().add(budgetEntity);

        //We need to link the transaction to the respective budget
        budgetEntity.getTransactions().add(transactionEntity);

        var response = transactionRepository.save(transactionEntity);

        return this.domainToDTO(response);
    }

    @Override
    @Cacheable("budgetTransactions")
    @Transactional
    public List<TransactionResponse> getBudgetTransactions(Long budgetId) {

        var transactions = transactionRepository.findByBudget(Math.toIntExact(budgetId)).orElseThrow();

        return transactions.stream()
            .map(this::domainToDTO)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void linkBudgetToAccount(Long budgetId, Long accountId) {

        //get account
        AccountEntity accountEntity = accountRepository.findById(Math.toIntExact(accountId))
            .orElseThrow(
                () -> new NotFoundException("No account found with id: " + accountId)
            );

        //Get budget
        BudgetEntity budgetEntity = budgetRepository.findById(Math.toIntExact(budgetId))
            .orElseThrow(
                () -> new NotFoundException("No budget found with id: " + budgetId)
            );

        //Converting domain to DTO object
        Account account = new Account();
        //account.setId(accountEntity.getId().longValue());;
        //Bidirectional relationship so the budget must be added to the account as well
        account.setBudgets(accountEntity.getBudgets().stream().map(
                this::domainToDTO
        ).collect(Collectors.toList()));
        //account.setBalance(accountEntity.getBalance());
        //TODO: Budget to accounts are a many-to-many relationship now. Need to update the DTO
        //budget.setAccount(account);

        accountRepository.save(accountEntity);
    }

    @Override
    public BigDecimal budgetTransact(BigDecimal amount, Long budgetId, Category category) {

        //Flow: The payment gateway lets the user deposit funds into their account

        //If the user wants to directly subtract payments/debit orders from the pools,
        //they can give the account details and the payments will automatically be subtracted

        return null;
    }

    private TransactionResponse domainToDTO(TransactionEntity transactionEntity) {

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setId(transactionEntity.getId().longValue());
        transactionResponse.setAmount(transactionEntity.getAmount().doubleValue());
        //transactionResponse.setUserId(transactionEntity.getUserEntity().getId());

        return transactionResponse;
    }

    private Budget domainToDTO(BudgetEntity budgetEntity) {

        Budget budget = new Budget();
        budget.setId(budgetEntity.getId().longValue());
        budget.setName(budgetEntity.getBudgetName());
        budget.setPeriodType(PeriodType.fromValue(budgetEntity.getPeriodType()));

        return budget;
    }

    private BudgetEntity dtoToDomain(Budget budget) {

        //Map DTO to entity & Re-factor mappers
        BudgetEntity budgetEntity = new BudgetEntity();
        budgetEntity.setBudgetName(budget.getName());
        budgetEntity.setAmountLimit(BigDecimal.valueOf(budget.getAmountLimit()));
        budgetEntity.setPeriodType(budget.getPeriodType().getValue());
        budgetEntity.setStartDate(budget.getStartDate().toLocalDate());
        budgetEntity.setEndDate(budget.getEndDate().toLocalDate());
        budgetEntity.setDateCreated(new Date());
        //TODO: This must only be updated on update to a budget. Need a flag of some sort
        budgetEntity.setDateUpdated(new Date());
        //budgetEntity.setUserEntity(user);
        //budgetEntity.setAccount();
        return budgetEntity;
    }

    private AccountEntity dtoToDomain(Account account) {

        AccountEntity accountEntity = new AccountEntity();

        return null;

    }

    private Account domainToDTO(AccountEntity accountEntity) {

        Account account = new Account();

        return account;

    }
}
