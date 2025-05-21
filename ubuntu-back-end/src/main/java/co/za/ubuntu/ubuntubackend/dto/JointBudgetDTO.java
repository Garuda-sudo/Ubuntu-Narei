package co.za.ubuntu.ubuntubackend.dto;

import co.za.ubuntu.model.Account;
import co.za.ubuntu.model.Budget;
import co.za.ubuntu.model.PeriodType;
import co.za.ubuntu.ubuntubackend.domain.enums.RolloverType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class JointBudgetDTO {

    private Long id;
    private String name;
    private Double amountLimit;
    private PeriodType periodType;
    private Integer userId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<Account> accounts;
    //private List<Transaction> transactions;

    // Custom fields specific to JointBudgetDTO
    private BudgetIncomeSplitDTO budgetIncomeSplit;
    private List<CategoryDTO> categoryDTO;

    private Boolean autoRollover;
    private RolloverType rolloverType;

    private List<Integer> userIds;
    private List<Integer> longTermGoalIds;
    private List<LongTermGoalDTO> longTermGoals;

}
