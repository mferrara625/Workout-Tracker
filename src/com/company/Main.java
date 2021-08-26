package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        Workout workoutA = new Workout();
        List<Exercise> currentWorkout = workoutA.workoutAList;
        List<Exercise> nextWorkout = workoutA.workoutBList;
        List<Exercise> workoutListHolder;
        Exercise squat = new Exercise("Squat", 5, 5, 95, 10);
        workoutA.workoutAList.add(squat);
        workoutA.workoutAList.add(new Exercise("Bench Press", 5, 5, 45, 5));
        workoutA.workoutAList.add(new Exercise("Barbell Row", 5, 5, 65, 5));
        workoutA.workoutBList.add(squat);
        workoutA.workoutBList.add(new Exercise("Overhead Press", 5, 5, 45, 5));
        workoutA.workoutBList.add(new Exercise("Deadlift", 5, 1, 95, 10));

        while(true) {
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
            for (Exercise exercise : currentWorkout) {
                workoutA.workoutsCompletedList.add(exercise);
                System.out.println(exercise);
                exercise.repsCompleted = new int[exercise.sets];
                if (exercise.totalRepsCompleted >= 25) {
                    exercise.weight += exercise.increment;
                }
            }
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
                System.out.println("Completed Workouts");
                System.out.println("__________________\n");
                List<Exercise> workoutsCompletedList = workoutA.workoutsCompletedList;
                for (int i = 0; i < workoutsCompletedList.size(); i++) {
                    Exercise exercise = workoutsCompletedList.get(i);
                    System.out.println(exercise);
                    if((i + 1) % 3 == 0)
                        System.out.println("\n");
                }
                break;

            }

        }
    }
}
