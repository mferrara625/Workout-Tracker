package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Workout {

    List<Exercise> workoutAList = new ArrayList<>();
    List<Exercise> workoutBList = new ArrayList<>();
    List<String> workoutsCompletedList = new ArrayList<>();

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

    public void activeWorkout(Scanner scan, List<Exercise> currentWorkout) {
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

    public void completeWorkout(Workout workout, List<Exercise> currentWorkout) {
        for (Exercise exercise : currentWorkout) {
            workout.workoutsCompletedList.add(exercise.name + " " + exercise.weight + "  |  " + Arrays.toString(exercise.repsCompleted));
            System.out.println(exercise);
            exercise.repsCompleted = new int[exercise.sets];
            if (exercise.totalRepsCompleted >= (exercise.sets * exercise.repsExpected)) {
                exercise.weight += exercise.increment;
            }
        }
    }

    public void displayCompletedWorkouts(Workout workout) {
        System.out.println("Completed Workouts");
        System.out.println("__________________\n");
        List<String> workoutsCompletedList = workout.workoutsCompletedList;
        for (int i = 0; i < workoutsCompletedList.size(); i++) {
            String exercise = workoutsCompletedList.get(i);
            System.out.println(exercise);
            if((i + 1) % 3 == 0)
                System.out.println("\n");
        }
    }

    public void runWorkoutApp(Scanner scan, Workout workout, List<Exercise> currentWorkout, List<Exercise> nextWorkout) {
        List<Exercise> workoutListHolder;
        while(true) {
            workout.activeWorkout(scan, currentWorkout);
            workout.completeWorkout(workout, currentWorkout);
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
                workout.displayCompletedWorkouts(workout);
                break;
            }
        }
    }

}
