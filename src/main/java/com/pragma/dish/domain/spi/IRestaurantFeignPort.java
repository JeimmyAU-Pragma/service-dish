package com.pragma.dish.domain.spi;

public interface IRestaurantFeignPort {
    boolean isOwner(Long idRestaurant, Long idOwner);

    //RestaurantResponseDto isOwner(Long idRestaurant, Long idOwner);
}
