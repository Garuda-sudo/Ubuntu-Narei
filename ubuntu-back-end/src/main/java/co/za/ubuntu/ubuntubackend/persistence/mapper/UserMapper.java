package co.za.ubuntu.ubuntubackend.persistence.mapper;

import co.za.ubuntu.ubuntubackend.domain.dto.UserDto;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserEntity map(UserDto userDto);

    UserDto map(UserEntity userEntity);
}
