package co.za.ubuntu.ubuntubackend.dto.InsightDTOs;

import co.za.ubuntu.ubuntubackend.dto.InsightDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class BudgetVersionSummaryDTO {

    private Integer versionId;
    private String versionName; // Optional: "Budget v1", "Budget v2", or "Jan 1–Jan 14"
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal totalPlanned;
    private BigDecimal totalActual;
    private List<CategorySpendTrendDTO> categorySpending;

}
