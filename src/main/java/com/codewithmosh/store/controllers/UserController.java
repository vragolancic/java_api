package com.codewithmosh.store.controllers;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;


    @GetMapping("users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
