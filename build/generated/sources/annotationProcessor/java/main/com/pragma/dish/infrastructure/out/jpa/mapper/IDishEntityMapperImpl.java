package com.pragma.dish.infrastructure.out.jpa.mapper;

import com.pragma.dish.domain.model.DishModel;
import com.pragma.dish.infrastructure.out.jpa.entity.DishEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-31T11:46:45-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IDishEntityMapperImpl implements IDishEntityMapper {

    @Override
    public DishEntity toEntity(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishEntity dishEntity = new DishEntity();

        dishEntity.setIdDish( dishModel.getIdDish() );
        dishEntity.setName( dishModel.getName() );
        dishEntity.setPrice( dishModel.getPrice() );
        dishEntity.setDescription( dishModel.getDescription() );
        dishEntity.setUrlImage( dishModel.getUrlImage() );
        dishEntity.setCategory( dishModel.getCategory() );
        dishEntity.setActive( dishModel.getActive() );
        dishEntity.setIdRestaurant( dishModel.getIdRestaurant() );
        dishEntity.setIdOwner( dishModel.getIdOwner() );

        return dishEntity;
    }

    @Override
    public DishModel toDish(DishEntity dishEntity) {
        if ( dishEntity == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setIdOwner( dishEntity.getIdOwner() );
        dishModel.setIdDish( dishEntity.getIdDish() );
        dishModel.setName( dishEntity.getName() );
        dishModel.setPrice( dishEntity.getPrice() );
        dishModel.setDescription( dishEntity.getDescription() );
        dishModel.setUrlImage( dishEntity.getUrlImage() );
        dishModel.setCategory( dishEntity.getCategory() );
        dishModel.setActive( dishEntity.getActive() );
        dishModel.setIdRestaurant( dishEntity.getIdRestaurant() );

        return dishModel;
    }

    @Override
    public List<DishModel> toDishList(List<DishEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<DishModel> list = new ArrayList<DishModel>( userEntityList.size() );
        for ( DishEntity dishEntity : userEntityList ) {
            list.add( toDish( dishEntity ) );
        }

        return list;
    }
}
