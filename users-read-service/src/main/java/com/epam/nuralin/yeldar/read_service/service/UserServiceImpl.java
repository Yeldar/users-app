package com.epam.nuralin.yeldar.read_service.service;

import com.epam.nuralin.yeldar.read_service.dto.UserDto;
import com.epam.nuralin.yeldar.read_service.exception.NotFoundException;
import com.epam.nuralin.yeldar.read_service.map.UserMapper;
import com.epam.nuralin.yeldar.read_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

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
    public Page<UserDto> findAll(String username, Pageable pageable) {
        if (isNotBlank(username)) {
            return userRepository
                .findByUsernameStartingWith(username, pageable)
                .map(userMapper::toDto);
        }
        return userRepository
            .findAll(pageable)
            .map(userMapper::toDto);
    }
}
