package com.completedsa.java.math;

public class MathMethod {
    public static void main(String[] args) {
        // abs(x)
        // Returns the absolute value of x
        System.out.println(Math.abs(-4.7));
        System.out.println(Math.abs(3));

        // ceil(x)
        // Returns the value of x rounded up to its nearest integer
        System.out.println(Math.ceil(0.40)); // 1.0
        System.out.println(Math.ceil(5.1)); // 6.0
        System.out.println(Math.ceil(-5.9)); // -5.0

        // floor(x)
        // Returns the value of x rounded down to its nearest integer
        System.out.println(Math.floor(0.60)); // 0.0
        System.out.println(Math.floor(-5.1)); // -6.0

        // max(x, y)
        // Returns the number with the highest value
        System.out.println(Math.max(2.0, 0.25));
        System.out.println(Math.max(31.2f, 18.0f));
        System.out.println(Math.max(14, 22));
        System.out.println(Math.max(96L, 2048L));

        // min(x, y)
        // Returns the number with the lowest value
        System.out.println(Math.min(2.0, 0.25));
        System.out.println(Math.min(31.2f, 18.0f));
        System.out.println(Math.min(14, 22));
        System.out.println(Math.min(96L, 2048L));

        // pow(x, y)
        // Returns the value of x to the power of y
        System.out.println(Math.pow(3, 4)); // 81.0
        System.out.println(Math.pow(9, 0.5)); // 3.0
        System.out.println(Math.pow(8, -1)); // 0.125

        // random()
        // Returns a random number between 0 and 1
        System.out.println(Math.random());

        // sqrt(x)
        // Returns the square root of x
        System.out.println(Math.sqrt(0)); // 0
        System.out.println(Math.sqrt(9)); // 3.0
        System.out.println(Math.sqrt(0.64)); // 0.8
        System.out.println(Math.sqrt(-9)); // NaN

        // toDegrees(x)
        // Converts an angle measured in radians to an approx. equivalent angle measured in degrees
        System.out.println(Math.toDegrees(1)); // 57.29577951308232
        System.out.println(Math.toDegrees(Math.PI)); // 180.0
        System.out.println(Math.toDegrees(Math.PI / 4)); // 45.0

        // toRadians(x)
        // Converts an angle measured in degrees to an approx. angle measured in radians
        System.out.println(Math.toRadians(180)); // 3.141592653589793
        System.out.println(Math.toRadians(45));
    }
}
