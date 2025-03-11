package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.User;
import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;

import java.util.List;

public interface RoomService {

    Room getRoom(Integer id);

    Room createRoom(BudgetDTO roomRequest, RoomType roomType);

    Room editRoom(RoomRequest roomRequest, RoomType roomType);

    /**
     * This is the feature that lets users add incremental amounts to the room to save away. The entire saved
     * amount is then paid out after the designated time.
     * @param amount
     * @return
     */
    String addFundsToRoom(Double amount);

    void validateSpecificUser(Integer roomId, Integer validatorUserId, Integer validatedUserId);

}
