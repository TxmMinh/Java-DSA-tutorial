package com.completedsa.java.java8.methodReference;

import static com.completedsa.java.java8.functionalInterfaces.FunctionalInterfaces.getStr;

/*
 * Có các cách để gọi Method reference như sau:
 * [Tên Class]::[Tên method]
 * [Tên Class]::new
 */
public class MethodReference {
    public static void main(String[] args) {
        String upperCase = getStr("Hello", String::toUpperCase);
        System.out.println(upperCase);

        String lowerCase = getStr("Hey!", String::toLowerCase);
        System.out.println(lowerCase);

        System.out.println(getStr("Hello!", String::new));
    }
}
