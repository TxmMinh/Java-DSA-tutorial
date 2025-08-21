package com.completedsa.udemy.array;

import java.util.Scanner;

public class CalculateAverageTemp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many days' temperature?");
        int numberDays = input.nextInt();
        float sum = 0;
        float[] temps = new float[numberDays];
        for (int i = 0; i < numberDays; i++) {
            System.out.println("Temperature of day " + (i + 1) + " is: ");
            temps[i] = input.nextFloat();
            sum += temps[i];
        }

        float average = sum / numberDays;
        System.out.println("Average temperature day = " + average);
        int count = 0;
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] > average) {
                count++;
            }
        }
        System.out.println("Days above average temperature day is: " + count);
    }
}
