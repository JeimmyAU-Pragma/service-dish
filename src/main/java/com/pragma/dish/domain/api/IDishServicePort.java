package com.pragma.dish.domain.api;

import com.pragma.dish.domain.model.DishModel;

import java.util.List;

public interface IDishServicePort {

    void saveDish(DishModel dishModel);

    List<DishModel> getAllDishes();

}