package co.za.ubuntu.ubuntubackend.dto;

import co.za.ubuntu.model.Account;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.ubuntubackend.domain.enums.RolloverType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class BudgetDTO extends Budget {

    private LocalDate startDate;
    private LocalDate endDate;

    private BudgetIncomeSplitDTO budgetIncomeSplit;
    private List<CategoryDTO> categoryDTO;

    private List<BudgetIncomeSplitDTO> jointBudgetIncomeSplits;
    private List<Integer> groupUserIds;

    private Boolean autoRollover;
    private RolloverType rolloverType;

    private Integer userId;
    private List<Integer> longTermGoalIds;
    private List<LongTermGoalDTO> longTermGoals;

}
