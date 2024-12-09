package co.za.ubuntu.ubuntubackend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class RoomRequest {

    private String roomName;
    private List<Integer> budgetIds;
    private String roomGoal;
    private LocalDate targetDate;

    //Need an object per user that says how much each
    //user will start saving towards their goal, how
    //much from each budget they want to contribute,
    //weather it will be a manual process or if they
    //want to automate it.
    private Double budgetAmount;
    private Integer chatId;
    private Double groupGoal;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Integer> getBudgetIds() {
        return budgetIds;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setBudgetIds(List<Integer> budgetIds) {
        this.budgetIds = budgetIds;
    }

    public String getRoomGoal() {
        return roomGoal;
    }

    public void setRoomGoal(String roomGoal) {
        this.roomGoal = roomGoal;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Double getGroupGoal() {
        return groupGoal;
    }

    public void setGroupGoal(Double groupGoal) {
        this.groupGoal = groupGoal;
    }
}
