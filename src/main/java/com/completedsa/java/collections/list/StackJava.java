package com.completedsa.java.collections.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * The Stack class in Java is inherits from Vector in Java. It is a thread-safe class.
 * It is recommended to use ArrayDeque for stack implementation as it is more efficient in a single-threaded environment.
 */
public class StackJava {
    public static void main(String[] args)
    {
        // Default initialization of Stack
        Stack stack1 = new Stack();

        // Initialization of Stack using Generics
        Stack<String> stack2 = new Stack<String>();

        // pushing the elements
        // push(E item)
        stack1.push(4);
        stack1.push(true);
        stack1.push("All");
        stack1.push('c');

        stack2.push("Geeks");
        stack2.push("For");
        stack2.push("Geeks");

        // Printing the Stack Elements
        System.out.println(stack1); // [4, All, true]
        System.out.println(stack2); // [Geeks, For, Geeks]

        // pop()
        // Removing elements at the head
        System.out.println(stack1.pop()); // c
        System.out.println(stack1); // [4, true, All]

        // peek()
        // Fetching the element at the head of the Stack
        System.out.println(stack1.peek()); // All
        System.out.println(stack1); // [4, true, All]

        // empty()
        System.out.println("Is stack empty? " + stack1.empty()); // Is stack empty? false

        // search(Object o)
        System.out.println("Does the stack contains '4'? " + stack1.search("4"));

        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        deque.push(1);
        deque.push(2);

        List<Integer> list1 = stack.stream().toList();
        System.out.println("Using Stack: ");
        for(int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " " );
        }
        // Using Stack:
        // 1 2
        System.out.println();

        List<Integer> list2 = deque.stream().toList();
        System.out.println("Using Deque: ");
        for(int i = 0; i < list2.size(); i++){
            System.out.print(list2.get(i) + " " );
        }
        // Using Deque:
        // 2 1
        System.out.println();
    }
}
