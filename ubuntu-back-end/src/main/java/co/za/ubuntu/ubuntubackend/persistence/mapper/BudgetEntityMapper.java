package co.za.ubuntu.ubuntubackend.persistence.mapper;

import co.za.ubuntu.model.Budget;
import co.za.ubuntu.ubuntubackend.domain.exception.NotFoundException;
import co.za.ubuntu.ubuntubackend.persistence.entity.BudgetEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface BudgetEntityMapper {

    @Autowired
    UserRepository userRepository;

    @Mapping(target = "userId", source = "userEntity.id")
    Budget map(BudgetEntity budgetEntity);

    @Mapping(target = "userEntity.id", source = "userId", qualifiedByName = "userMapping")
    BudgetEntity map(Budget budget);

    @Named("userMapping")
    static UserEntity userMapping(Integer userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("No user found with ID: " + userId));
    }
}
