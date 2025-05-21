package co.za.ubuntu.ubuntubackend.service.impl.RoomStrategyImpl;

import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.BudgetStatus;
import co.za.ubuntu.ubuntubackend.domain.enums.GoalType;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.dto.AccountSplitDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.CategoryDTO;
import co.za.ubuntu.ubuntubackend.persistence.entity.*;
import co.za.ubuntu.ubuntubackend.persistence.repository.*;
import co.za.ubuntu.ubuntubackend.service.RoomStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service("JointBudgetService")
@RequiredArgsConstructor
public class JointBudgetServiceImpl implements RoomStrategy {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    GoalRepository goalRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BudgetRepository jointBudgetRepository;

    @Override
    public Room createRoomStrategy(BudgetDTO roomRequest) {

        //Implementation of when a group of people want to combine their income and spending's
        //to get a holistic view of their cumulative budgets

        //------------------------------ Create the Budget ----------------------------------//
        /**
         * A joint budget is used by a group of users to joint budget for their purposes and track
         * to make sure that everyone is keeping track of their amounts. It should reflect how much
         * the total value per category is, how much each person is to contribute and how much they
         * have contributed so far
         */

        JointBudgetEntity jointBudgetEntity = new JointBudgetEntity();

        jointBudgetEntity.setBudgetName(roomRequest.getName());
        jointBudgetEntity.setAmountLimit(BigDecimal.valueOf(roomRequest.getAmountLimit()));
        jointBudgetEntity.setDateCreated(Date.from(Instant.now()));
        jointBudgetEntity.setStartDate(roomRequest.getStartDate());
        jointBudgetEntity.setEndDate(roomRequest.getEndDate());
        jointBudgetEntity.setStatus(BudgetStatus.ACTIVE);

        //========================== Set the Budget Income Split =============================================//

        /**
         * The Joint Budget Income Split will consist of the incomes of each member and how much
         * each member will use from their monthly salary to contribute to this joint group
         */
        List<BudgetIncomeSplitEntity> budgetIncomeSplitEntities = new ArrayList<>();


        // Step 1: Collect all unique account IDs from all DTOs
        Set<Integer> allAccountIds = roomRequest.getJointBudgetIncomeSplits().stream()
            .flatMap(dto -> dto.getAccounts().stream().map(AccountSplitDTO::getAccountId))
            .collect(Collectors.toSet());

        // Step 2: Fetch all accounts in a single query
        Map<Integer, AccountEntity> accountMap = accountRepository.findAllById(allAccountIds).stream()
            .collect(Collectors.toMap(AccountEntity::getId, account -> account));

        // Step 3: Process each joint budget split
        roomRequest.getJointBudgetIncomeSplits().forEach(budgetIncomeSplitDTO ->
            budgetIncomeSplitDTO.getAccounts().forEach(accountSplitDTO -> {
                BudgetIncomeSplitEntity budgetIncomeSplit = new BudgetIncomeSplitEntity();

                budgetIncomeSplit.setAccount(accountMap.get(accountSplitDTO.getAccountId()));
                //budgetIncomeSplit.setSplitType();
                //budgetIncomeSplit.setIncomeAmount();

                budgetIncomeSplitEntities.add(budgetIncomeSplit);
            })
        );

        jointBudgetEntity.setBudgetIncomeSplitEntity(budgetIncomeSplitEntities);

        //========================== Set the Long Term Goal =============================================//

        /**
         * Each Group will now have a goal that they are jointly saving towards
         */
        List<GoalEntity> longTermGoals =
            new ArrayList<>(goalRepository.findAllById(roomRequest.getLongTermGoalIds().stream().filter(Objects::nonNull).collect(Collectors.toList())));

        List<UserEntity> users = userRepository.findAllById(roomRequest.getGroupUserIds());
        Map<Integer,UserEntity> userEntityMap = new HashMap<>();
        users.forEach(
            userEntity -> {
                userEntityMap.put(userEntity.getId(), userEntity);
            }
        );

        roomRequest.getLongTermGoals().forEach(
            longTermGoalDTO -> {

                if (longTermGoals.stream().noneMatch(goal -> goal.getName().equals(longTermGoalDTO.getGoalName()))) {
                    GoalEntity goalEntity =  new GoalEntity();
                    goalEntity.setGoalType(GoalType.LONG_TERM);
                    goalEntity.setName(longTermGoalDTO.getGoalName());
                    goalEntity.setTargetAmount(longTermGoalDTO.getTargetAmount());
                    goalEntity.setTargetDate(longTermGoalDTO.getTargetDate());
                    goalEntity.setDescription(longTermGoalDTO.getDescription());

                    if (!users.isEmpty()) {
                        goalEntity.setUsers(users);
                    } else {
                        throw new RuntimeException("There must at least be 1 user linked to a Goal");
                    }


                    longTermGoals.add(goalEntity);
                } else {
                    throw new RuntimeException("Cant have more than one Goal of the same name");
                }

            }
        );

        //====================== Set the Category Line Expense & Short Term Goals =================//

        /**
         * Every joint budget member will have agreed to how much they will contribute to each line item
         * in the budget. The Joint Budget Category DTO will have a category DTO that has the breakdown
         * from each user in a map. Each entry in the map contains the User ID and the respective amount
         * that they will each contribute to the respective category
         */
        Set<JointBudgetCategoryEntity> jointBudgetCategoryMap = new HashSet<>();

        List<CategoryEntity> categoryEntityList =
            categoryRepository.findAllById(roomRequest.getCategoryDTO().stream().map(CategoryDTO::getCategoryId).collect(Collectors.toList()));

        Map<Integer,CategoryEntity> categoryEntityMap = new HashMap<>();
        categoryEntityList.forEach(
            categoryEntity -> {
                categoryEntityMap.put(categoryEntity.getId(), categoryEntity);
            }
        );

        roomRequest.getCategoryDTO().forEach(
            categoryDTO -> {
                JointBudgetCategoryEntity jointBudgetCategoryEntity = new JointBudgetCategoryEntity();

                jointBudgetCategoryEntity.setCategory(categoryEntityMap.get(categoryDTO.getCategoryId()));
                jointBudgetCategoryEntity.setTotalAllocation(
                    getTotalAmountForCategory(categoryDTO.getUserAmountSplits().values())
                ); //This is the amount for all the selected users for
                // this specific category

                Set<JointBudgetCategoryUserEntity> memberEntitySet = new HashSet<>();

                categoryDTO.getUserAmountSplits().forEach(
                    (userId, categoryAmount) -> {

                        /**
                         * The JointBudgetCategoryUserEntity is th bridging table that holds the
                         * actual information of how much each user has allocated and how much
                         * they have spent so far towards that specific category in that joint budget
                         */

                        UserEntity userEntity = userEntityMap.get(userId);
                        JointBudgetCategoryUserEntity jointBudgetCategoryUserEntity = new JointBudgetCategoryUserEntity();

                        jointBudgetCategoryUserEntity.setAllocatedAmount(categoryAmount);
                        jointBudgetCategoryUserEntity.setAmountSpent(new BigDecimal("0.0"));
                        jointBudgetCategoryUserEntity.setUser(userEntity); //Each user for that category linked to
                        // the joint budget

                        memberEntitySet.add(jointBudgetCategoryUserEntity);
                    }
                );

                jointBudgetCategoryEntity.setMembers(memberEntitySet);
                jointBudgetCategoryMap.add(jointBudgetCategoryEntity);
            }
        );

        jointBudgetEntity.setJointBudgetCategories(jointBudgetCategoryMap);

        return new Room(jointBudgetRepository.save(jointBudgetEntity));
    }

    @Override
    public Room editRoomStrategy(RoomRequest roomRequest) {
        return null;
    }

    @Override
    public RoomType getRoomTypeName() {
        return RoomType.JOINT_BUDGET;
    }

    private BigDecimal getTotalAmountForCategory(Collection<BigDecimal> userAmounts) {
        return userAmounts.stream()
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
