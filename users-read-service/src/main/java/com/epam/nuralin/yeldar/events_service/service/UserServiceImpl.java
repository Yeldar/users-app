package com.epam.nuralin.yeldar.events_service.service;

import com.epam.nuralin.yeldar.events_service.dto.UserDto;
import com.epam.nuralin.yeldar.events_service.exception.NotFoundException;
import com.epam.nuralin.yeldar.events_service.map.UserMapper;
import com.epam.nuralin.yeldar.events_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto findById(Long id) {
        return userRepository
            .findById(id)
            .map(userMapper::toDto)
            .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @Override
    public Page<UserDto> findByUsernameStartWith(String username, Pageable pageable) {
        return userRepository
            .findByUsernameStartWith(username, pageable)
            .map(userMapper::toDto);
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository
            .findAll(pageable)
            .map(userMapper::toDto);
    }
}
