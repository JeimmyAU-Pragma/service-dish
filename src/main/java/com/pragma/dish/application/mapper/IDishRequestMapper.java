package com.pragma.dish.application.mapper;


import com.pragma.dish.application.dto.request.DishRequestDto;
import com.pragma.dish.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {
    DishModel toDish(DishRequestDto dishRequestDto);
}
