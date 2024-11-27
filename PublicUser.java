/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 * @author user
 */
import java.util.Scanner;

public abstract class PublicUser {
    public String username;
    public String password;

    // Constructor
    public PublicUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Abstract method for menu to be implemented by subclasses
    public abstract void displayMenu();
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

