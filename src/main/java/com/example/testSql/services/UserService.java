package com.example.testSql.services;

import java.util.List;

import com.example.testSql.entities.User;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    User update(int id, User user);
    User delete(int id);
}
