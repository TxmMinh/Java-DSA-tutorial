package com.completedsa.java.collections.queue.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeJava {
    public static void main(String[] args) {
        // stack -> [_, _, X]
        // queue <- [X, _, _]

        ArrayDeque<Integer> d = new ArrayDeque<>();
        // add()
        d.add(10);
        d.add(20);
        d.add(30);
        System.out.println("ArrayDeque: " + d); // ArrayDeque: [10, 20, 30]

        // size()
        System.out.println(d.size()); // 3

        ArrayDeque<Integer> d2 = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("ArrayDeque: " + d2); // ArrayDeque: [1, 2, 3, 4]

        // addAll(Collection<? extends E> c)
        // Adds all of the elements in the specified collection at the end of this deque
        d.addAll(d2);
        System.out.println("ArrayDeque: " + d); // ArrayDeque: [10, 20, 1, 2, 3, 4]

        Deque<String> d3 = new ArrayDeque<>();
        // add(E e)
        // inserts a particular element at the end of the deque.
        d3.add("The");

        // addFirst(E e)
        // inserts particular element at the start of the deque.
        d3.addFirst("To");

        // addLast(E e) == add(E e)
        // inserts a particular element at the end of the deque
        d3.addLast("Geeks");
        System.out.println(d3); // [To, The, Geeks]

        // offer(E e) method to insert
        // inserts element at the end of deque
        d3.offer("For");

        // offerFirst(E e)
        // inserts element at the front of deque
        d3.offerFirst("Welcome");

        // offerLast(E e)
        // inserts element at the end of the deque
        d3.offerLast("Geeks");
        System.out.println(d3); // [Welcome, To, The, Geeks, For, Geeks]

        // getFirst()
        // Displaying the First element
        System.out.println("The first element is: " + d3.getFirst()); // The first element is: Welcome

        // getLast()
        // Displaying the Last element
        System.out.println("The last element is: " + d3.getLast()); // The last element is: Geeks

        // pop()
        // Pops out an element for stack represented by deque
        System.out.println("Removed element using pop(): " + d3.pop()); // Removed element using pop(): Welcome
        System.out.println(d3); // [To, The, Geeks, For, Geeks]

        // poll()
        // Returns head element and also removes it
        System.out.println("Removed element using poll(): " + d3.poll()); // Removed element using poll(): To
        System.out.println(d3); // [The, Geeks, For, Geeks]

        // pollFirst() == poll()
        // Retrieves and removes the first element of this deque or returns null if this deque is empty
        System.out.println("Removed element using pollFirst(): " + d3.pollFirst()); // Removed element using pollFirst(): The
        System.out.println(d3); // [Geeks, For, Geeks]

        // pollLast()
        // Retrieves and removes the last element of this deque or returns null if this deque is empty.
        System.out.println("Removed element using pollFirst(): " + d3.pollLast()); // Removed element using pollFirst(): Geeks
        System.out.println(d3); // [Geeks, For]

        // peek()
        // Returns head element without removing it
        System.out.println(d3.peek()); // Geeks

        // peekFirst()
        // Retrieves, but does not remove, the first element of this deque or returns null if this deque is empty
        System.out.println(d3.peekFirst()); // Geeks

        // peekLast()
        // Retrieves, but does not remove, the last element of this deque or returns null if this deque is empty
        System.out.println(d3.peekLast()); // For

        // push()
        // pushes an element onto stack represented by deque
        d3.push("To");
        System.out.println(d3); // [To, Geeks, For]

        // element()
        // Returns element at the head of the deque without delete element from the deque
        System.out.println(d3.element()); // To

        // Iterate using Iterator interface from the front of the queue
        System.out.println("Iterating in ForwardOrder:");
        for (Iterator i = d.iterator(); i.hasNext();) {
            System.out.print(i.next() + " ");
        }
        System.out.println();

        // Iterate in reverse sequence in a queue
        System.out.println("Iterating in ReverseOrder:");
        for (Iterator i = d.descendingIterator(); i.hasNext();) {
            System.out.print(i.next() + " ");
        }
        System.out.println();

        // clear()
        // removes all deque elements
        d.clear();
        System.out.println(d); // []

        // contains()
        System.out.println(d.contains(2)); // false

        // isEmpty()
        System.out.println(d.isEmpty()); // true

        // remove()
        // returns head element and also removes it
        System.out.println(d2.remove()); // 1
        System.out.println(d2); // [2, 3, 4]

        // remove(Object o)
        // Removes a single instance of the specified element from this deque.
        d2.remove(3);
        System.out.println(d2); //[2, 4]

        // removeFirst()
        // Returns the first element and also removes it
        System.out.println(d2.removeFirst()); // 2
        System.out.println(d2); // [4]

        // removeLast()
        // Returns the last element and also removes it
        System.out.println(d2.removeLast()); // 4
    }
}
