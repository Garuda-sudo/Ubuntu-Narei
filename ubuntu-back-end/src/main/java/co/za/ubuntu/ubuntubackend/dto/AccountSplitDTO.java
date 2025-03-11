package co.za.ubuntu.ubuntubackend.dto;

import co.za.ubuntu.model.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class AccountSplitDTO extends Account {

    Integer accountId;
    String splitType;
    Double incomeAmount;
    BigDecimal allocationPercentage;

}
