package com.ganesh.auth_service.service;

import com.ganesh.auth_service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> users=new ArrayList<>();
    public UserServiceImpl(){
        users.add(new User(1L, "Ganesh", "ganeshreddy@gmail.com"));
        users.add(new User(2L, "Kiran", "kiranreddy@gmail.com"));
        users.add(new User(3L, "Viswass", "viswassreddy@gmail.com"));
    }
    public List<User> getAllUsers(){

        return users;
    }

    @Override
public User getUserById(Long id) {
        User user=users.stream().filter(user1-> user1.getId().equals(id)).findFirst().orElseThrow(()-> new RuntimeException("User Not found"));
        return user;
    }
}
