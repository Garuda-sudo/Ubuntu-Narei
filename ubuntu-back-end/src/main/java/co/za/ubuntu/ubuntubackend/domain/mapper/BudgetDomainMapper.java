package co.za.ubuntu.ubuntubackend.domain.mapper;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.ubuntubackend.domain.dto.BudgetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for mapping between {@link BudgetDto} and {@link Budget} objects.
 */
public interface BudgetDomainMapper {

    /**
     * Maps a {@link BudgetDto} object to a {@link Budget} object.
     *
     * @param budgetDto The {@link BudgetDto} to be mapped.
     * @return The mapped {@link Budget} object.
     */
    @Mapping(target = "userId", source = "user.id")
    Budget map(BudgetDto budgetDto);

    /**
     * Maps a list of {@link BudgetDto} objects to a list of {@link Budget} objects.
     *
     * @param budgetDtos The list of {@link BudgetDto} objects to be mapped.
     * @return The list of mapped {@link Budget} objects.
     */
    List<Budget> map(List<BudgetDto> budgetDtos);
}
