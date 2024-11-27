/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.Scanner;

public class User extends PublicUser {

    
    String username;
    String password;
    private ArrayList<String> workoutLog;
    private ArrayList<String> goals;
    private String progressReport;

    // Constructor
    public User(String username,String password) {
        super(username,password);
       
        this.workoutLog = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.progressReport = "";
        
    }

    // Log a workout
    public void logWorkout(String workout) {
        workoutLog.add(workout);
        System.out.println("Workout logged: " + workout);
    }

    // View logged workouts
    public void viewLoggedWorkouts() {
        if (workoutLog.isEmpty()) {
            System.out.println("No workouts logged yet.");
        } else {
            System.out.println("Logged Workouts:");
            for (String workout : workoutLog) {
                System.out.println("- " + workout);
            }
        }
    }

    // Set a goal
    public void setGoal(String goal) {
        goals.add(goal);
        System.out.println("Goal set: " + goal);
    }

    // View goals
    public void viewGoals() {
        if (goals.isEmpty()) {
            System.out.println("No goals set yet.");
        } else {
            System.out.println("Your Goals:");
            for (int i = 0; i < goals.size(); i++) {
                System.out.println((i + 1) + ". " + goals.get(i));
            }
        }
    }

    // Delete a goal
    public void deleteGoal(int index) {
        if (index >= 0 && index < goals.size()) {
            System.out.println("Goal deleted: " + goals.get(index));
            goals.remove(index);
        } else {
            System.out.println("Invalid goal number.");
        }
    }

    // Receive and set a progress report
    public void receiveProgressReport(String reportContent) {
        this.progressReport = reportContent;
        System.out.println("Progress report updated.");
    }

    // Check if a goal is achieved
    public void checkGoalAchievement() {
        if (goals.isEmpty()) {
            System.out.println("No goals set yet.");
            return;
        }

        if (workoutLog.isEmpty()) {
            System.out.println("No workouts logged yet. Please log some workouts first.");
            return;
        }

        for (String goal : goals) {
            boolean achieved = false;

            // Check if goal matches any logged workout (for simplicity, we assume any workout is an achievement)
            for (String workout : workoutLog) {
                if (workout.contains(goal)) {
                    achieved = true;
                    break;
                }
            }

            if (achieved) {
                System.out.println("Goal achieved: " + goal);
            } else {
                System.out.println("Goal not achieved: " + goal);
            }
        }
    }

    // User menu with options
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Log a Workout");
            System.out.println("2. View Logged Workouts");
            System.out.println("3. Set a Goal");
            System.out.println("4. View Goals");
            System.out.println("5. Delete a Goal");
            System.out.println("6. Receive Progress Report");
            System.out.println("7. Check Goal Achievement");
            System.out.println("8. Log out");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter workout to log: ");
                    String workout = scanner.nextLine();
                    logWorkout(workout);
                    break;
                case 2:
                    viewLoggedWorkouts();
                    break;
                case 3:
                    System.out.print("Enter goal to set: ");
                    String goal = scanner.nextLine();
                    setGoal(goal);
                    break;
                case 4:
                    viewGoals();
                    break;
                case 5:
                    System.out.print("Enter goal number to delete: ");
                    int index = scanner.nextInt();
                    deleteGoal(index - 1); // subtract 1 for zero-based index
                    break;
                case 6:
                    System.out.print("Enter progress report content: ");
                    String reportContent = scanner.nextLine();
                    receiveProgressReport(reportContent);
                    break;
                case 7:
                    checkGoalAchievement();
                    break;
                case 8:
                    System.out.println("Logging out.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    public ArrayList<String> getWorkoutLog() {
        return workoutLog;
    }

    public ArrayList<String> getGoals() {
        return goals;
    }

    public String getProgressReport() {
        return progressReport;
    }

   
}

