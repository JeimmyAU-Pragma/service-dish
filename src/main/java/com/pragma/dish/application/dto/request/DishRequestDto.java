package com.pragma.dish.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishRequestDto {
    private String name;
    private Long price;
    private String description;
    private String urlImage;
    private String category;
    private Boolean active;
    private Long idRestaurant;
    private Long idOwner;
}
