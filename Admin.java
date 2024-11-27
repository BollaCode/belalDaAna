/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author user
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class Admin extends PublicUser {
    private Map<String, Trainer> trainers;
    private Map<String, User> users;
    private List<FitnessProgram> fitnessPrograms;

    public Admin(String username, String password) {
        super(username, password);
        this.trainers = new HashMap<>();
        this.users = new HashMap<>();
        this.fitnessPrograms = new ArrayList<>();
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Admin Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Edit User");
            System.out.println("3. Remove User");
            System.out.println("4. List Users");
            System.out.println("5. Manage Trainers");
            System.out.println("6. Manage Fitness Programs");
            System.out.println("7. Save Data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    editUser(scanner);
                    break;
                case 3:
                    removeUser(scanner);
                    break;
                case 4:
                    listUsers();
                    break;
                case 5:
                    manageTrainers(scanner);
                    break;
                case 6:
                    manageFitnessPrograms(scanner);
                    break;
                case 7:
                    saveData();
                    break;
                case 0:
                    System.out.println("Exiting Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }

    // Add User
    private void addUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, new User(username, password) {
            @Override
            public void displayMenu() {
                // User-specific menu logic goes here
            }
        });
        System.out.println("User added successfully.");
    }

    // Edit User
    private void editUser(Scanner scanner) {
        System.out.print("Enter username to edit: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.print("Enter new password: ");
            String password = scanner.nextLine();
            users.put(username, new User(username, password) {
                @Override
                public void displayMenu() {
                    // User-specific menu logic goes here
                }
            });
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    // Remove User
    private void removeUser(Scanner scanner) {
        System.out.print("Enter username to remove: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    // List Users
    private void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users to display.");
        } else {
            System.out.println("Listing Users:");
            for (String username : users.keySet()) {
                System.out.println("- " + username);
            }
        }
    }

    // Manage Trainers
    private void manageTrainers(Scanner scanner) {
        int choice;
        do {
            System.out.println("Trainer Management:");
            System.out.println("1. Add Trainer");
            System.out.println("2. Edit Trainer");
            System.out.println("3. Remove Trainer");
            System.out.println("4. List Trainers");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTrainer(scanner);
                    break;
                case 2:
                    editTrainer(scanner);
                    break;
                case 3:
                    removeTrainer(scanner);
                    break;
                case 4:
                    listTrainers();
                    break;
                case 0:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }

    // Add Trainer
    private void addTrainer(Scanner scanner) {
        System.out.print("Enter trainer username: ");
        String username = scanner.nextLine();
        System.out.print("Enter trainer password: ");
        String password = scanner.nextLine();
        trainers.put(username, new Trainer(username, password));
        System.out.println("Trainer added successfully.");
    }

    // Edit Trainer
    private void editTrainer(Scanner scanner) {
        System.out.print("Enter trainer username to edit: ");
        String username = scanner.nextLine();
        if (trainers.containsKey(username)) {
            System.out.print("Enter new password for trainer: ");
            String password = scanner.nextLine();
            trainers.put(username, new Trainer(username, password));
            System.out.println("Trainer updated successfully.");
        } else {
            System.out.println("Trainer not found.");
        }
    }

    // Remove Trainer
    private void removeTrainer(Scanner scanner) {
        System.out.print("Enter trainer username to remove: ");
        String username = scanner.nextLine();
        if (trainers.containsKey(username)) {
            trainers.remove(username);
            System.out.println("Trainer removed successfully.");
        } else {
            System.out.println("Trainer not found.");
        }
    }

    // List Trainers
    private void listTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers to display.");
        } else {
            System.out.println("Listing Trainers:");
            for (String username : trainers.keySet()) {
                System.out.println("- " + username);
            }
        }
    }

    // Manage Fitness Programs
    private void manageFitnessPrograms(Scanner scanner) {
        int choice;
        do {
            System.out.println("Fitness Program Management:");
            System.out.println("1. Add Fitness Program");
            System.out.println("2. Edit Fitness Program");
            System.out.println("3. Remove Fitness Program");
            System.out.println("4. List Fitness Programs");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFitnessProgram(scanner);
                    break;
                case 2:
                    editFitnessProgram(scanner);
                    break;
                case 3:
                    removeFitnessProgram(scanner);
                    break;
                case 4:
                    listFitnessPrograms();
                    break;
                case 0:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }

    // Add Fitness Program
    private void addFitnessProgram(Scanner scanner) {
        System.out.print("Enter fitness program name: ");
        String name = scanner.nextLine();
        System.out.print("Enter fitness program details: ");
        String details = scanner.nextLine();
        fitnessPrograms.add(new FitnessProgram(name, details));
        System.out.println("Fitness program added successfully.");
    }

    // Edit Fitness Program
    private void editFitnessProgram(Scanner scanner) {
        System.out.print("Enter fitness program name to edit: ");
        String name = scanner.nextLine();
        for (FitnessProgram program : fitnessPrograms) {
            if (program.getName().equals(name)) {
                System.out.print("Enter new details: ");
                String newDetails = scanner.nextLine();
                // Assuming only details can be edited
                fitnessPrograms.remove(program);
                fitnessPrograms.add(new FitnessProgram(name, newDetails));
                System.out.println("Fitness program updated successfully.");
                return;
            }
        }
        System.out.println("Fitness program not found.");
    }

    // Remove Fitness Program
    private void removeFitnessProgram(Scanner scanner) {
        System.out.print("Enter fitness program name to remove: ");
        String name = scanner.nextLine();
        fitnessPrograms.removeIf(program -> program.getName().equals(name));
        System.out.println("Fitness program removed successfully.");
    }

    // List Fitness Programs
    private void listFitnessPrograms() {
        if (fitnessPrograms.isEmpty()) {
            System.out.println("No fitness programs to display.");
        } else {
            System.out.println("Listing Fitness Programs:");
            for (FitnessProgram program : fitnessPrograms) {
                System.out.println("- " + program.getName() + ": " + program.getDetails());
            }
        }
    }

    // Save Data to Files
    private void saveData() {
        try (PrintWriter userWriter = new PrintWriter(new FileWriter("users.txt"));
             PrintWriter trainerWriter = new PrintWriter(new FileWriter("trainers.txt"));
             PrintWriter fitnessProgramWriter = new PrintWriter(new FileWriter("fitnessPrograms.txt"))) {

            // Save Users
            for (User user : users.values()) {
                userWriter.println(user.username + ":" + user.password);
            }

            // Save Trainers
            for (Trainer trainer : trainers.values()) {
                trainerWriter.println(trainer.getUsername() + ":" + trainer.getPassword());
            }

            // Save Fitness Programs
            for (FitnessProgram program : fitnessPrograms) {
                fitnessProgramWriter.println(program.getName() + ":" + program.getDetails());
            }

            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    
}
