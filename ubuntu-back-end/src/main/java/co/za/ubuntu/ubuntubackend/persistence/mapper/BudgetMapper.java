package co.za.ubuntu.ubuntubackend.persistence.mapper;

import co.za.ubuntu.ubuntubackend.domain.dto.BudgetDto;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the entity {@link BudgetEntity} and its DTO called {@link BudgetDto}.
 * This mapper was generated automatically by MapStruct.
 */
@Mapper
public interface BudgetMapper {

    BudgetEntity map(BudgetDto budgetDto);

    BudgetDto map(BudgetEntity budgetEntity);

    List<BudgetDto> map(List<BudgetEntity> budgetEntityList);
}
