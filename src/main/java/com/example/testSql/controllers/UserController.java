package com.example.testSql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<APIResponse<List<User>>> getAllUser() {
        List<User> data = userService.findAll();
        APIResponse<List<User>> response = new APIResponse<>("Success", data);
        return new ResponseEntity<>(
            response, 
            HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<APIResponse<User>> addUser(@RequestBody User user) {
        user.setId(0);
        User data = userService.save(user);
        APIResponse<User> response = new APIResponse<>("Insert Success", data);
        return new ResponseEntity<>(
            response, 
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<User>> getUserById(@PathVariable int id) {
        User data = userService.findById(id);
        if (data == null) {
            APIResponse<User> response = new APIResponse<>("User not found", null);
            return new ResponseEntity<>(
                response, 
                HttpStatus.NOT_FOUND
            );
        }

        APIResponse<User> response = new APIResponse<>("Success", data);
        return new ResponseEntity<>(
            response, 
            HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<User>> updateUserById(@PathVariable int id, @RequestBody User user) {
        User data = userService.update(id, user);
        if (data == null) {
            APIResponse<User> response = new APIResponse<>("User not found", null);
            return new ResponseEntity<>(
                response, 
                HttpStatus.NOT_FOUND
            );
        }

        APIResponse<User> response = new APIResponse<>("Update Success", data);
        return new ResponseEntity<>(
            response, 
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<User>> deleteUserById(@PathVariable int id) {
        User data = userService.delete(id);
        if (data == null) {
            APIResponse<User> response = new APIResponse<>("User not found", null);
            return new ResponseEntity<>(
                response, 
                HttpStatus.NOT_FOUND
            );
        }

        APIResponse<User> response = new APIResponse<>("Delete Success", data);
        return new ResponseEntity<>(
            response, 
            HttpStatus.OK
        );
    }
}
