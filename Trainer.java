package javaapplication1;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Trainer extends PublicUser {

    String username;
    String password;

    private HashMap<String,WorkoutPlan> userWorkoutPlans;

    public Trainer(String username, String password) {
        
                    super(username,password);

        this.userWorkoutPlans = new HashMap<>();
    }
    
    
    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Trainer Menu:");
            System.out.println("1. Create Workout Plan");
            System.out.println("2. View Workout Plan");
            System.out.println("3. Edit Workout");
            System.out.println("4. Add Workout");
            System.out.println("5. Remove Workout");
            System.out.println("6. Provide Feedback");
            System.out.println("7. Track Progress");
            System.out.println("8. Save All Workout Plans");
            System.out.println("9. Create Progress Report");
            System.out.println("10. Log out");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createWorkoutPlan(scanner);
                    break;
                case 2:
                    viewWorkoutPlan(scanner);
                    break;
                case 3:
                    editWorkout(scanner);
                    break;
                case 4:
                    addWorkout(scanner);
                    break;
                case 5:
                    removeWorkout(scanner);
                    break;
                case 6:
                    provideFeedback(scanner);
                    break;
                case 7:
                    trackProgress(scanner);
                    break;
                case 8:
                    saveWorkoutPlansForTrainer();
                    break;
                case 9:
                    createProgressReport(scanner);
                    break;
                case 10:
                    System.out.println("Logging out.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method implementations (with Scanner inputs)
    public void createWorkoutPlan(Scanner scanner) {
        System.out.print("Enter username for the workout plan: ");
        String username = scanner.nextLine();
        System.out.print("Enter the objective of the workout plan: ");
        String objective = scanner.nextLine();
        if (userWorkoutPlans.containsKey(username)) {
            System.out.println("A workout plan for " + username + " already exists.");
        } else {
            WorkoutPlan workoutPlan = new WorkoutPlan(username, objective);
            userWorkoutPlans.put(username, workoutPlan);
            System.out.println("Workout plan created for " + username + " with objective: " + objective);
        }
    }

    public void viewWorkoutPlan(Scanner scanner) {
        System.out.print("Enter username to view the workout plan: ");
        String username = scanner.nextLine();
        WorkoutPlan workoutPlan = userWorkoutPlans.get(username);
        if (workoutPlan != null) {
            System.out.println("Workout Plan for " + username + ":");
            workoutPlan.displayWorkouts();
        } else {
            System.out.println("No workout plan found for " + username + ".");
        }
    }

    public void editWorkout(Scanner scanner) {
        System.out.print("Enter username for the workout plan: ");
        String username = scanner.nextLine();
        System.out.print("Enter workout name to edit: ");
        String workoutName = scanner.nextLine();
        System.out.print("Enter new details for the workout: ");
        String newDetails = scanner.nextLine();
        WorkoutPlan workoutPlan = userWorkoutPlans.get(username);
        if (workoutPlan != null) {
            workoutPlan.editWorkout(workoutName, newDetails);
            updateWorkoutPlanFile(); // Update the file when the workout plan changes
        } else {
            System.out.println("No workout plan found for " + username + ".");
        }
    }

    public void addWorkout(Scanner scanner) {
        System.out.print("Enter username for the workout plan: ");
        String username = scanner.nextLine();
        System.out.print("Enter new workout name: ");
        String workoutName = scanner.nextLine();
        System.out.print("Enter workout details: ");
        String details = scanner.nextLine();
        WorkoutPlan workoutPlan = userWorkoutPlans.get(username);
        if (workoutPlan != null) {
            workoutPlan.addWorkout(workoutName, details);
            updateWorkoutPlanFile(); // Update the file when the workout plan changes
        } else {
            System.out.println("No workout plan found for " + username + ".");
        }
    }

    public void removeWorkout(Scanner scanner) {
        System.out.print("Enter username for the workout plan: ");
        String username = scanner.nextLine();
        System.out.print("Enter workout name to remove: ");
        String workoutName = scanner.nextLine();
        WorkoutPlan workoutPlan = userWorkoutPlans.get(username);
        if (workoutPlan != null) {
            workoutPlan.removeWorkout(workoutName);
            updateWorkoutPlanFile(); // Update the file when the workout plan changes
        } else {
            System.out.println("No workout plan found for " + username + ".");
        }
    }

    public void provideFeedback(Scanner scanner) {
        System.out.print("Enter username for feedback: ");
        String username = scanner.nextLine();
        System.out.print("Enter your feedback for " + username + ": ");
        String feedback = scanner.nextLine();
        System.out.println("Feedback for " + username + ": " + feedback);
    }

    public void trackProgress(Scanner scanner) {
        System.out.print("Enter username to track progress: ");
        String username = scanner.nextLine();
        System.out.print("Enter progress details for " + username + ": ");
        String progressDetails = scanner.nextLine();
        System.out.println("Progress for " + username + ": " + progressDetails);
    }

    public void saveWorkoutPlansForTrainer() {
        try (PrintWriter writer = new PrintWriter(new File(username + "_WorkoutPlans.txt"))) {
            writer.println("Workout Plans for Trainer: " + username);
            for (String user : userWorkoutPlans.keySet()) {
                writer.println("\nWorkout Plan for " + user + ":");
                userWorkoutPlans.get(user).saveWorkoutPlanToFile(writer);
            }
            System.out.println("All workout plans have been saved to " + username + "_WorkoutPlans.txt");
        } catch (IOException e) {
            System.out.println("Error saving workout plans: " + e.getMessage());
        }
    }

    private void updateWorkoutPlanFile() {
        try (PrintWriter writer = new PrintWriter(new File(username + "_WorkoutPlans.txt"))) {
            writer.println("Workout Plans for Trainer: " + username);
            for (String user : userWorkoutPlans.keySet()) {
                writer.println("\nWorkout Plan for " + user + ":");
                userWorkoutPlans.get(user).saveWorkoutPlanToFile(writer);
            }
            System.out.println("Workout plans updated in the file.");
        } catch (IOException e) {
            System.out.println("Error updating workout plans: " + e.getMessage());
        }
    }
    
    public void createProgressReport(Scanner scanner) {
        System.out.print("Enter username for the progress report: ");
        String username = scanner.nextLine();
        System.out.print("Enter report details for " + username + ": ");
        String reportDetails = scanner.nextLine();
        String fileName = username + "_ProgressReports.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(reportDetails);
            System.out.println("Progress report created for " + username);
        } catch (IOException e) {
            System.out.println("Error creating progress report: " + e.getMessage());
        }
    }

}