package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.BudgetApi;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetIncomeSplitDTO;
import co.za.ubuntu.ubuntubackend.dto.DiscountDTO;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import co.za.ubuntu.ubuntubackend.service.impl.RoomStrategyImpl.JointBudgetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
public class DiscountController {
    private final BudgetService budgetService;

    private final JointBudgetServiceImpl jointBudgetService;


    public DiscountController(BudgetService budgetService, JointBudgetServiceImpl jointBudgetService) {
        this.budgetService = budgetService;
        this.jointBudgetService = jointBudgetService;
    }

    @GetMapping
    public ResponseEntity<DiscountDTO> checkDiscount(
        @RequestParam(required = false) List<Integer> userIds
    ) {
        DiscountDTO discountDTO = new DiscountDTO();

        return ResponseEntity.ok().body();
    }


}
