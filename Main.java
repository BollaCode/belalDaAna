/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author user
 */
import java.util.*;
import java.util.HashMap;
import java.lang.UnsupportedOperationException;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, User> users = new HashMap<>();  // Stores all users by username
        HashMap<String, Admin> admins = new HashMap<>();  // Stores all admins by username
        HashMap<String, Trainer> trainers = new HashMap<>();  // Stores all trainers by username

        while (true) {
            System.out.println("Welcome to the System!");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1: // Sign Up
                    signUp(scanner, users, admins, trainers);
                    break;
                case 2: // Sign In
                    signIn(scanner, users, admins, trainers);
                    break;
                case 3: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void signUp(Scanner scanner, HashMap<String, User> users, HashMap<String, Admin> admins, HashMap<String, Trainer> trainers) {
        System.out.println("Sign Up - Choose your role:");
        System.out.println("1. Admin");
        System.out.println("2. Trainer");
        System.out.println("3. User");
        System.out.print("Choose an option: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        switch (roleChoice) {
            case 1:
                if (admins.containsKey(username)) {
                    System.out.println("Admin already exists with this username.");
                } else {
                    Admin admin = new Admin(username, password);
                    admins.put(username, admin);
                    System.out.println("Admin created successfully.");
                }
                break;
            case 2:
                if (trainers.containsKey(username)) {
                    System.out.println("Trainer already exists with this username.");
                } else {
                    Trainer trainer = new Trainer(username, password);
                    trainers.put(username, trainer);
                    System.out.println("Trainer created successfully.");
                }
                break;
            case 3:
                if (users.containsKey(username)) {
                    System.out.println("User already exists with this username.");
                } else {
                    User user = new User(username, password);
                    users.put(username, user);
                    System.out.println("User created successfully.");
                }
                break;
            default:
                System.out.println("Invalid role choice.");
        }
    }

    private static void signIn(Scanner scanner, HashMap<String, User> users, HashMap<String, Admin> admins, HashMap<String, Trainer> trainers) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if user is an Admin
        if (admins.containsKey(username) && admins.get(username).getPassword().equals(password)) {
            Admin admin = admins.get(username);
            admin.displayMenu();
        }
        // Check if user is a Trainer
        else if (trainers.containsKey(username) && trainers.get(username).getPassword().equals(password)) {
            Trainer trainer = trainers.get(username);
            trainer.displayMenu();
        }
        // Check if user is a User
        else if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            User user = users.get(username);
            user.displayMenu();
        }
        else {
            System.out.println("Invalid username or password.");
        }
    }
}
