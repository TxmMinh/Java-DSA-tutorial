package com.completedsa.udemy.array;

public class TwoDimensionArray {
    int[][] arr;

    public TwoDimensionArray(int numberOfRows, int numberOfColumns) {
        this.arr = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[0].length; column++) {
                arr[row][column] = Integer.MIN_VALUE;
            }
        }
    }

    public int[][] getArray() {
        return arr;
    }

    // Insert value in array
    public void insertValueInTheArray(int row, int col, int value) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("The value is successfully inserted");
            } else {
                System.out.println("This cell is already occupied");
            }
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid index for 2D array");
        }
    }

    // Accessing cell value from given array
    public void accessCell(int row, int col) {
        System.out.println("Accessing Row#" + row + ", Col#" + col);
        try {
            System.out.println("Cell value isL " + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid index for 2D array");
        }
    }

    // Traverse 2D array
    public void traverse2DArray() {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Searching a single value from the Array
    public void searchingValue(int value) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == value) {
                    System.out.println("Value is found at row: " + row + ", col: " + col);
                    return;
                }
            }
        }
        System.out.println("Value is not found");
    }

    // Deleting a value from array
    public void deleteValueFromArray(int row, int col) {
        try {
            arr[row][col] = Integer.MIN_VALUE;
            System.out.println("Successfully deleted: " + arr[row][col]);
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("This index is not valid for array");
        }
    }
}
