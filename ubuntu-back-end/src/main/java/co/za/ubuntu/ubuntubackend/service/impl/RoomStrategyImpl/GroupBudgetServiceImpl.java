package co.za.ubuntu.ubuntubackend.service.impl.RoomStrategyImpl;

import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.RoomEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.BudgetRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.RoomRepository;
import co.za.ubuntu.ubuntubackend.service.RoomStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service("GroupBudgetService")
@RequiredArgsConstructor
public class GroupBudgetServiceImpl implements RoomStrategy {

    BudgetRepository budgetRepository;

    RoomRepository roomRepository;

    /**
     * This implementation is for when users share a common goal and want to compare how they
     * are doing in their budget goals. The users either use the budgets they have already created
     * or a new budget linked to this specific Room will be created.
     * @param roomRequest
     * @return
     */
    @Override
    public Room createRoomStrategy(BudgetDTO roomRequest) {

        //Should there be any logic done before creating a Group Budget Room?
        roomRepository.save(dtoToDomain(roomRequest));

        // In this case there are no individual income/expense that a user may have on top of
        // their budgets. This is strictly to compare budgets against each other and how much you
        // have cumulatively saved so far

        //What is the best way to keep track of how far each User is in savings respective to the goal?
        //Maybe take what each consolidated saving is captured from each budget and add it to a savings field

        return null;
    }

    @Override
    public Room editRoomStrategy(RoomRequest roomRequest) {
        return null;
    }

    @Override
    public RoomType getRoomTypeName() {
        return RoomType.GOAL_BUDGET;
    }

    private RoomEntity dtoToDomain(BudgetDTO roomRequest) {

        // Fetch each users budget that they want to compare and link them to the room
        //List<BudgetEntity> userBudgets = budgetRepository.findAllById(roomRequest.getBudgetIds());

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setStartDate(Date.from(Instant.now())); //LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())
        //roomEntity.setGroupGoal(BigDecimal.valueOf(roomRequest.getGroupGoal()));
        //roomEntity.setRoomName(roomRequest.getRoomName());

        //The Join table on users and rooms will have a field on the cumulative savings
        //roomEntity.setUsers(new HashSet<>()); //TODO: Implement adding users

        //The big mapping will be that of the budgets linked to this Room
//        if (!userBudgets.isEmpty()) {
//            roomEntity.setBudgets(new HashSet<>(userBudgets));
//        }

        return roomEntity;
    }
}
