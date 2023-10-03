package co.za.ubuntu.ubuntubackend.persistence.mapper;

import co.za.ubuntu.ubuntubackend.domain.dto.TransactionDto;
import co.za.ubuntu.ubuntubackend.domain.dto.TransactionbudgetDto;
import co.za.ubuntu.ubuntubackend.persistence.entity.Transactionbudget;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the entity {@link Transactionbudget} and its DTO called {@link TransactionbudgetDto}.
 * This mapper was generated automatically by MapStruct.
 */
@Mapper
public interface TransactionBudgetMapper {

    Transactionbudget map(TransactionbudgetDto transactionbudgetDto);

    TransactionbudgetDto map(Transactionbudget transactionbudget);

    List<TransactionbudgetDto> map(List<Transactionbudget> transactionbudgetList);
}
