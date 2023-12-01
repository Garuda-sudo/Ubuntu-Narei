package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.ubuntubackend.domain.exception.NotFoundException;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import co.za.ubuntu.ubuntubackend.persistence.mapper.BudgetEntityMapper;
import co.za.ubuntu.ubuntubackend.persistence.repository.BudgetRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.UserRepository;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    BudgetRepository budgetRepository;
    UserRepository userRepository;
    BudgetEntityMapper budgetMapper;

    /**
     * @param userId The unique identifier of the user.
     * @return List<Budget>
     */
    @Override
    public List<BudgetResponse> getUserBudgets(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("No user found with ID: " + userId)
        );
        List<BudgetEntity> budgetEntities = budgetRepository.findBudgetEntitiesByUserEntity(userEntity).orElseThrow(
                () -> new NotFoundException("No budgets found for user with ID: " + userId)
        );

//        List<BudgetDto> userBudgets = budgetMapper.map(budgetEntities);
//
//        return budgetDomainMapper.map(userBudgets);
        return List.of(BudgetResponse.builder().build());
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
        return null;
    }

    /**
     * @param budget The budget object to create.
     */
    @Override
    public BudgetResponse createBudget(Budget budget) {
        budgetRepository.save(budgetEntity)
    }

    /**
     * @param budget The updated budget object to save.
     */
    @Override
    public void updateBudget(Budget budget) {

    }

    /**
     * @param budgetId The unique identifier of the budget to delete.
     */
    @Override
    public void deleteBudget(Integer budgetId) {

    }
}
