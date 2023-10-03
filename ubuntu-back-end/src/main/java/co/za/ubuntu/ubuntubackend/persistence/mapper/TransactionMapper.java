package co.za.ubuntu.ubuntubackend.persistence.mapper;

import co.za.ubuntu.ubuntubackend.domain.dto.TransactionDto;
import co.za.ubuntu.ubuntubackend.persistence.entity.TransactionEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the entity {@link TransactionEntity} and its DTO called {@link TransactionDto}.
 * This mapper was generated automatically by MapStruct.
 */
@Mapper
public interface TransactionMapper {

    TransactionEntity map(TransactionDto transactionDto);

    TransactionDto map(TransactionEntity transactionEntity);

    List<TransactionDto> map(List<TransactionEntity> transactionEntityList);
}
