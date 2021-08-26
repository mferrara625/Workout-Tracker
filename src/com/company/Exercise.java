package com.company;

import java.util.Arrays;

public class Exercise {

    public String name;
    public int repsExpected;
    public int sets;
    int[] repsCompleted;
    int totalRepsCompleted;
    public int weight;
    public int increment;

    public Exercise(String name, int repsExpected, int sets, int weight, int increment){
        this.name = name;
        this.repsExpected = repsExpected;
        this.sets = sets;
        this.weight = weight;
        this.increment = increment;
        repsCompleted = new int[]{0, 0, 0, 0, 0};
    }

    public String toString(){
        return name + " " + weight + " lbs  |  " + Arrays.toString(repsCompleted);
    }
}
