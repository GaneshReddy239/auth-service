package com.ganesh.auth_service.Controller;

import com.ganesh.auth_service.model.User;
import com.ganesh.auth_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService us;

    @GetMapping
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return us.getUserById(id);

    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return us.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return us.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        us.deleteUser(id);
        return "success";

    }
}

