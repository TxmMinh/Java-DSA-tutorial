package com.completedsa.java.dataTypes;

/*
 * Widening Casting (automatically) - converting a smaller type to a larger type size
 *    byte -> short -> char -> int -> long -> float -> double
 * Narrowing Casting (manually) - converting a larger type to a smaller size type
 *    double -> float -> long -> int -> char -> short -> byte
 */
public class DataType {
    public static void main(String[] args) {
        // Java data types
        int myNum = 5;
        long myLong = 15000000000L;
        float myFloatNum = 5.99f;
        double myDoubleNum = 7.5;
        boolean myBool = true;
        char myChar = 'B';
        String myText = "Hello";

        System.out.println(myNum);
        System.out.println(myLong);
        System.out.println(myFloatNum);
        System.out.println(myDoubleNum);
        System.out.println(myBool);
        System.out.println(myChar);
        System.out.println(myText);

        // Java type casting
        int myInt = 9;
        double myDouble = myInt; // Automatic casting: int to double
        System.out.println(myInt);      // Outputs 9
        System.out.println(myDouble);   // Outputs 9.0

        double myDouble1 = 9.78d;
        int myInt1 = (int) myDouble1; // Manual casting: double to int
        System.out.println(myDouble1);   // Outputs 9.78
        System.out.println(myInt1);      // Outputs 9
    }
}