package co.za.ubuntu.ubuntubackend.dto.InsightDTOs;

import co.za.ubuntu.ubuntubackend.dto.InsightDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class BudgetVersionSummaryDTO extends InsightDTO {

    private Integer versionId;
    private String versionName; // Optional: "Budget v1", "Budget v2", or "Jan 1–Jan 14"
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalPlanned;
    private BigDecimal totalActual;
    private List<CategorySpendTrendDTO> categorySpending;

}
