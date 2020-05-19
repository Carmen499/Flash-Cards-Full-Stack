package com.flashcards.demo.rest;


import com.flashcards.demo.dao.FlashCardsDAO;
import com.flashcards.demo.entity.FlashCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class FlashCardsController {

    private final FlashCardsDAO flashCardsDAO;
    @Autowired
    public FlashCardsController(FlashCardsDAO flashCardsDAO){
        this.flashCardsDAO =flashCardsDAO;

    }

    //This is a GET request that will read a list of all the food items.
    //http://localhost:8080/retrieveAllFlashCards
    @GetMapping("/retrieveAllFlashCards")
    public List<FlashCards> findAll() {
        return flashCardsDAO.findAll();
    }

    //This is a POST request to add a new flash card .
    //http://localhost:8080/addFlashCards
    @PostMapping("/addFlashCards")
    public FlashCards addFlashCards(@RequestBody FlashCards flashCards) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        flashCards.setId(0);

        //This will call the FlashCardsDaoImpl.save method to save a new food item
        flashCardsDAO.save(flashCards);
        return flashCards;
    }

    //This is a PUT request to update an existing flash card.
    //http://localhost:8080/updateFlashCards
    @PutMapping("/updateFlashCards")
    public FlashCards updateFlashCards(@RequestBody FlashCards updateFlashCards) {
        flashCardsDAO.save((updateFlashCards));
        return updateFlashCards;
    }

    //This is a DELETE request to delete an existing flash card.
    //http://localhost:8080/deleteFlashCards/1
    @DeleteMapping("/deleteFlashCards/{id}")
    public String deleteFlashCards(@PathVariable int id) {

        //Creating a tempFlashCard to check to see if a flash card exists
        FlashCards tempFlashCards = flashCardsDAO.findById(id);

        //This will throw an exception if the flash card is null
        if(tempFlashCards == null) {
            throw new RuntimeException("Flash Card not found : " + id);
        }

        //This will execute the deleteByID method in the FlashCardDaoImpl.
        flashCardsDAO.deleteById(id);
        return "Deleted flash card id : " + id;
    }




}
