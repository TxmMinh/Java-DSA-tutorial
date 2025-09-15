package com.completedsa.dsa.stacksQueues.stacks;

public class StackUsingLinkedList {
    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        private Node head;
        private int size;

        public Stack() {
            this.head = null;
            this.size = 0;
        }

        public void push (char data) {
            Node newNode = new Node(data);

            if (head != null) {
                newNode.next = head;
            }

            head = newNode;
            size++;
        }

        public char pop() {
            if (this.isEmpty()) {
                System.out.println("Stack is empty");
                return ' ';
            }

            char popped = head.data;
            head = head.next;
            size--;
            return popped;
        }

        public char peek() {
            if (this.isEmpty()) {
                System.out.println("Stack is empty");
                return ' ';
            }

            return head.data;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void printStack() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.push('A');
        myStack.push('B');
        myStack.push('C');

        // Print initial stack
        System.out.print("Stack: ");
        myStack.printStack();

        System.out.println("Pop: " + myStack.pop());
        System.out.println("Peek: " + myStack.peek());
        System.out.println("isEmpty: " + myStack.isEmpty());
        System.out.println("Size: " + myStack.size());
    }
}
