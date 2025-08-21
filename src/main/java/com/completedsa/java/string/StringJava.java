package com.completedsa.java.string;

public class StringJava {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "Hello";
        for (int i = 0; i < 1000; i++) {
            s += " world";
        }

        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));

        // count number of words in a string
        String words = "One Two Three Four";
        int countWords = words.split("\\s").length;
        System.out.println(countWords);

        // reverse a string
        String originalStr = "Hello";
        String reversedStr = "";
        for (int i = 0; i < originalStr.length(); i++) {
            reversedStr = originalStr.charAt(i) + reversedStr;
        }
        System.out.println("Reversed string: "+ reversedStr);

        // convert a String to an Array
        String myStr = "Hello";
        char[] myArray = myStr.toCharArray();
        for (char i : myArray) {
            System.out.println(i);
        }
    }

}
