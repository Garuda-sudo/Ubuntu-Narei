package co.za.ubuntu.ubuntubackend.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Budget {

    private Integer budgetId;
    private String name;
    private LocalDate dateCreated;
    private String goals;
    private List<Account> accounts;

}
