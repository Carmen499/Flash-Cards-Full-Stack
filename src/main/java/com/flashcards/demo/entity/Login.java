package com.flashcards.demo.entity;


import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {

    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "UserName")
    private String UserName;

    @Column(name = "Password")
    private String Password;

    public Login(){

    }

    public Login(int id, String userName, String password) {
        this.id = id;
        UserName = userName;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id:" + id +
                ", UserName:'" + UserName + '\'' +
                ", Password:'" + Password + '\'' +
                '}';
    }
}