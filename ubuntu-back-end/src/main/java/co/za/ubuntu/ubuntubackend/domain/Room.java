package co.za.ubuntu.ubuntubackend.domain;

import co.za.ubuntu.model.Account;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
@Setter
public class Room {

    private Long id;

    private String roomName;

    private String goal;

    private List<Budget> budgets;

    private List<Account> accounts;

    private String roomGoal;

    private Integer chatId;

    private RoomType roomType;

    private Map<Integer, Double> totalUserSavingsMap;

    private List<Integer> roomTransactions;



}
