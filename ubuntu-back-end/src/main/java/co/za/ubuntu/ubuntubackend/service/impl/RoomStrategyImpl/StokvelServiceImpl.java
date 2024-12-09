package co.za.ubuntu.ubuntubackend.service.impl.RoomStrategyImpl;

import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.StokvelRoom;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.service.RoomStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("StokvelService")
@RequiredArgsConstructor
public class StokvelServiceImpl implements RoomStrategy {

    //TODO: There may be a very unique way to rotaionally pay out group users ina safe way.
    // When its a users 1st turn to get their payout, only 5% of the total payments are given out
    // and the rest kept in the group fund. When it's the users 2nd turn to payout, this improves
    // to 10% for eg.
    @Override
    public StokvelRoom createRoomStrategy(RoomRequest roomRequest) {
        return null;
    }

    @Override
    public Room editRoomStrategy(RoomRequest roomRequest) {
        return null;
    }

    @Override
    public RoomType getRoomTypeName() {
        return RoomType.STOKVEL;
    }
}
