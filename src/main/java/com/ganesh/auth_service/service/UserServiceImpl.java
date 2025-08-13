package com.ganesh.auth_service.service;

import com.ganesh.auth_service.model.User;
import com.ganesh.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @Override
public User getUserById(Long id) {
        //User user=users.stream().filter(user1-> user1.getId().equals(id)).findFirst().orElseThrow(()-> new RuntimeException("User Not found"));
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));

    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);

    }

    @Override
    public User updateUser(Long id, User user) {
        User user1=userRepo.findById(id).orElseThrow(()->new RuntimeException("User is not available"));
        if (user.getUsername() != null) {
            user1.setUsername(user.getUsername());
        }
        if (user.getEmail() != null) {
            user1.setEmail(user.getEmail());
        }
        if(user.getPassword() != null) {
            user1.setPassword(user.getPassword());
        }
        if(user.getRole()!= null){
            user1.setRole(user.getRole());
        }
        userRepo.save(user1);
        return user1;

    }

    @Override
    public void deleteUser(Long id) {
        userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        userRepo.deleteById(id);
    }
}
