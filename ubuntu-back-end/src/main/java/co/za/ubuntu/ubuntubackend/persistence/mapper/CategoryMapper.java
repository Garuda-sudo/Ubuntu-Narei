package co.za.ubuntu.ubuntubackend.persistence.mapper;

import co.za.ubuntu.ubuntubackend.domain.dto.CategoryDto;
import co.za.ubuntu.ubuntubackend.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the entity {@link CategoryEntity} and its DTO called {@link CategoryDto}.
 * This mapper was generated automatically by MapStruct.
 */
@Mapper
public interface CategoryMapper {

    CategoryEntity map(CategoryDto categoryDto);

    CategoryDto map(CategoryEntity categoryEntity);

    List<CategoryDto> map(List<CategoryEntity> categoryEntityList);
}
