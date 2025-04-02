package com.example.testSql.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testSql.entities.User;
import com.example.testSql.repository.UserRepository;

@Service
public class UserServiceAction implements UserService {

    private UserRepository userRepository;

    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(int id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(int id, User user){
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        existingUser.setName(user.getName());
        return userRepository.save(existingUser);
    }

    @Override
    public User delete(int id){
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        userRepository.delete(existingUser);
        return existingUser;
    }
}
