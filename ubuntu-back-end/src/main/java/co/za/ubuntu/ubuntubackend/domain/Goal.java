package co.za.ubuntu.ubuntubackend.domain;

import co.za.ubuntu.model.Budget;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * A goal is linked to a/many budgets and lets a user either put their extra savings
 * after the budget for the given time period is done or create an expense/saving item
 * in the respective budget/s. The idea is to partner with partners that can advertise their
 * products that a user/groups can save towards at a cheaper price than normal.
 */
@RequiredArgsConstructor
@Getter
@Setter
public class Goal {

    private String name;
    private List<Budget> budgets;
}
