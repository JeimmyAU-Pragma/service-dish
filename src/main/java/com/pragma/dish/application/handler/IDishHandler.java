package com.pragma.dish.application.handler;

import com.pragma.dish.application.dto.request.DishRequestDto;
import com.pragma.dish.application.dto.response.DishResponseDto;

import java.util.List;

public interface IDishHandler {

    void saveDish(DishRequestDto dishRequestDto);

    List<DishResponseDto> getAllDishes();
}