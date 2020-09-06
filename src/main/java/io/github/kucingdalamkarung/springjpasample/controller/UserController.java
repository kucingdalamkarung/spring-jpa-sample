package io.github.kucingdalamkarung.springjpasample.controller;

import io.github.kucingdalamkarung.springjpasample.entity.User;
import io.github.kucingdalamkarung.springjpasample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
