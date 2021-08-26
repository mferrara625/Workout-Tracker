package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Workout {

    private List<Exercise> workoutAList = new ArrayList<>();
    private List<Exercise> workoutBList = new ArrayList<>();
    private List<String> workoutsCompletedList = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private List<Exercise> currentWorkout = workoutAList;
    private List<Exercise> nextWorkout = workoutBList;

    public Workout(){
    }

    public void createWorkout() {
        Exercise squat = new Exercise("Squat         ", 5, 5, 95, 10);
        workoutAList.add(squat);
        workoutAList.add(new Exercise("Bench Press   ", 5, 5, 45, 5));
        workoutAList.add(new Exercise("Barbell Row   ", 5, 5, 65, 5));
        workoutBList.add(squat);
        workoutBList.add(new Exercise("Overhead Press", 5, 5, 45, 5));
        workoutBList.add(new Exercise("Deadlift      ", 5, 1, 95, 10));
    }

    public void activeWorkout() {
        for (Exercise exercise : currentWorkout) {
            int i = 0;
            exercise.repsCompleted = new int[exercise.sets];
            while (i < exercise.sets) {
                System.out.println(exercise);
                System.out.println("Enter Reps Completed: ");
                int input = scan.nextInt();
                scan.nextLine();
                exercise.repsCompleted[i] = input;
                exercise.totalRepsCompleted += input;
                i++;
            }
            System.out.println(exercise + "\n");
        }
    }

    public void completeWorkout() {
        for (Exercise exercise : currentWorkout) {
            workoutsCompletedList.add(exercise.name + " " + exercise.weight + "  |  " + Arrays.toString(exercise.repsCompleted));
            System.out.println(exercise);
            exercise.repsCompleted = new int[exercise.sets];
            if (exercise.totalRepsCompleted >= (exercise.sets * exercise.repsExpected)) {
                exercise.weight += exercise.increment;
            }
        }
    }

    public void displayCompletedWorkouts() {
        System.out.println("Completed Workouts");
        System.out.println("__________________\n");
        for (int i = 0; i < workoutsCompletedList.size(); i++) {
            String exercise = workoutsCompletedList.get(i);
            System.out.println(exercise);
            if((i + 1) % 3 == 0)
                System.out.println("\n");
        }
    }

    public void runWorkoutApp() {
        List<Exercise> workoutListHolder;
        while(true) {
            activeWorkout();
            completeWorkout();
            System.out.println("\nNext Workout: ");
            for (Exercise exercise : nextWorkout) {
                System.out.println(exercise.name + " " + exercise.weight + " lbs");
            }
            workoutListHolder = currentWorkout;
            currentWorkout = nextWorkout;
            nextWorkout = workoutListHolder;

            System.out.println("Continue to next workout?  Y/N ");
            String input2 = scan.nextLine();
            if(input2.equalsIgnoreCase("N")){
                displayCompletedWorkouts();
                break;
            }
        }
    }

}
