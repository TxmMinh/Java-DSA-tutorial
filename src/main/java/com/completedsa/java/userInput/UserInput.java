package com.completedsa.java.userInput;

import java.util.Scanner;

/*
 * Input Types
 *      Method	        Description
 *      nextBoolean()	Reads a boolean value from the user
 *      nextByte()	    Reads a byte value from the user
 *      nextDouble()	Reads a double value from the user
 *      nextFloat()	    Reads a float value from the user
 *      nextInt()	    Reads a int value from the user
 *      nextLine()	    Reads a String value from the user
 *      nextLong()	    Reads a long value from the user
 *      nextShort()	    Reads a short value from the user
 */
public class UserInput {
    public static void main(String[] args) {
        int x, y, sum;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String name = scanner.nextLine();
        System.out.println("Username is: " + name);

        System.out.println("Type a number:");
        x = scanner.nextInt();
        System.out.println("Type another number:");
        y = scanner.nextInt();
        sum = x + y;
        System.out.println("Sum is: " + sum);
    }
}
