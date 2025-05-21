package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
