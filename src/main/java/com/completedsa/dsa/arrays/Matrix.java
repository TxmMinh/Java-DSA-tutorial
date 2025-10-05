package com.completedsa.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Matrix Data Structure is a two-dimensional array arranged in rows and columns.
 */
public class Matrix {
    // Search in a Matrix or 2D Array
    static boolean matrixSearch(int[][] matrix, int x) {
        // Time Complexity : O(n * m), where n and m are the rows and column of matrix.
        int n = matrix.length;
        int m = matrix[0].length;

        // Compare each element one by one
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == x) {
                    return true;
                }
            }
        }

        return false;
    }

    static void add(int[][] a, int[][] b, int[][] res) {
        // Time Complexity: O(mn)
        int n = a.length;
        int m = a[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
    }

    static void sortMatrix(int[][] matrix) {
        // Time Complexity: O(mnlogmn)
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x.add(matrix[i][j]);
            }
        }

        Collections.sort(x);
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = x.get(k++);
            }
        }

    }

    public static void main(String[] args)
    {
        int[][] mat = { { 1, 5, 9, 11 },
                { 14, 20, 21, 26 },
                { 30, 34, 43, 50 } };
        if (matrixSearch(mat, 14)) {
            System.out.println("Found");
        }
        else {
            System.out.println("Not Found");
        }

        int[][] A = { {1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4} };
        int[][] B = { {1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4} };
        int[][] C = new int[4][3];
        add(A, B, C);

        System.out.println("Result matrix is:");
        for (int[] row : C) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        int[][] D = { {1, 5, 8}, {2, 6, 1}, {8, 9, 3}, {4, 7, 6} };
        sortMatrix(D);
        System.out.println("Result sorted matrix is:");
        for (int[] row : D) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
