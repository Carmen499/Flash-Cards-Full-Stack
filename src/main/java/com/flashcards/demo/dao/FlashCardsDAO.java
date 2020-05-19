package com.flashcards.demo.dao;

import com.flashcards.demo.entity.FlashCards;

import java.util.List;

public interface FlashCardsDAO {

    //dao Methods

    List<FlashCards> findAll();
    FlashCards findById(int id);
    void save(FlashCards flashcards);
    void deleteById(int id);
}
