package com.completedsa.dsa.stacksQueues.stacks;

// LIFO: Last In First Out
public class StackUsingArray {
    public static class Stack {
        private char[] stack;
        private int top;
        private final int capacity;

        public Stack(int capacity) {
            this.stack = new char[capacity];
            this.capacity = capacity;
            this.top = -1;
        }

        // Adds a new element on the stack.
        public void push(char element) {
            if (top == capacity - 1) {
                System.out.println("Stack is full");
                return;
            }

            stack[++top] = element;
        }

        // Removes and returns the top element from the stack.
        public char pop() {
            if (this.isEmpty()) {
                System.out.println("Stack is empty");
                return ' ';
            }

            return stack[top--];
        }

        // Returns the top element on the stack.
        public char peek() {
            if (this.isEmpty()) {
                System.out.println("Stack is empty");
                return ' ';
            }

            return stack[top];
        }

        // Check if the stack is empty.
        public boolean isEmpty() {
            return top == -1;
        }

        // Finds the number of elements in the stack.
        public int size() {
            return top + 1;
        }

        public void printStack() {
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(10);
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
