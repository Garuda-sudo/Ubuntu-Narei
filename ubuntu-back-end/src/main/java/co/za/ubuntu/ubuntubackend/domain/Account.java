package co.za.ubuntu.ubuntubackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private String accountHolder;
    private Double amount;
    private String bank;
    private Integer transactionId;

}
