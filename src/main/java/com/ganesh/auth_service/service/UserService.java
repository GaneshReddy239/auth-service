package com.ganesh.auth_service.service;

import com.ganesh.auth_service.model.User;
import com.ganesh.auth_service.model.UserRequestDto;
import com.ganesh.auth_service.model.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
     List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    UserResponseDto createUser(UserRequestDto user);
    UserResponseDto updateUser(Long id,UserRequestDto user);
    void deleteUser(Long id);

}
