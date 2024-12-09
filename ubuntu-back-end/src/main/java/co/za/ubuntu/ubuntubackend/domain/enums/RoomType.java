package co.za.ubuntu.ubuntubackend.domain.enums;

import lombok.Getter;

@Getter
public enum RoomType {

    JOINT_BUDGET("Joint Budget"),
    GOAL_BUDGET("Goal Budget"),
    STOKVEL("Stokvel");

    private final String value;

    RoomType(String value) {
        this.value = value;
    }

}
