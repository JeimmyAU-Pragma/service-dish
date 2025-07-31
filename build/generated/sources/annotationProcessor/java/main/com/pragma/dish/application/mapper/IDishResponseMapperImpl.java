package com.pragma.dish.application.mapper;

import com.pragma.dish.application.dto.response.DishResponseDto;
import com.pragma.dish.domain.model.DishModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-31T11:41:40-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IDishResponseMapperImpl implements IDishResponseMapper {

    @Override
    public DishResponseDto toResponse(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishResponseDto dishResponseDto = new DishResponseDto();

        dishResponseDto.setIdDish( dishModel.getIdDish() );
        dishResponseDto.setName( dishModel.getName() );
        dishResponseDto.setPrice( dishModel.getPrice() );
        dishResponseDto.setDescription( dishModel.getDescription() );
        dishResponseDto.setUrlImage( dishModel.getUrlImage() );
        dishResponseDto.setCategory( dishModel.getCategory() );
        dishResponseDto.setActive( dishModel.getActive() );
        dishResponseDto.setIdRestaurant( dishModel.getIdRestaurant() );

        return dishResponseDto;
    }

    @Override
    public List<DishResponseDto> toResponseList(List<DishModel> dishesModelList) {
        if ( dishesModelList == null ) {
            return null;
        }

        List<DishResponseDto> list = new ArrayList<DishResponseDto>( dishesModelList.size() );
        for ( DishModel dishModel : dishesModelList ) {
            list.add( toResponse( dishModel ) );
        }

        return list;
    }
}
