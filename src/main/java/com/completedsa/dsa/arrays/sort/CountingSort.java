package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

// The Counting Sort algorithm sorts an array by counting the number of times each value occurs.
public class CountingSort {
    /**
     * How it works:
     * Create a new array for counting how many there are of the different values.
     * Go through the array that needs to be sorted.
     * For each value, count it by increasing the counting array at the corresponding index.
     * After counting the values, go through the counting array to create the sorted array.
     * For each count in the counting array, create the correct number of elements, with values that correspond to the counting array index.
     */
    public static void countingSort(int[] arr) {
        // How fast the algorithm runs depends on both the range of possible values k and the number of values n
        // Time Complexity: O(n + k)

        int max_val = arr[0];
        for(int num : arr) {
            if(num > max_val) {
                max_val = num;
            }
        }

        int[] count = new int[max_val + 1];

        for(int num : arr) {
            count[num]++;
        }

        int index = 0;
        for(int i = 0; i <= max_val; i++) {
            while(count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3};
        countingSort(arr);
        printArray(arr);
    }
}
