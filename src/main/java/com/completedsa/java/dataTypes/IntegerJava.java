package com.completedsa.java.dataTypes;

public class IntegerJava {
    public static void main(String[] args) {
        // toHexString(int num)
        // returns a string representing the int value in hex characters-[0-9][a-f]
        System.out.println("Hex string is " + Integer.toHexString(11)); // Hex string is b

        // toOctalString(int num)
        // returns a string representing the int value in octal characters-[0-7]
        System.out.println("Octal Number = " + Integer.toOctalString(11)); // Octal Number = 13

        // toBinaryString(int num)
        // returns a string representing the int value in hex characters-[0/1]
        System.out.println("Binary is " + Integer.toBinaryString(11)); // Binary is 1011
        
        // parseInt(String s)
        System.out.println(Integer.parseInt("12345")); // 12345

        // valueOf(String s)
        System.out.println(Integer.valueOf("217")); // 217
    }
}
