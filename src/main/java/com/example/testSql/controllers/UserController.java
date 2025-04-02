package com.example.testSql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testSql.dto.APIResponse;
import com.example.testSql.entities.User;
import com.example.testSql.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public APIResponse<List<User>> getAllUser(){
        List<User> data = userService.findAll();
        APIResponse<List<User>> response = new APIResponse<>("Success", data);
        return response;
    }

    @PostMapping("/")
    public APIResponse<User> addUser(@RequestBody User user){
        user.setId(0);
        User data = userService.save(user);
        APIResponse<User> response = new APIResponse<>("Insert Success", data);
        return response;
    }

    @GetMapping("/{id}")
    public APIResponse<User> getUserById(@PathVariable int id){
        User data = userService.findById(id);
        APIResponse<User> response = new APIResponse<>("Success", data);
        return response;
    }

    @PutMapping("/{id}")
    public APIResponse<User> updateUserById(@PathVariable int id, @RequestBody User user){
        User data = userService.update(id, user);
        APIResponse<User> response = new APIResponse<>("Update Success", data);
        return response;
    }

    @DeleteMapping("/{id}")
    public APIResponse<User> deleteUserById(@PathVariable int id){
        User data = userService.delete(id);
        APIResponse<User> response = new APIResponse<>("Delete Success", data);
        return response;
    }
}
