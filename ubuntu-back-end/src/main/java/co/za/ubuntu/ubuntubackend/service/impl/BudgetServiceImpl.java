package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.*;
import co.za.ubuntu.ubuntubackend.domain.enums.GoalType;
import co.za.ubuntu.ubuntubackend.domain.exception.NotFoundException;
import co.za.ubuntu.ubuntubackend.dto.AccountSplitDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetIncomeSplitDTO;
import co.za.ubuntu.ubuntubackend.persistence.entity.*;
import co.za.ubuntu.ubuntubackend.persistence.repository.*;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
    @Autowired
    BudgetIncomeSplitRepository budgetIncomeSplitRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GoalRepository goalRepository;

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
    public BudgetResponse createBudget(BudgetDTO budget) {

        //What is the purpose of a budget. A budget needs to give someone the ability to plan
        //their financial plan over a set period of time. This financial plan allows them to
        //take their monthly income and allocate it to expected expense categories and then track
        //throughout the planned period how much they have used from each category.

        //When creating a budget, we need the total amount from the income they have allocated to it.
        //We then want to split up the income allocated to firstly the bills category. The front end
        //makes the UI where it takes the user through the flow. The next category will be investments.
        //Thirdly any debt they would like to tackle. Something they would like to save toward, like a
        //short term goal. Lastly, the entertainment categories for what the user would like to spend on.



        //Create the budget
        BudgetEntity budgetEntity = new BudgetEntity();

        if (budget.getStartDate().isAfter(budget.getEndDate())) {
            try {
                throw new Exception("Start date must be before end date");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //TODO: Refactor all this to the dtoToDomain method
        budgetEntity.setBudgetName(budget.getName());
        budgetEntity.setAmountLimit(BigDecimal.valueOf(budget.getAmountLimit()));
        budgetEntity.setDateCreated(Date.from(Instant.now()));
        budgetEntity.setStartDate(budget.getStartDate());
        budgetEntity.setEndDate(budget.getEndDate());
        budgetEntity.setStatus(true);


        //We need to get which user is creating the budget
        UserEntity user = userRepository.findById(budget.getUserId()).orElseThrow();
        budgetEntity.setUserEntity(user);

        //========================== Set the Budget Income Split =============================================//

        //We then need to see which accounts they are linking to this budget. The front end should calculate
        //how much from each account they would like to use and the back end should receive in the DTO how
        //the split is. The budget will link to income split entities that reflect how much of an account is
        //funding the respective budget. An account can have multiple income sources within it each with its
        //own respective allocation amount & percentage.
        List<AccountSplitDTO> accountSplitDTOS = budget.getBudgetIncomeSplit().getAccounts();

        List<AccountEntity> accounts =
            accountRepository.findAllById(accountSplitDTOS.stream().map(AccountSplitDTO::getAccountId).collect(Collectors.toList()));

        //Create a map of the account ID and the respective account entity
        Map<Integer, AccountEntity> accountMap = new HashMap<>();
        accounts.forEach(
            accountEntity -> accountMap.put(accountEntity.getId(), accountEntity)
        );

        List<BudgetIncomeSplitEntity> budgetIncomeSplitEntities = new ArrayList<>();

        accountSplitDTOS.forEach(
            //Create each income budget split entity
            accountSplitDTO -> {
                BudgetIncomeSplitEntity budgetIncomeSplitEntity = new BudgetIncomeSplitEntity();

                if (accountMap.containsKey(accountSplitDTO.getAccountId())) {
                    budgetIncomeSplitEntity.setAccount(accountMap.get(accountSplitDTO.getAccountId()));
                    budgetIncomeSplitEntity.setSplitType();
                    budgetIncomeSplitEntity.setIncomeAmount();
                } else {
                    throw new RuntimeException(
                        "User not linked to given Account ID");
                }

                budgetIncomeSplitEntities.add(budgetIncomeSplitEntity);
            }
        );

        budgetEntity.setBudgetIncomeSplitEntity(budgetIncomeSplitEntities);

        //========================== Set the Long Term Goal =============================================//

        //A Goal is the holistic and micro reason why a user will save towards something. A holistic
        //goal is when a user takes multiple budgets to save towards something. A micro goal is when
        //a user attaches it to a budget line item and once they actively make progress towards it
        //throughout the month, they will get discount codes. For joint budgeting, when a group budgets
        //to spend a total amount, the discounts will be higher based on how much the total group
        //budgets towards. Once they get to a pre-allocated amount in spending and have the goal set
        //a coupon will be given to be used at partnered stores.

        List<GoalEntity> longTermGoals = new ArrayList<>(goalRepository.findAllById(budget.getLongTermGoalIds().stream().filter(Objects::nonNull).collect(Collectors.toList())));

        budget.getLongTermGoals().forEach(
            longTermGoalDTO -> {

                if (longTermGoals.stream().noneMatch(goal -> goal.getName().equals(longTermGoalDTO.getGoalName()))) {
                    GoalEntity goalEntity =  new GoalEntity();
                    goalEntity.setGoalType(GoalType.LONG_TERM);
                    goalEntity.setName(longTermGoalDTO.getGoalName());
                    goalEntity.setTargetAmount(longTermGoalDTO.getTargetAmount());
                    goalEntity.setTargetDate(longTermGoalDTO.getTargetDate());
                    goalEntity.setDescription(longTermGoalDTO.getDescription());

                    longTermGoals.add(goalEntity);
                } else {
                    throw new RuntimeException("Cant have more than one Goal of the same name");
                }

            }
        );

        budgetEntity.setLongTermGoals(longTermGoals);

        //======================= Set the Category Line Expense & Short Term Goals =============//

        /**
         * This is where we set each category line item sent from the front end how much the user
         * wants to spend per category for the specified budget period.
         */

        List<BudgetCategoryEntity> budgetCategoryEntities = new ArrayList<>();

        budget.getCategoryDTO().forEach(
            categoryDTO -> {
                BudgetCategoryEntity budgetCategoryEntity = new BudgetCategoryEntity();
                CategoryEntity categoryEntity;

                //Check for preset or custom category
                if (categoryDTO.getCategoryId() != null) {
                    categoryEntity = categoryRepository.findById(categoryDTO.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Category not Found"));
                } else {
                    categoryEntity = new CategoryEntity();
                    categoryEntity.setUserEntity(user);
                    categoryEntity.setName(categoryDTO.getCategoryName());
                    categoryEntity.setDateCreated(Instant.from(LocalDate.now()));
                    categoryEntity.setPriorityLevel(categoryDTO.getPriorityLevel());
                }

                budgetCategoryEntity.setCategory(categoryEntity);
                budgetCategoryEntity.setBudget(budgetEntity);
                budgetCategoryEntity.setAllocatedAmount(categoryDTO.getTotalAmount());
                budgetCategoryEntity.setActualSpent(new BigDecimal("0.0"));
                budgetCategoryEntity.setNotes(categoryDTO.getNotes());
                budgetCategoryEntity.setPriorityLevel(categoryDTO.getPriorityLevel());

                //Set short-term goals for each category
                GoalEntity shortTermGoal = new GoalEntity();

                shortTermGoal.setGoalType(GoalType.SHORT_TERM);
                shortTermGoal.setTriggerPercentage(categoryDTO.getShortTermGoalDTO().getTriggerAmount());

                budgetCategoryEntity.setShortTermGoal(shortTermGoal);

                budgetCategoryEntities.add(budgetCategoryEntity);
            }
        );

        budgetEntity.setBudgetCategories(new HashSet<>(budgetCategoryEntities));

        //========================== Set the Budget rollover settings ============================//
        if (budget.getAutoRollover() != null && budget.getRolloverType() != null) {
            budgetEntity.setAutoRollover(true);
            budgetEntity.setRolloverType(budget.getRolloverType());
        }

        var savedBudget = budgetRepository.save(budgetEntity);

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
    public void updateBudgetIncomeSplit(BudgetIncomeSplitDTO budgetIncomeSplitDTO) {

        //Link each budget passed to the accounts funding the budget
        if (budgetIncomeSplitDTO.getBudgetId() != null && !budgetIncomeSplitDTO.getAccounts().isEmpty()) {

            //Return all accounts linked to a budget and their respective splits
            List<BudgetIncomeSplitEntity> budgetIncomeSplitEntities =
                budgetIncomeSplitRepository.findByBudgetId(budgetIncomeSplitDTO.getBudgetId().longValue()).orElseThrow();

            Set<Long> accountIdsToUpdate = budgetIncomeSplitDTO.getAccounts().stream()
                .map(accountSplitDTO -> accountSplitDTO.getAccountId().longValue())
                .collect(Collectors.toSet());

            Set<BudgetIncomeSplitEntity> updatedBudgetIncomeSplits = budgetIncomeSplitEntities.stream()
                .filter(
                    budgetIncomeSplitEntity ->  accountIdsToUpdate.contains(budgetIncomeSplitEntity.getAccount().getId().longValue())
                ).peek(budgetIncomeSplitEntity -> {
                    budgetIncomeSplitDTO.getAccounts().stream()
                        .filter(accountSplitDTO -> Objects.equals(accountSplitDTO.getAccountId(), budgetIncomeSplitEntity.getAccount().getId()))
                        .findFirst()
                        .ifPresent(accountSplitDTO -> {
                            budgetIncomeSplitEntity.setSplitType(accountSplitDTO.getSplitType());
                            budgetIncomeSplitEntity.setIncomeAmount(accountSplitDTO.getIncomeAmount());
                            budgetIncomeSplitEntity.setAllocationPercentage(accountSplitDTO.getAllocationPercentage());
                        });
                })
                .collect(Collectors.toSet());

            budgetIncomeSplitRepository.saveAll(updatedBudgetIncomeSplits);

        }

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
