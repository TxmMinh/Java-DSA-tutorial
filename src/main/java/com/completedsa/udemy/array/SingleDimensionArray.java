package com.completedsa.udemy.array;

public class SingleDimensionArray {
    int[] array;

    public int[] getArray() {
        return array;
    }

    // create an array
    public SingleDimensionArray(int sizeOfArray) {
        array = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = Integer.MIN_VALUE;
        }
    }

    // insert element into array
    public void insert(int location, int value) {
        try {
            if (array[location] == Integer.MIN_VALUE) {
                array[location] = value;
                System.out.println("Successfully insert!");
            } else {
                System.out.println("This cell is already occupied");
            }
        } catch (Exception ex) {
            System.out.println("Invalid index to access array");
        }
    }

    // Array Traversal
    public void traverseArray() {
        try {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.print("\n");
        } catch (Exception ex) {
            System.out.println("Array no longer exist!");
        }
    }

    // Search element in array
    public void searchInArray(int valueToSearch) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToSearch) {
                System.out.println("Value is found at the index of " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found");
    }

    // delete array element
    public void deleteValueByIndex(int index) {
        try {
            array[index] = Integer.MIN_VALUE;
            System.out.println("The value has been deleted successfully!");
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("The value that is provided is not in the range of array");
        }
    }
}
