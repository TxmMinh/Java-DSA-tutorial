package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

// Radix Sort is a non comparative algorithm that only works with non negative integers.
public class RadixSort {
    /**
     * How it works:
     * Start with the least significant digit (rightmost digit).
     * Sort the values based on the digit in focus by first putting the values in the correct bucket based on the digit in focus, and then put them back into array in the correct order.
     * Move to the next digit, and sort again, like in the step above, until there are no digits left.
     */
    public static void radixSort(int[] arr) {
        // Radix Sort depends both on the values that need to be sorted n, and the number of digits in the highest value k.
        // Average case: O(nlog(n))
        // Best case: O(n.k)

        int[][] radixArray = new int[10][arr.length];
        int[] counts = new int[10];
        int maxVal = arr[0];
        int exp = 1;

        for (int val : arr) {
            if (val > maxVal) {
                maxVal = val;
            }
        }


        while (maxVal / exp > 0) {
            for (int val : arr) {
                int radixIndex = (val / exp) % 10;
                radixArray[radixIndex][counts[radixIndex]] = val;
                counts[radixIndex]++;
            }

            int pos = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    arr[pos++] = radixArray[i][j];
                }
                counts[i] = 0;
            }

            exp *= 10;
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        printArray(arr);
    }
}
