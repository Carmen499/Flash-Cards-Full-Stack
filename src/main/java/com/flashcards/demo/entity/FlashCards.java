package com.flashcards.demo.entity;


import javax.persistence.*;

@Entity
@Table(name="flash_cards")
public class FlashCards {


    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "Question")
    private String Question;

    @Column(name = "Answer")
    private String Answer;

    public FlashCards(){

    }

    public FlashCards(int id, String question, String answer) {
        this.id = id;
        Question = question;
        Answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    @Override
    public String toString() {
        return "FlashCards{" +
                "id:" + id +
                ", Question:'" + Question + '\'' +
                ", Answer:'" + Answer + '\'' +
                '}';
    }
}
