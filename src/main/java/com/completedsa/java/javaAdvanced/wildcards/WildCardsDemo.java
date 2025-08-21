package com.completedsa.java.javaAdvanced.wildcards;

import java.util.Arrays;
import java.util.List;

public class WildCardsDemo {
    /*
     * Upper Bounded Wildcards
     * ? extends T — “T or a subclass of T”
     * The list contains some unknown type that is a subtype of T.
     * Read: Safe → you can read elements as type T.
     * Write: Not safe → you can’t add (except null), because you don’t know the exact subtype.
     */
    public static double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number i : list) {
            sum += i.doubleValue();
        }

        return sum;
    }

    /*
     * Lower Bounded Wildcards
     * ? super T — “T or a superclass of T”
     * The list contains some unknown type that is a supertype of T.
     * Write: Safe → you can add T or any subclass of T.
     * Read: Not safe → you can only read as Object.
     */
    public static void printOnlyIntegerClassOrSuperClass(List<? super Integer> list) {
        System.out.println(list);
    }

    /*
     *  Unbounded Wildcard
     */
    private static void printList(List<?> list)
    {

        System.out.println(list);
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Total sum is:" + sum(list1));

        // Double list
        List<Double> list2 = Arrays.asList(4.1, 5.1, 6.1);
        System.out.println("Total sum is:" + sum(list2));

        // Lower Bounded Integer List
        List<Integer> list3 = Arrays.asList(4, 5, 6, 7);
        printOnlyIntegerClassOrSuperClass(list3);

        // Number list
        List<Number> list4 = Arrays.asList(4, 5, 6, 7);
        printOnlyIntegerClassOrSuperClass(list4);

        // Integer List
        List<Integer> list5 = Arrays.asList(1, 2, 3);
        printList(list5);

        // Double list
        List<Double> list6 = Arrays.asList(1.1, 2.2, 3.3);
        printList(list6);
    }
}
