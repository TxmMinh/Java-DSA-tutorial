package com.completedsa.java.java8.comparable;

public class Car implements Comparable {
    public String brand;
    public String model;
    public int year;

    public Car(String b, String m, int y) {
        brand = b;
        model = m;
        year = y;
    }

    // Decide how this object compares to other objects
    public int compareTo(Object obj) {
        Car other = (Car)obj;
//        if (year < other.year) return -1; // This object is smaller than the other one
//        if (year > other.year) return 1;  // This object is larger than the other one
//        return 0; // Both objects are the same

        return year - other.year;
        // return other.year - year; // sort things in reverse
    }
}

