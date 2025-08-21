package com.completedsa.udemy.array;

public class Exercise {
    /**
     * Given an array, write a function to get first, second best scores from the array and return it in new array.
     * Array may contain duplicates.
     * Example
     *   myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
     *   firstSecond(myArray) // {90, 87}
     */
    public static int[] findTopTwoScores(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for (int score : arr) {
            if (score > first) {
                second = first;
                first = score;
            } else if (score > second && score < first) {
                second = score;
            }
        }

        return new int[] {first, second};
    }

    public static void traversalArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] = " + arr[i] + "\n");
        }
    }

    public static void main(String[] args) {
        int[] myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
        int[] arr = findTopTwoScores(myArray);
        traversalArray(arr);
    }
}