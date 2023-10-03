package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.ubuntubackend.domain.dto.BudgetDto;
import co.za.ubuntu.ubuntubackend.domain.dto.UserDto;
import co.za.ubuntu.ubuntubackend.domain.exception.NotFoundException;
import co.za.ubuntu.ubuntubackend.domain.mapper.BudgetDomainMapper;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import co.za.ubuntu.ubuntubackend.persistence.mapper.BudgetMapper;
import co.za.ubuntu.ubuntubackend.persistence.mapper.UserMapper;
import co.za.ubuntu.ubuntubackend.persistence.repository.BudgetRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.UserRepository;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    BudgetRepository budgetRepository;
    UserRepository userRepository;
    BudgetMapper budgetMapper;
    UserMapper userMapper;
    BudgetDomainMapper budgetDomainMapper;

    /**
     * @param userId The unique identifier of the user.
     * @return List<Budget>
     */
    @Override
    public List<Budget> getUserBudgets(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("No user found with ID: " + userId)
        );
        List<BudgetEntity> budgetEntities = budgetRepository.findBudgetEntitiesByUserEntity(userEntity).orElseThrow(
                () -> new NotFoundException("No budgets found for user with ID: " + userId)
        );

        List<BudgetDto> userBudgets = budgetMapper.map(budgetEntities);

        return budgetDomainMapper.map(userBudgets);
    }

    /**
     * @param budgetId The unique identifier of the budget to retrieve.
     * @return Budget
     */
    @Override
    public Budget getBudget(Integer budgetId) {
        BudgetEntity budgetEntity = budgetRepository.findById(budgetId).orElseThrow(
                () -> new NotFoundException("No budget found with ID: " + budgetId)
        );

        return budgetDomainMapper.map(budgetMapper.map(budgetEntity));
    }

    /**
     * @param budget The budget object to create.
     */
    @Override
    public void createBudget(Budget budget) {
        UserDto userDto = userMapper.map(userRepository.findById(budget.getUserId()).orElseThrow(
                () -> new NotFoundException("No user found with ID: " + budget.getUserId())
        ));
        //BudgetDto budgetDto = budgetDomainMapper.map(budget);

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
