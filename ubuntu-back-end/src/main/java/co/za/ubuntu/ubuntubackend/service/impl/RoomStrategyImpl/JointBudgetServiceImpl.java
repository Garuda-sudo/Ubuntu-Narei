package co.za.ubuntu.ubuntubackend.service.impl.RoomStrategyImpl;

import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.service.RoomStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("JointBudgetService")
@RequiredArgsConstructor
public class JointBudgetServiceImpl implements RoomStrategy {
    @Override
    public Room createRoomStrategy(RoomRequest roomRequest) {

        //Implementation of when a group of people want to combine their income and spending's
        //to get a holistic view of their cumulative budgets

        //

        return null;
    }

    @Override
    public Room editRoomStrategy(RoomRequest roomRequest) {
        return null;
    }

    @Override
    public RoomType getRoomTypeName() {
        return RoomType.JOINT_BUDGET;
    }
}
