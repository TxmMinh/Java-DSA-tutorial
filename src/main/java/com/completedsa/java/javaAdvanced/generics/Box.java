package com.completedsa.java.javaAdvanced.generics;

/*
 * Generic Class
 * A class that works with different data types using generics
 */
public class Box<T> {
    T value; // T is a placeholder for any data type

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
