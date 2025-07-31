package com.pragma.dish.application.mapper;

import com.pragma.dish.application.dto.request.DishRequestDto;
import com.pragma.dish.domain.model.DishModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-31T11:18:40-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IDishRequestMapperImpl implements IDishRequestMapper {

    @Override
    public DishModel toDish(DishRequestDto dishRequestDto) {
        if ( dishRequestDto == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setIdOwner( dishRequestDto.getIdOwner() );
        dishModel.setName( dishRequestDto.getName() );
        dishModel.setPrice( dishRequestDto.getPrice() );
        dishModel.setDescription( dishRequestDto.getDescription() );
        dishModel.setUrlImage( dishRequestDto.getUrlImage() );
        dishModel.setCategory( dishRequestDto.getCategory() );
        dishModel.setActive( dishRequestDto.getActive() );
        dishModel.setIdRestaurant( dishRequestDto.getIdRestaurant() );

        return dishModel;
    }
}
