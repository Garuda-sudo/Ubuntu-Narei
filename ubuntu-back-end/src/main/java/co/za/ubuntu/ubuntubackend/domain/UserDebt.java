package co.za.ubuntu.ubuntubackend.domain;

import co.za.ubuntu.model.Budget;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class UserDebt {

    private String name;
    private List<Budget> budgets;
}
