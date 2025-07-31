package com.pragma.dish.domain.usecase;

import com.pragma.dish.application.dto.external.RestaurantResponseDto;
import com.pragma.dish.domain.api.IDishServicePort;
import com.pragma.dish.domain.exception.DomainException;
import com.pragma.dish.domain.model.DishModel;
import com.pragma.dish.domain.spi.IDishPersistencePort;
import com.pragma.dish.domain.spi.IRestaurantFeignPort;
import com.pragma.dish.infrastructure.exception.NoDataFoundException;

import java.util.List;
import java.util.Optional;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;
    private  final IRestaurantFeignPort restaurantFeignPort;

    public DishUseCase(IDishPersistencePort dishPersistencePort, IRestaurantFeignPort restaurantFeignPort) {
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantFeignPort = restaurantFeignPort;
    }

    @Override
    public void saveDish(DishModel dishModel) {
        // Validaciones

        if (dishModel.getName() == null || dishModel.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del plato es obligatorio.");
        }

        if (dishModel.getPrice() == null || dishModel.getPrice() <= 0) {
            throw new IllegalArgumentException("El precio debe ser un número entero positivo mayor a 0.");
        }

        if (dishModel.getDescription() == null || dishModel.getDescription().isBlank()) {
            throw new IllegalArgumentException("La descripción del plato es obligatoria.");
        }

        if (dishModel.getUrlImage() == null || dishModel.getUrlImage().isBlank()) {
            throw new IllegalArgumentException("La URL de la imagen es obligatoria.");
        }

        if (dishModel.getCategory() == null || dishModel.getCategory().isBlank()) {
            throw new IllegalArgumentException("La categoría es obligatoria.");
        }

        if (dishModel.getIdRestaurant() == null) {
            throw new IllegalArgumentException("El id del restaurante es obligatorio.");
        }
        if (dishModel.getIdOwner() == null) {
            throw new IllegalArgumentException("El id del propietario es obligatorio.");
        }
        // la union entre los 3
        boolean isOwner = restaurantFeignPort.isOwner(dishModel.getIdRestaurant(), dishModel.getIdOwner());
        if (!isOwner) {
            throw new DomainException("El usuario no es el propietario del restaurante");
        }

        dishModel.setActive(true);

        dishPersistencePort.saveDish(dishModel);
    }

    @Override
    public List<DishModel> getAllDishes() {
        return dishPersistencePort.getAllDishes();
    }

}