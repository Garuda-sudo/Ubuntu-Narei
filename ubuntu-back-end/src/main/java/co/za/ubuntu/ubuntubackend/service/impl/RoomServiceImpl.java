package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.ubuntubackend.domain.Room;
import co.za.ubuntu.ubuntubackend.domain.RoomRequest;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.service.RoomService;
import co.za.ubuntu.ubuntubackend.service.RoomStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final Map<RoomType, RoomStrategy> roomStrategies;

    @Autowired
    public RoomServiceImpl(List<RoomStrategy> roomStrategies) {
        this.roomStrategies = roomStrategies.stream()
            .collect(Collectors.toMap(RoomStrategy::getRoomTypeName, Function.identity()));
    }

    @Override
    public Room getRoom(Integer id) {
        return null;
    }

    @Override
    public Room createRoom(BudgetDTO roomRequest, RoomType roomType) {

        // TODO: A room is a special entity that is for the use of joint budgeting. It is to enable
        // multiple users to create a shared goal that facilitates their savings goal by seeing each
        // others relative progress, chats, and future projections based on changes. It also lets
        // users put away incremantal amounts (almost like a savings) towards their goal that they
        // can only get back with a *penalty* that they decide on. A room can also be converted to
        // a rotational stokvel where people can manage giving funds to each other and manage it on
        // the app. People that partake in giving and receiving funds will benefit on better interest
        // rates when the p2p lending becomes available and small loans are introduced. The SOLE
        // purpose of a room is to enable/foster people to help each other reach their financial goals
        // and EACH OTHER!

        // First check what type of room is being created. Are they joint budgeting, goal budgeting
        // or a stokvel. Based on the room type the respective implementation is done.
        RoomStrategy roomStrategy = roomStrategies.get(roomType);

        if (roomStrategy == null) {
            throw new UnsupportedOperationException();
        }

        roomStrategy.createRoomStrategy(roomRequest);

        return null;
    }

    @Override
    public Room editRoom(RoomRequest roomRequest, RoomType roomType) {

        RoomStrategy roomStrategy = roomStrategies.get(roomType);

        if (roomStrategy == null) {
            throw new UnsupportedOperationException();
        }

        roomStrategy.editRoomStrategy(roomRequest);

        return null;
    }

    @Override
    public String addFundsToRoom(Double amount) {
        return null;
    }

    @Override
    public void validateSpecificUser(Integer roomId, Integer validatorUserId, Integer validatedUserId) {

        //This allows a user in the group to validate another user on the group so that
        //they are eligible for rotational savings payouts into their linked account.

        //The Room_User bridging table will have a column that says validated_by that
        //shows that in that specific room this user was validated by this specific user
        //

    }
}
