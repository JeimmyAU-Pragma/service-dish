package com.pragma.dish.domain.spi;


import com.pragma.dish.application.dto.external.UserResponseDto;

public interface IUserFeignPort {
    UserResponseDto getUserById(Long id);
    UserResponseDto getAuthenticatedUser();
}
