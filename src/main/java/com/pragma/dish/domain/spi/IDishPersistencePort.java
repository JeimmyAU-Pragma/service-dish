package com.pragma.dish.domain.spi;

import com.pragma.dish.domain.model.DishModel;

import java.util.List;

public interface IDishPersistencePort {
    DishModel saveDish(DishModel dishModel);

    List<DishModel> getAllDishes();

    DishModel getDishById(Long dishId);
    void updateDish(Long dishId, Long ownerId, Long price, String description);
}