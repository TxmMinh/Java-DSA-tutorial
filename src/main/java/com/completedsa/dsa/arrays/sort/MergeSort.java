package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

public class MergeSort {
    /**
     * How it works:
     * Divide the unsorted array into two sub-arrays, half the size of the original.
     * Continue to divide the sub-arrays as long as the current piece of the array has more than one element.
     * Merge two sub-arrays together by always putting the lowest value first.
     * Keep merging until there are no sub-arrays left.
     */
    public static void mergeSort(int[] arr) {
        // Time Complexity: O(nlogn)
        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] arrLeft = new int[mid];
        int[] arrRight = new int[arr.length - mid];
        int i = 0, j = 0;

        for (; i < arr.length; i++) {
            if (i < mid) {
                arrLeft[i] = arr[i];
            } else {
                arrRight[j] = arr[i];
                j++;
            }
        }

        mergeSort(arrLeft);
        mergeSort(arrRight);
        merge(arrLeft, arrRight, arr);
    }

    public static void merge(int[] arrLeft, int[] arrRight, int[] arr) {
        int lengthLeft = arrLeft.length;
        int lengthRight = arrRight.length;
        int i = 0, l = 0, r = 0;

        while (l < lengthLeft && r < lengthRight) {
            if (arrLeft[l] < arrRight[r]) {
                arr[i] = arrLeft[l];
                i++;
                l++;
            } else {
                arr[i] = arrRight[r];
                i++;
                r++;
            }
        }

        while (l < lengthLeft) {
            arr[i] = arrLeft[l];
            i++;
            l++;
        }

        while (r < lengthRight) {
            arr[i] = arrRight[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 2, 6, 4};
        mergeSort(arr);
        printArray(arr);
    }
}
