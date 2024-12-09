package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;

public interface RoomStrategy {

    Room createRoomStrategy(RoomRequest roomRequest);

    Room editRoomStrategy(RoomRequest roomRequest);

    RoomType getRoomTypeName();
}
