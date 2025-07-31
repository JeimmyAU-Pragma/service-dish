package com.pragma.dish.infrastructure.out.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service", url = "${restaurant.service.url}")
public interface IRestaurantClient {

    @GetMapping("/api/v1/Restaurant/{idRestaurant}/owner/{idOwner}")
    boolean isOwner(@PathVariable Long idRestaurant, @PathVariable Long idOwner);
}
