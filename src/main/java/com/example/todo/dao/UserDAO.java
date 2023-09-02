package com.example.todo.dao;

import com.example.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    List<User> findAll();

    User findById(int id);

    User save (User theUser);

    void deletebyId(int id);


}
