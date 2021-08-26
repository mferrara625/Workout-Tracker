package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Workout strongLifts = new Workout();
        List<Exercise> currentWorkout = strongLifts.workoutAList;
        List<Exercise> nextWorkout = strongLifts.workoutBList;

        strongLifts.createWorkout();
        strongLifts.runWorkoutApp(scan, strongLifts, currentWorkout, nextWorkout);
    }
}