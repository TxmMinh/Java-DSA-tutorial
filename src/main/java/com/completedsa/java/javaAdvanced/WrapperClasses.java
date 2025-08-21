package com.completedsa.java.javaAdvanced;

/*
 * Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
 */
public class WrapperClasses {
    public static void main(String[] args) {
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);

        System.out.println(myInt.intValue());
        System.out.println(myDouble.doubleValue());
        System.out.println(myChar.charValue());

        Integer myInteger = 100;
        String myString = myInteger.toString();
        System.out.println(myString.length());

        int myint = 2000;
        String myString2 = Integer.toString(myint);
        System.out.println(myString2.length());
    }
}
