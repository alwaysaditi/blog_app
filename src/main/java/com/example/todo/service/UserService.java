package com.example.todo.service;

import com.example.todo.entity.User;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);




 User saveUser(User theUser);

    void deletebyId(int id);
}
