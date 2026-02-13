package com.epam.nuralin.yeldar.read_service.controller;

import com.epam.nuralin.yeldar.read_service.dto.UserDto;
import com.epam.nuralin.yeldar.read_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersReadController {

    private final UserService userService;

    @GetMapping
    public Page<UserDto> findAll(
        @RequestParam(required = false) String username,
        Pageable pageable) {
        return userService.findAll(username, pageable);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
