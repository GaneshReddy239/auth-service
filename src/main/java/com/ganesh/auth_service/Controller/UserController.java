package com.ganesh.auth_service.Controller;

import com.ganesh.auth_service.model.User;
import com.ganesh.auth_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService us;
    @GetMapping
    public List<User> getAllUsers(){
        return us.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return us.getUserById(id);
    }
}
