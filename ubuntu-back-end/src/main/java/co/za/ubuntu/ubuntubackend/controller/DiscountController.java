package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.BudgetApi;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetIncomeSplitDTO;
import co.za.ubuntu.ubuntubackend.dto.DiscountDTO;
import co.za.ubuntu.ubuntubackend.dto.GoalProgressDTO;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import co.za.ubuntu.ubuntubackend.service.DiscountService;
import co.za.ubuntu.ubuntubackend.service.impl.RoomStrategyImpl.JointBudgetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
public class DiscountController {
    private final DiscountService discountService;
    private final JointBudgetServiceImpl jointBudgetService;


    public DiscountController(DiscountService discountService, JointBudgetServiceImpl jointBudgetService) {
        this.discountService = discountService;
        this.jointBudgetService = jointBudgetService;
    }

    @GetMapping("/short-term/{userId}")
    public ResponseEntity<List<DiscountDTO>> getShortTermGoalDiscounts(@PathVariable Integer userId) {
        List<DiscountDTO> discounts = discountService.getShortTermGoalDiscounts(new DiscountDTO());
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/long-term/{userId}")
    public ResponseEntity<List<DiscountDTO>> getLongTermGoalDiscounts(@PathVariable Integer userId) {
        List<DiscountDTO> discounts = discountService.getLongTermGoalDiscounts(new DiscountDTO());
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/progress/{goalId}")
    public ResponseEntity<GoalProgressDTO> getGoalProgress(@PathVariable Integer goalId) {
        GoalProgressDTO progress = discountService.getGoalProgress(goalId);
        return ResponseEntity.ok(progress);
    }

    @PostMapping("/redeem/{discountId}")
    public ResponseEntity<Void> redeemDiscount(@PathVariable Long discountId) {
        //discountService.redeemDiscount(discountId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/qrcode/{discountId}")
    public ResponseEntity<byte[]> generateDiscountQRCode(@PathVariable Long discountId) {
//        byte[] qrCodeImage = discountService.generateDiscountQRCode(discountId);
//        return ResponseEntity.ok()
//            .contentType(MediaType.IMAGE_PNG)
//            .body(qrCodeImage);
        return null;
    }


}
