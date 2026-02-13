package com.epam.nuralin.yeldar.write_service.controller;

import com.epam.nuralin.yeldar.write_service.dto.ChangePasswordRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.CreateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserResponseDto;
import com.epam.nuralin.yeldar.write_service.service.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserCommandController {

    private final UserCommandService userCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Long>> create(@RequestBody CreateUserRequestDto dto) {
        Long id = userCommandService.create(dto);
        return ResponseEntity.ok(Map.of("id", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponseDto> update(
        @PathVariable Long id,
        @RequestBody UpdateUserRequestDto dto) {
        return ResponseEntity.ok(userCommandService.update(id, dto));
    }

    @PutMapping("/{id}/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id,
                       @RequestBody ChangePasswordRequestDto dto) {
        userCommandService.changePassword(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userCommandService.delete(id);
    }
}
