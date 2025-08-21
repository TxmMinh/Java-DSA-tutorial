package com.completedsa.java.java8.functionalInterfaces;

public class FunctionalInterfaces {
    public static String getStr(String input, StringProcessor processor){
        return processor.process(input);
    }

    // Functional Programming
    public static void main(String[] args) {
        System.out.println(getStr("Hello", new StringProcessor() {
            @Override
            public String process(String input) {
                return input.toUpperCase();
            }
        }));

        System.out.println(getStr("Hey Loda!", new StringProcessor() {
            @Override
            public String process(String input) {
                return input.toLowerCase();
            }
        }));
    }
}
