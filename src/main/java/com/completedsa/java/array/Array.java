package com.completedsa.java.array;

import java.util.Arrays;
import java.util.Collections;

public class Array {
    public static void main(String[] args) {
        // Java Arrays
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        int[] myNum = {50, 20, 10, 40, 30};
        Arrays.sort(myNum);

        System.out.println(Arrays.toString(cars));
        System.out.println(cars.length);
        System.out.println(Arrays.toString(myNum));

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        for (String i : cars) {
            System.out.println(i);
        }

        // Java Multi-Dimensional Arrays
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        myNumbers[1][2] = 9;
        System.out.println(myNumbers[1][2]);
        System.out.println(Arrays.deepToString(myNumbers));

        for (int i = 0; i < myNumbers.length; ++i) {
            for (int j = 0; j < myNumbers[i].length; ++j) {
                System.out.println(myNumbers[i][j]);
            }
        }

        for (int[] row : myNumbers) {
            for (int i : row) {
                System.out.println(i);
            }
        }

        // Sort an Array
        String[] sortArray = {"Volvo", "BMW", "Tesla", "Ford", "Fiat", "Mazda", "Audi"};
        // ascending order
        Arrays.sort(sortArray);
        System.out.println(Arrays.toString(sortArray));
        // descending order
        Arrays.sort(sortArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(sortArray));

        // Declaring array literal
        int[] arr = new int[]{ 1,2,3,4,5,6,7 };
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7]

    }
}
