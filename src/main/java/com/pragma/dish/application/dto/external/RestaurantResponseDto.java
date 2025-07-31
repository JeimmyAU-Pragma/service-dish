package com.pragma.dish.application.dto.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponseDto {
    private Long idRestaurant;
    private String name;
    private String nit;
    private Long idOwner;

}
