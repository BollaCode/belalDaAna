package javaapplication1;

import java.io.*;
import java.util.*;

public class WorkoutPlan {
    private String username;
    private String objective;
    private HashMap<String, String> workouts; // Key: Workout name, Value: Details

    // Constructor
    public WorkoutPlan(String username, String objective) {
        this.username = username;
        this.objective = objective;
        this.workouts = new HashMap<>();
        generateWorkouts(); // Auto-generate workouts based on the user's objective
    }

    // Auto-generate workouts based on the user's fitness objective
    private void generateWorkouts() {
        if (objective.equalsIgnoreCase("weight loss")) {
            workouts.put("Running", "30 minutes");
            workouts.put("Push-ups", "3 sets of 15");
            workouts.put("Plank", "2 minutes");
        } else if (objective.equalsIgnoreCase("strength")) {
            workouts.put("Deadlift", "3 sets of 12");
            workouts.put("Squats", "3 sets of 15");
            workouts.put("Bench Press", "3 sets of 10");
        } else { // Default workouts for general fitness
            workouts.put("Yoga", "20 minutes");
            workouts.put("Cycling", "15 minutes");
        }
    }

    // Display all workouts in the current plan
    public void displayWorkouts() {
        System.out.println("Current Workouts in Plan:");
        for (Map.Entry<String, String> entry : workouts.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // Add a new workout to the plan
    public void addWorkout(String name, String details) {
        if (workouts.containsKey(name)) {
            System.out.println("Workout already exists! Use editWorkout() to modify.");
        } else {
            workouts.put(name, details);
            System.out.println("Workout added successfully!");
        }
    }

    // Edit an existing workout
    public void editWorkout(String name, String newDetails) {
        if (workouts.containsKey(name)) {
            workouts.put(name, newDetails);
            System.out.println("Workout updated successfully!");
        } else {
            System.out.println("Workout not found! Use addWorkout() to add it first.");
        }
    }

    // Remove a workout from the plan
    public void removeWorkout(String name) {
        if (workouts.containsKey(name)) {
            workouts.remove(name);
            System.out.println("Workout removed successfully!");
        } else {
            System.out.println("Workout not found!");
        }
    }

    // Save the workout plan to a file via the Trainer class
    public void saveWorkoutPlanToFile(PrintWriter writer) {
        writer.println("Workout Plan for " + username + " (" + objective + "):");
        for (Map.Entry<String, String> entry : workouts.entrySet()) {
            writer.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
