package co.za.ubuntu.ubuntubackend.services.impl;

import co.za.ubuntu.ubuntubackend.domain.Budget;
import co.za.ubuntu.ubuntubackend.domain.BudgetRequest;
import co.za.ubuntu.ubuntubackend.domain.User;
import co.za.ubuntu.ubuntubackend.domain.mapper.BudgetMapper;
import co.za.ubuntu.ubuntubackend.persistence.BudgetRepository;
import co.za.ubuntu.ubuntubackend.persistence.UserRepository;
import co.za.ubuntu.ubuntubackend.services.BudgetService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BudgetServiceImpl implements BudgetService {

    BudgetRepository budgetRepository;
    BudgetMapper budgetMapper;

    @Override
    public Budget createBudget(BudgetRequest budgetRequest) {

        var budget = Budget.builder()
                .name(budgetRequest.getName())
                .goals(budgetRequest.getGoals())
                .dateCreated(budgetRequest.getDateCreated())
                .build();

        //convert budget request into budget entity
        var budgetEntity = budgetMapper.map(budget);
        var createdBudgetEntity = budgetRepository.save(budgetEntity);

        //convert budget entity to budget
        var createdBudget = budgetMapper.map(createdBudgetEntity);

        return createdBudget;
    }

    @Override
    public Budget getBudget(UUID budgetId) {

        budgetRepository.findById(budgetId);
        return null;
    }

    @Override
    public Budget updateBudget(BudgetRequest budgetRequest, UUID budgetId) {

        budgetRepository.findById(budgetId);

        return null;
    }

    @Override
    public void deleteBudget(UUID budgetId) {

        budgetRepository.deleteById(budgetId);
    }
}
