package com.completedsa.dsa.trees.binaryTree.depthFirstSearch;

// In case we read from the Binary Tree a lot more than we modify it, an Array implementation of a Binary Tree can make sense as it needs less memory.

import java.util.ArrayList;
import java.util.List;

/**
 * This Binary Tree can be stored in an Array starting with the root node R on index 0.
 * The rest of the tree can be built by taking a node stored on index i,
 * and storing its left child node on index 2.i+1, and its right child node on index 2.i+2
 */
public class BinaryTreeUsingArray {
    static Character[] binaryTreeArray = {'R', 'A', 'B', 'C', 'D', 'E', 'F', null, null, null, null, null, null, 'G'};

    public static int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    public static int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    public static Character getData(Character[] binaryTreeArray, int index) {
        if (index >= 0 && index < binaryTreeArray.length) {
            return binaryTreeArray[index];
        }

        return null;
    }

    public static List<Character> preOrder(int index) {
        if (index >= binaryTreeArray.length || binaryTreeArray[index] == null) {
            return new ArrayList<>();
        }

        List<Character> result = new ArrayList<>();
        result.add(binaryTreeArray[index]);
        result.addAll(preOrder(leftChildIndex(index)));
        result.addAll(preOrder(rightChildIndex(index)));
        return result;
    }

    public static List<Character> inOrder(int index) {
        if (index >= binaryTreeArray.length || binaryTreeArray[index] == null) {
            return new ArrayList<>();
        }

        List<Character> result = new ArrayList<>();
        result.addAll(inOrder(leftChildIndex(index)));
        result.add(binaryTreeArray[index]);
        result.addAll(inOrder(rightChildIndex(index)));
        return result;
    }

    public static List<Character> postOrder(int index) {
        if (index >= binaryTreeArray.length || binaryTreeArray[index] == null) {
            return new ArrayList<>();
        }

        List<Character> result = new ArrayList<>();
        result.addAll(postOrder(leftChildIndex(index)));
        result.addAll(postOrder(rightChildIndex(index)));
        result.add(binaryTreeArray[index]);
        return result;
    }

    public static void main(String[] args) {
        //        R
        //       / \
        //      A   B
        //     / \ / \
        //    C  D E  F
        //            /
        //            G
        int rightChild = rightChildIndex(0);
        int leftChildOfRightChild = leftChildIndex(rightChild);
        Character data = getData(binaryTreeArray, leftChildOfRightChild);

        System.out.println("root.right.left.data: " + data);

        // Traversal
        System.out.println("Pre-order Traversal: " + preOrder(0));
        System.out.println("In-order Traversal: " + inOrder(0));
        System.out.println("Post-order Traversal: " + postOrder(0));
    }
}
