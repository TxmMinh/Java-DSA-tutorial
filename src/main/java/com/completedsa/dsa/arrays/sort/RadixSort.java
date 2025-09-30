package com.completedsa.dsa.arrays.sort;

import java.util.Arrays;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

// Radix Sort is a non comparative algorithm that only works with non negative integers.
public class RadixSort {
    /**
     * How it works:
     *  Start with the least significant digit (rightmost digit).
     *  Sort the values based on the digit in focus by first putting the values in the correct bucket based on the digit in focus, and then put them back into array in the correct order.
     *  Move to the next digit, and sort again, like in the step above, until there are no digits left.
     */
    public static void radixSort(int[] arr) {
        // Works only for non-negative integers
        // Time Complexity: O(d * (n + b))
        // where d = number of digits, n = array length, b = base (here base = 10)

        // Find the maximum number to know number of digits
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // Do counting sort for every digit. Note that instead of passing digit number, exp is passed. exp is 10^i where i is current digit number
        for (int exp = 1; maxVal / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // A function to do counting sort
    private static void countSort(int[] arr, int exp) {
        int n = arr.length;

        int[] output = new int[n];
        int i;
        int[] count = new int[10]; // base 10

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Compute prefix sum
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        printArray(arr);
    }
}
