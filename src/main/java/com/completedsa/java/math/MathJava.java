package com.completedsa.java.math;

public class MathJava {
    public static void main(String[] args) {
        // a random number between 0.0 (inclusive), and 1.0 (exclusive):
        System.out.println(Math.random());

        // a random number between 0 and 100
        int randomNum = (int) (Math.random() * 101);
        System.out.println(randomNum);

        // as 10 less than 20, Output will be a value less than zero
        System.out.println(Integer.compare(10, 20)); // -1
        // as 30 equals 30, Output will be zero
        System.out.println(Integer.compare(30, 30)); // 0
        // as 15 is greater than 8, Output will be a value greater than zero
        System.out.println(Integer.compare(15, 8)); // 1
    }
}
