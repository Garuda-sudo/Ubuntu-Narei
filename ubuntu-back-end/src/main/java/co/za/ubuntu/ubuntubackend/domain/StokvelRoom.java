package co.za.ubuntu.ubuntubackend.domain;

import co.za.ubuntu.model.Account;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.User;
import co.za.ubuntu.ubuntubackend.domain.enums.RoomType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * The stokvel room extends a normal room as it will have additional logic specific to the
 * rotational policy and backing of peers to build a social financial network.
 */
@RequiredArgsConstructor
@Getter
@Setter
public class StokvelRoom extends Room {

    private String rotationalPolicy;

    private User roomLeader;

}
