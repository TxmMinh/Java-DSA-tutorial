package com.completedsa.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Max heaps have the largest value at the root node. The largest value has the highest priority to be removed.
 */
public class BinaryMaxHeap {
    private List<Integer> heap;

    public BinaryMaxHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int lastParent() {
        return heap.size() / 2 - 1;
    }

    private void bubbleUp(int index) {
        while (index > 0 && heap.get(index) > heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown(int index) {
        int l = leftChild(index);
        int r = rightChild(index);

        int max = index;

        if (l < heap.size() && heap.get(max) < heap.get(l)) {
            max = l;
        }

        if (r < heap.size() && heap.get(max) < heap.get(r)) {
            max = r;
        }

        if (max != index) {
            swap(max, index);
            bubbleDown(max);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void push(int val) {
        heap.add(val);
        bubbleUp(heap.size() - 1);
    }

    public int pop() {
        if (heap.isEmpty()) {
            return -1;
        }

        int highPriority = heap.getFirst();
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            bubbleDown(0);
        }

        return highPriority;
    }

    public int top() {
        if (heap.isEmpty()) {
            return -1;
        }

        return heap.get(0);
    }

    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>(nums);
        for (int i = lastParent(); i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public void printHeap() {
        for (Integer integer : heap) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        int[] values = {3, 10, 5, 6, 15, 1};
        for (int v : values) {
            heap.push(v);
            System.out.print("After push " + v + ": ");
            heap.printHeap();
        }

        System.out.println("Current max (top): " + heap.top());

        while (heap.top() != -1) {
            int popped = heap.pop();
            System.out.println("Popped max: " + popped);
            System.out.print("Heap after pop: ");
            heap.printHeap();
        }

        List<Integer> nums = Arrays.asList(4, 7, 3, 9, 1, 12, 5);
        System.out.println("Original list: " + nums);
        heap.heapify(nums);
        System.out.print("After heapify: ");
        heap.printHeap();
    }
}
