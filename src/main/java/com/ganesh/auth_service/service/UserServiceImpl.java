package com.ganesh.auth_service.service;

import com.ganesh.auth_service.Configuration.Mapper;
import com.ganesh.auth_service.GlobalExceptionHandler.ResourceNotFound;
import com.ganesh.auth_service.model.User;
import com.ganesh.auth_service.model.UserRequestDto;
import com.ganesh.auth_service.model.UserResponseDto;
import com.ganesh.auth_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    Mapper mp;
    public List<UserResponseDto> getAllUsers(){
        return userRepo.findAll().stream().map(user->mp.getMapper().map(user, UserResponseDto.class)).toList();
    }

    @Override
public UserResponseDto getUserById(Long id) {
        //User user=users.stream().filter(user1-> user1.getId().equals(id)).findFirst().orElseThrow(()-> new RuntimeException("User Not found"));
        User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFound("User not found with",id));
        return mp.getMapper().map(user, UserResponseDto.class);

    }
    @Transactional
    @Override
    public UserResponseDto createUser(UserRequestDto user1) {
        User user=mp.getMapper().map(user1, User.class);
        User userres= userRepo.save(user);
        UserResponseDto userdto=mp.getMapper().map(userres, UserResponseDto.class);
        return userdto;

    }
    @Transactional
    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userdto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " , id));

        if (userdto.getUsername() != null) user.setUsername(userdto.getUsername());
        if (userdto.getEmail() != null) user.setEmail(userdto.getEmail());
        if (userdto.getPassword() != null) user.setPassword(userdto.getPassword());
        if (userdto.getRole() != null) user.setRole(userdto.getRole());

        return mp.getMapper().map(userRepo.save(user), UserResponseDto.class);

    }
    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepo.findById(id).orElseThrow(()->new ResourceNotFound("User not found",id));
        userRepo.deleteById(id);
    }
}
