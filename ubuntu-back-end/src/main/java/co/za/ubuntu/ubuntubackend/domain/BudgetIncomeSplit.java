package co.za.ubuntu.ubuntubackend.domain;

import co.za.ubuntu.model.Budget;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * A budget income split is responsible for representing which accounts are responsible
 * in funding different budgets as specified by the user
 */
@RequiredArgsConstructor
@Getter
@Setter
public class BudgetIncomeSplit {

    private Long budgetId;
    private List<Long> accountIds;
}
