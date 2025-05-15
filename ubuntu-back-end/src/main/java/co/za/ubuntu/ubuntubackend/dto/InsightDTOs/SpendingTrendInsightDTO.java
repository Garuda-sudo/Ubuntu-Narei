package co.za.ubuntu.ubuntubackend.dto.InsightDTOs;

import co.za.ubuntu.ubuntubackend.dto.InsightDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class SpendingTrendInsightDTO extends InsightDTO {

    private String baseBudgetName;
    private List<BudgetVersionSummaryDTO> budgetVersions;
}
