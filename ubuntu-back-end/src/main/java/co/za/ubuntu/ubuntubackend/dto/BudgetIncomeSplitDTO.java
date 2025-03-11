package co.za.ubuntu.ubuntubackend.dto;

import co.za.ubuntu.model.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class BudgetIncomeSplitDTO {

    List<AccountSplitDTO> accounts;
    Integer budgetId;

}
