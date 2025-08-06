package com.pragma.dish.domain.api;

import com.pragma.dish.application.dto.request.DishUpdateRequestDto;
import com.pragma.dish.domain.model.DishModel;

import java.util.List;

public interface IDishServicePort {

    void saveDish(DishModel dishModel);

    List<DishModel> getAllDishes();

    DishModel getDishById(Long dishId);

    void updateDish(Long dishId, Long ownerId, DishUpdateRequestDto request);

}