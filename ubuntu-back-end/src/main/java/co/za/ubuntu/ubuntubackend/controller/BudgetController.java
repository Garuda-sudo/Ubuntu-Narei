package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.BudgetApi;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetController implements BudgetApi {
    private final BudgetService budgetService;
    /**
     * @param budget Budget object that needs to be added (optional)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> _createBudget(Budget budget) {
        return ResponseEntity.ok().body(budgetService.createBudget(budget));
    }

    /**
     * @param id id of budget to delete (required)
     * @return
     */
    @Override
    public ResponseEntity<Void> _deleteBudget(Long id) {
        budgetService.deleteBudget(Math.toIntExact(id));
        return ResponseEntity.ok().build();
    }

    /**
     * @param userId id of user to return budgets for (required)
     * @return
     */
    @Override
    public ResponseEntity<List<BudgetResponse>> _getAllBudgets(Long userId) {
        return ResponseEntity.ok().body(
                budgetService.getUserBudgets(Math.toIntExact(userId))
        );
    }

    /**
     * @param id id of budget to return (required)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> _getBudgetById(Long id) {
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
    public ResponseEntity<BudgetResponse> _updateBudget(Long id, Budget budget) {
        budgetService.updateBudget(budget);
        return ResponseEntity.ok().build();
    }
}
