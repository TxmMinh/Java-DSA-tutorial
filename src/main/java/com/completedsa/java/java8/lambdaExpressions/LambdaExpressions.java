package com.completedsa.java.java8.lambdaExpressions;

import com.completedsa.java.java8.functionalInterfaces.FunctionalInterfaces;


public class LambdaExpressions {
    public static void main(String[] args) {
        String upperCase = FunctionalInterfaces.getStr("Hello", input -> input.toUpperCase());
        System.out.println(upperCase);

        String lowerCase = FunctionalInterfaces.getStr("Hey Loda!", input -> input.toLowerCase());
        System.out.println(lowerCase);
    }
}
