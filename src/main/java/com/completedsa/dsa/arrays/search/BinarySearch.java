package com.completedsa.dsa.arrays.search;

import static com.completedsa.dsa.arrays.search.LinearSearch.printResult;

public class BinarySearch {
    /**
     * How it works:
     *  Check the value in the center of the array.
     *  If the target value is lower, search the left half of the array. If the target value is higher, search the right half.
     *  Continue step 1 and 2 for the new reduced part of the array until the target value is found or until the search area is empty.
     *  If the value is found, return the target value index. If the target value is not found, return -1.
     */
    public static int binarySearch(int[] arr, int value) {
        // Time Complexity: O(log(n))

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arrayBinary = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int value = 7;

        int index = binarySearch(arrayBinary, value);
        printResult(index);
    }
}
