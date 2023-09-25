package co.za.ubuntu.ubuntubackend.persistence.mapper;

import co.za.ubuntu.ubuntubackend.domain.dto.AccountDto;
import co.za.ubuntu.ubuntubackend.persistence.entity.AccountEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the entity {@link AccountEntity} and its DTO called {@link AccountDto}.
 * This mapper was generated automatically by MapStruct.
 */
@Mapper
public interface AccountMapper {

    AccountEntity map(AccountDto accountDto);

    AccountDto map(AccountEntity accountEntity);

    List<AccountDto> map(List<AccountEntity> accountEntityList);
}
