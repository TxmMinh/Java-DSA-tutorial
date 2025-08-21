package com.completedsa.dsa.arrays.sort;

// Bubble Sort is an algorithm that sorts an array from the lowest value to the highest value.
public class BubbleSort {
    /**
     * How it works:
     * Go through the array, one value at a time.
     * For each value, compare the value with the next value.
     * If the value is higher than the next one, swap the values so that the highest value comes last.
     * Go through the array as many times as there are values in the array.
     */
    public static void bubbleSort(int[] my_arr) {
        // Worst case: O(n²)
        // Best case (already sorted): O(n)

        int n = my_arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (my_arr[j] > my_arr[j + 1]) {
                    int temp = my_arr[j];
                    my_arr[j] = my_arr[j + 1];
                    my_arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        System.out.println("Sorted array: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 2, 6, 4};
        bubbleSort(arr);
        printArray(arr);
    }
}
