package com.epam.nuralin.yeldar.write_service.service;

import com.epam.nuralin.yeldar.write_service.dto.ChangePasswordRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.CreateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserResponseDto;
import com.epam.nuralin.yeldar.write_service.entity.UserEntity;
import com.epam.nuralin.yeldar.write_service.exception.AlreadyExistException;
import com.epam.nuralin.yeldar.write_service.exception.NotFoundException;
import com.epam.nuralin.yeldar.write_service.mapper.UsersMapper;
import com.epam.nuralin.yeldar.write_service.repository.UserRepository;
import com.epam.nuralin.yeldar.write_service.util.HashUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final UsersMapper usersMapper;

    @Override
    public Long create(CreateUserRequestDto dto) {
        if (userRepository.existsByUsername(dto.username())) {
            throw new AlreadyExistException("User with provided username already exists");
        }
        UserEntity entity = usersMapper.fromCreateUserRequestDto(dto);
        userRepository.save(entity);
        return entity.getId();
    }

    @Override
    public UpdateUserResponseDto update(Long id, UpdateUserRequestDto dto) {
        UserEntity entity = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User with provided id not found"));
        entity.setFullName(dto.fullName());
        userRepository.save(entity);
        return usersMapper.toUpdateUserResponseDto(entity);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        UserEntity entity = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User with provided id not found"));
        userRepository.delete(entity);
    }

    @Override
    public void changePassword(Long id, ChangePasswordRequestDto dto) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        UserEntity entity = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User with provided id not found"));

        boolean isEqual;
        try {
            isEqual = 0 == Arrays.compare(entity.getPasswordHash(), HashUtils.sha256(dto.currentPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm not supported");
        }
        if (!isEqual) {
            throw new IllegalArgumentException("Provided current password is not valid.");
        }
        byte[] pwdHash;
        try {
            pwdHash = HashUtils.sha256(dto.newPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm not supported");
        }
        entity.setPasswordHash(pwdHash);
        userRepository.save(entity);
    }
}
