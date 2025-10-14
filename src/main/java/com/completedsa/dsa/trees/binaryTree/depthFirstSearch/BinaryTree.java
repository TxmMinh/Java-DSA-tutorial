package com.completedsa.dsa.trees.binaryTree.depthFirstSearch;

/**
 * A Binary Tree is a type of tree data structure where each node can have a maximum of two child nodes, a left child node and a right child node.
 * The tree height is the maximum number of edges from the root node to a leaf node.
 * The size of a tree is the number of nodes in it (n).
 */
public class BinaryTree {
    public static class TreeNode {
        char data;
        TreeNode left;
        TreeNode right;

        public TreeNode(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode createNewNode(char data) {
        return new TreeNode(data);
    }

    /**
     * Pre-order Traversal is a type of Depth First Search.
     * Pre-order Traversal is done by visiting the root node first, then recursively do a pre-order traversal of the left subtree,
     * followed by a recursive pre-order traversal of the right subtree.
     * This traversal is "pre" order because the node is visited "before" the recursive pre-order traversal of the left and right subtrees.
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + ", ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * In-order Traversal is a type of Depth First Search.
     * In-order Traversal does a recursive In-order Traversal of the left subtree, visits the root node,
     * and finally, does a recursive In-order Traversal of the right subtree.
     * What makes this traversal "in" order, is that the node is visited in between the recursive function calls
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + ", ");
        inOrderTraversal(node.right);
    }

    /**
     * Post-order Traversal is a type of Depth First Search.
     * Post-order Traversal works by recursively doing a Post-order Traversal of the left subtree and the right subtree, followed by a visit to the root node.
     * What makes this traversal "post" is that visiting a node is done "after" the left and right child nodes are called recursively.
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + ", ");
    }

    public static void main(String[] args) {
        //        R
        //       / \
        //      A   B
        //     / \ / \
        //    C  D E  F
        //            /
        //            G
        TreeNode root = createNewNode('R');
        TreeNode nodeA = createNewNode('A');
        TreeNode nodeB = createNewNode('B');
        TreeNode nodeC = createNewNode('C');
        TreeNode nodeD = createNewNode('D');
        TreeNode nodeE = createNewNode('E');
        TreeNode nodeF = createNewNode('F');
        TreeNode nodeG = createNewNode('G');

        root.left = nodeA;
        root.right = nodeB;

        nodeA.left = nodeC;
        nodeA.right = nodeD;

        nodeB.left = nodeE;
        nodeB.right = nodeF;

        nodeF.left = nodeG;

        // Test
        System.out.println("root.right.left.data: " + root.right.left.data);

        // Traverse
        preOrderTraversal(root); // R, A, C, D, B, E, F, G,
        System.out.println();

        inOrderTraversal(root); // C, A, D, R, E, B, G, F,
        System.out.println();

        postOrderTraversal(root); // C, D, A, E, G, F, B, R,
        System.out.println();

    }
}
