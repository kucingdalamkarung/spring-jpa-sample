package io.github.kucingdalamkarung.springjpasample.service;

import io.github.kucingdalamkarung.springjpasample.entity.User;
import io.github.kucingdalamkarung.springjpasample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().stream().forEach(users::add);
        return users;
    }

    public Optional<User> getUser(Integer id) {
        return userRepo.findById(id);
    }

    public void createUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(User user) {
        User user1 = userRepo.getOne(user.getId());
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user1.getPassword());
        userRepo.save(user1);
    }

    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

}
