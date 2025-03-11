package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.BudgetApi;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetIncomeSplitDTO;
import co.za.ubuntu.ubuntubackend.service.BudgetService;
import co.za.ubuntu.ubuntubackend.service.RoomService;
import co.za.ubuntu.ubuntubackend.service.RoomStrategy;
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
public class JointBudgetController{
    private final RoomService roomService;

    @Autowired
    public JointBudgetController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     *
     * @param id id of budget to add transaction to (required)
     * @param transaction Transaction object that needs to be added (optional)
     * @return
     */
    public ResponseEntity<Budget> createJointBudget(Long id, Transaction transaction) {

        roomService.createRoom(new BudgetDTO(), RoomType.JOINT_BUDGET);

        return null;
    }
}
