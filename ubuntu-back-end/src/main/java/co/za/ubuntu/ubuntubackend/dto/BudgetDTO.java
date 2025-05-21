package co.za.ubuntu.ubuntubackend.dto;

import co.za.ubuntu.model.Account;
import co.za.ubuntu.model.PeriodType;
import co.za.ubuntu.ubuntubackend.domain.enums.RolloverType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class BudgetDTO {

    private Long id;
    private String name;
    private Double amountLimit;
    private PeriodType periodType;

    private Integer userId;

    // Use LocalDateTime if you want to match the old model exactly
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDate;

    private List<Account> accounts;
    //maybe transaction need to check TODO

    // Custom fields below
    private BudgetIncomeSplitDTO budgetIncomeSplit;
    private List<CategoryDTO> categoryDTO;

    private List<BudgetIncomeSplitDTO> jointBudgetIncomeSplits;
    private List<Integer> groupUserIds;

    private Boolean autoRollover;
    private RolloverType rolloverType;

    private List<Integer> longTermGoalIds;
    private List<LongTermGoalDTO> longTermGoals;

}
