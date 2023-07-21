package co.za.ubuntu.ubuntubackend.domain.mapper;
import co.za.ubuntu.ubuntubackend.domain.Budget;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    BudgetEntity map(Budget budget);

    Budget map(BudgetEntity budget);

}
