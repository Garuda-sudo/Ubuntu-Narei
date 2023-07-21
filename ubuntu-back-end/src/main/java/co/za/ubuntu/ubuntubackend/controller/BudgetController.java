package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.ubuntubackend.domain.Budget;
import co.za.ubuntu.ubuntubackend.domain.BudgetRequest;
import co.za.ubuntu.ubuntubackend.services.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ubuntu/budget")
@RequiredArgsConstructor
public class BudgetController {

    BudgetService budgetService;

    @PostMapping("/create")
    public ResponseEntity<Budget> createBudget(
            @RequestBody BudgetRequest budgetRequest
    ) {

        var budget = budgetService.createBudget(budgetRequest);
        return ResponseEntity.ok(budget);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<Budget> retrieveBudget(
            @RequestBody UUID budgetId
    ) {

        var budget = budgetService.getBudget(budgetId);
        return ResponseEntity.ok(budget);
    }

    @PostMapping("/update")
    public ResponseEntity<Budget> updateBudget(
            @RequestBody BudgetRequest budgetRequest,
            @RequestParam("budgetId") UUID budgetId
    ) {

        var updatedBudget = budgetService.updateBudget(budgetRequest, budgetId);

        return ResponseEntity.ok(updatedBudget);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteBudget(
            @RequestParam("budgetId") UUID budgetId
    ) {

        budgetService.deleteBudget(budgetId);

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
