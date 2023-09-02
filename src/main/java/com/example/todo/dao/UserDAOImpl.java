package com.example.todo.dao;

import com.example.todo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager; // entityManager searches in your databse


    @Autowired
   UserDAOImpl (EntityManager theentityManager)
    {
        this.entityManager = theentityManager;
    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("FROM User",User.class);

        List<User> empList = query.getResultList();
        return  empList;
    }


    public User findById(int id) {
        return entityManager.find(User.class,id);
    }


    public User save(User theUser) {


        User dBUser = entityManager.merge(theUser);

        return dBUser;
    }


    public void deletebyId(int id) {
        User deleteUser = entityManager.find(User.class,id);
        entityManager.remove(deleteUser);
    }


}

