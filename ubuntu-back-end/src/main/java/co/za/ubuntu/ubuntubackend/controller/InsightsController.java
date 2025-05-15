package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.ubuntubackend.dto.DiscountDTO;
import co.za.ubuntu.ubuntubackend.dto.InsightDTO;
import co.za.ubuntu.ubuntubackend.service.DiscountService;
import co.za.ubuntu.ubuntubackend.service.InsightService;
import co.za.ubuntu.ubuntubackend.service.impl.RoomStrategyImpl.JointBudgetServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insights")
public class InsightsController {
    private final InsightService insightService;

    public InsightsController(InsightService insightService) {
        this.insightService = insightService;
    }

    @GetMapping("/short-term/{budgetId}")
    public ResponseEntity<InsightDTO> getTotalVsSpent(@PathVariable Integer budgetId) {
        InsightDTO insight = insightService.getBudgetVsActualSpending(budgetId);
        return ResponseEntity.ok(insight);
    }


}
