package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.BudgetApi;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.ubuntubackend.domain.BudgetIncomeSplit;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetIncomeSplitDTO;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
public class BudgetController implements BudgetApi {
    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    /**
     *
     * @param id id of budget to add transaction to (required)
     * @param transaction Transaction object that needs to be added (optional)
     * @return
     */
    @Override
    public ResponseEntity<Budget> addTransactionToBudget(Long id, Transaction transaction) {

        budgetService.addTransactionToBudget(id, transaction);

        return null;
    }

    /**
     * @param budget Budget object that needs to be added (optional)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> createBudget(Budget budget) {
        BudgetDTO budgetDTO = new BudgetDTO();
        return ResponseEntity.ok().body(budgetService.createBudget(budgetDTO));
    }

    /**
     * @param id id of budget to delete (required)
     * @return
     */
    @Override
    public ResponseEntity<Void> deleteBudget(Long id) {

        Logger.getLogger("Budget Logger").log(new LogRecord(Level.ALL, "Deleting Budget %s" + id));

        budgetService.deleteBudget(Math.toIntExact(id));

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<TransactionResponse>> getAllBudgetTransactions(Long budgetId) {

        budgetService.getBudgetTransactions(budgetId);

        return null;
    }

    /**
     * @param userId id of user to return budgets for (required)
     * @return
     */
    @Override
    public ResponseEntity<List<BudgetResponse>> getAllBudgets(Long userId) {
        return ResponseEntity.ok().body(
                budgetService.getUserBudgets(Math.toIntExact(userId))
        );
    }

    /**
     * @param id id of budget to return (required)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> getBudgetById(Long id) {
        return ResponseEntity.ok().body(
                budgetService.getBudget(Math.toIntExact(id))
        );
    }

    /**
     * @param id     id of budget to update (required)
     * @param budget Budget object that needs to be updated (optional)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> updateBudget(Long id, Budget budget) {
        budgetService.updateBudget(budget);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/update-budget-income-split")
    public ResponseEntity<BudgetResponse> updateBudgetIncomeSplit(@RequestBody BudgetIncomeSplitDTO budgetIncomeSplitDTO) {

        //Method that updates a budget's income split. A budget is linked to potentially multiple
        //accounts. I want an account to represent any split of income, be it a cheque account, savings
        //or a side income.
        budgetService.updateBudgetIncomeSplit(budgetIncomeSplitDTO);

        return null;
    }

    @GetMapping
    public ResponseEntity<BudgetResponse> getBudgetReport() {
        return null;
    }

    //TODO: Need to add endpoint that adds a budget to an account. The respective accounts *(value) must
    // then reflect the change based on the transactions. Not quite the value but it must show how many budgets
    // are linked.

}
