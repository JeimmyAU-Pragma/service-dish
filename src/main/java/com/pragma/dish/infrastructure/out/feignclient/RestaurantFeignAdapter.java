package com.pragma.dish.infrastructure.out.feignclient;

import com.pragma.dish.domain.spi.IRestaurantFeignPort;
import org.springframework.stereotype.Component;

@Component
public class RestaurantFeignAdapter implements IRestaurantFeignPort {

    private final IRestaurantClient restaurantClient;

    public RestaurantFeignAdapter(IRestaurantClient restaurantClient) {

        this.restaurantClient = restaurantClient;
    }

    @Override
    public boolean isOwner(Long idRestaurant, Long idOwner) {
        return restaurantClient.isOwner(idRestaurant,idOwner);
    }


}
