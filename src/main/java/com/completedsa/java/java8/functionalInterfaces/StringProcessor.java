package com.completedsa.java.java8.functionalInterfaces;

/*
 * A functional interface in Java is an interface that contains only one abstract method.
 * Functional interfaces can have multiple default or static methods, but only one abstract method.
 */
@FunctionalInterface
public interface StringProcessor{
    String process(String input);

    // non-abstract method
    default void printf(Object t){
        System.out.println(t);
    }

    static String concat(String a, String b){
        return a + b;
    }

    private void doSomething() {
        System.out.println("Same code here");
    }

    private static void doSomethingTwo() {
        System.out.println("Same code here");
    }
}
