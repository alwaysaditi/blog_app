package com.example.todo.service;

import com.example.todo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(int id);




 User saveUser(User theUser);

    //void deletebyId(int id);
}
