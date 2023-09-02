package com.example.todo.service;

import com.example.todo.dao.UserDAO;
import com.example.todo.entity.User;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDAO userDAO;



    @Autowired
    public UserServiceImpl(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }



    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public User saveUser(User theUser) {
        return userDAO.save(theUser);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        userDAO.deletebyId(id);
    }

}
