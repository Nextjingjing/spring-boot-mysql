package com.example.testSql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testSql.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
