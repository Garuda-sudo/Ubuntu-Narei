package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.BudgetApi;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BudgetController implements BudgetApi {
    /**
     * @param budget Budget object that needs to be added (optional)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> _createBudget(Budget budget) {
        return null;
    }

    /**
     * @param id id of budget to delete (required)
     * @return
     */
    @Override
    public ResponseEntity<Void> _deleteBudget(Long id) {
        return null;
    }

    /**
     * @param userId id of user to return budgets for (required)
     * @return
     */
    @Override
    public ResponseEntity<List<BudgetResponse>> _getAllBudgets(Long userId) {
        return null;
    }

    /**
     * @param id id of budget to return (required)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> _getBudgetById(Long id) {
        return null;
    }

    /**
     * @param id     id of budget to update (required)
     * @param budget Budget object that needs to be updated (optional)
     * @return
     */
    @Override
    public ResponseEntity<BudgetResponse> _updateBudget(Long id, Budget budget) {
        return null;
    }
}
