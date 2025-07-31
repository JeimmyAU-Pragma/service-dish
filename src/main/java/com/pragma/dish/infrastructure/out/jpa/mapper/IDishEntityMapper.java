package com.pragma.dish.infrastructure.out.jpa.mapper;

import com.pragma.dish.domain.model.DishModel;
import com.pragma.dish.infrastructure.out.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IDishEntityMapper {

    DishEntity toEntity(DishModel dishModel);
    DishModel toDish(DishEntity dishEntity);
    List<DishModel> toDishList(List<DishEntity> userEntityList);
}