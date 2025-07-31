package com.pragma.dish.infrastructure.configuration;

import com.pragma.dish.domain.api.IDishServicePort;
import com.pragma.dish.domain.spi.IDishPersistencePort;
import com.pragma.dish.domain.spi.IRestaurantFeignPort;
import com.pragma.dish.domain.usecase.DishUseCase;
import com.pragma.dish.infrastructure.out.feignclient.IRestaurantClient;
import com.pragma.dish.infrastructure.out.feignclient.RestaurantFeignAdapter;
import com.pragma.dish.infrastructure.out.jpa.adapter.DishJpaAdapter;
import com.pragma.dish.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.dish.infrastructure.out.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;


    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishJpaAdapter(dishRepository, dishEntityMapper);
    }
    @Bean
    public IRestaurantFeignPort restaurantFeignPort(IRestaurantClient restaurantClient) {
        return new RestaurantFeignAdapter(restaurantClient);
    }
    @Bean
    public IDishServicePort dishServicePort(IDishPersistencePort dishPersistencePort,
                                                  IRestaurantFeignPort restaurantFeignPort) {
        return new DishUseCase(dishPersistencePort,restaurantFeignPort);
    }

}