package com.pragma.dish.infrastructure.out.jpa.adapter;

import com.pragma.dish.domain.model.DishModel;
import com.pragma.dish.domain.spi.IDishPersistencePort;
import com.pragma.dish.infrastructure.exception.NoDataFoundException;
import com.pragma.dish.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.dish.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.dish.infrastructure.out.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DishJpaAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public DishModel saveDish(DishModel dishModel) {
        DishEntity dishEntity = dishRepository.save(dishEntityMapper.toEntity(dishModel));
        return dishEntityMapper.toDish(dishEntity);
    }

    @Override
    public List<DishModel> getAllDishes() {
        List<DishEntity> entityList = dishRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return dishEntityMapper.toDishList(entityList);
    }
}