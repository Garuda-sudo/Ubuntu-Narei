package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;

public interface RoomStrategy {

    Room createRoomStrategy(BudgetDTO roomRequest);

    Room editRoomStrategy(RoomRequest roomRequest);

    RoomType getRoomTypeName();
}
