package co.za.ubuntu.ubuntubackend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class InsightDTO {

    private String type; // e.g., "TOTAL_VS_SPENT", "CATEGORY_OVERSPEND"
    private String title; // "You're over budget!"
    private String message; // "You spent $200 more than you planned"
}
