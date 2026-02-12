package com.epam.nuralin.yeldar.events_service.service;

import com.epam.nuralin.yeldar.events_service.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto findById(Long id);

    Page<UserDto> findByUsernameStartWith(String username, Pageable pageable);

    Page<UserDto> findAll(Pageable pageable);
}
