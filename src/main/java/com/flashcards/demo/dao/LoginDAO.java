package com.flashcards.demo.dao;

import com.flashcards.demo.entity.Login;

import java.util.List;

public interface LoginDAO {
    //dao Methods

    List<Login> findAll();
    Login findById(int id);
    void save(Login login);
    void deleteById(int id);

}
