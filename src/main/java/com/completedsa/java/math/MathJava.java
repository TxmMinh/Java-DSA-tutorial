package com.completedsa.java.math;

public class MathJava {
    public static void main(String[] args) {
        // a random number between 0.0 (inclusive), and 1.0 (exclusive):
        System.out.println(Math.random());

        // a random number between 0 and 100
        int randomNum = (int) (Math.random() * 101);
        System.out.println(randomNum);
    }
}
