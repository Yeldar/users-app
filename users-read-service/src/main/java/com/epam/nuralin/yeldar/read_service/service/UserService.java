package com.epam.nuralin.yeldar.read_service.service;

import com.epam.nuralin.yeldar.read_service.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto findById(Long id);

    Page<UserDto> findAll(String username, Pageable pageable);
}
