package com.completedsa.dsa.trees.binarySearchTree;

/**
 * A Binary Search Tree (BST) is a type of Binary Tree data structure, where the following properties must be true for any node "X" in the tree:
 *  The X node's left child and all of its descendants have lower values than X's value.
 *  The right child, and all its descendants have higher values than X's value.
 *  Left and right subtrees must also be Binary Search Trees.
 *  All nodes in the BST are unique.
 *  A node's in-order successor is the node that comes after it if we were to do in-order traversal.
 */
public class BinarySearchTree {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    /**
     * Traversal of a Binary Search Tree
     * To check if a Binary Tree is BST, is to do an in-order traversal and check if the resulting list of values are in an increasing order.
     */
    // This traversal is mainly used for Binary Search Trees where it returns values in ascending order.
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    /**
     * Search for a Value in a BST:
     *  Start at the root node.
     *  If this is the value we are looking for, return.
     *  If the value we are looking for is higher, continue searching in the right subtree.
     *  If the value we are looking for is lower, continue searching in the left subtree.
     *  If the subtree we want to search does not exist return null to indicate that the value is not inside the BST.
     */
    public static TreeNode search(TreeNode node, int target) {
        // The time complexity for searching a BST for a value is O(h), where h is the height of the tree.
        if (node == null) {
            return null;
        } else if (node.data == target) {
            return node;
        } else if (target < node.data) {
            return search(node.left, target);
        } else {
            return search(node.right, target);
        }
    }

    /**
     * Insert a Node in a BST:
     *  Start at the root node.
     *  Compare each node:
     *      Is the value lower? Go left.
     *      Is the value higher? Go right.
     *  Continue to compare nodes with the new value until there is no right or left to compare with. That is where the new node is inserted.
     * Inserting nodes as described above means that an inserted node will always become a new leaf node.
     */
    public static TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else if (data > node.data) {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    /**
     * Find The Lowest Value in a BST Subtree
     *  Start at the root node of the subtree.
     *  Go left as far as possible.
     *  The node you end up in is the node with the lowest value in that BST subtree.
     */
    public static TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current != null && current.left != null) {
            current = current.left;
        }

        return current;
    }

    /**
     * Delete a Node in a BST
     *  If the node is a leaf node, remove it by removing the link to it.
     *  If the node only has one child node, connect the parent node of the node you want to remove to that child node.
     *  If the node has both right and left child nodes: Find the node's in-order successor, change values with that node, then delete it.
     */
    public static TreeNode delete(TreeNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: Get the inorder successor
            node.data = minValueNode(node.right).data;
            node.right = delete(node.right, node.data);
        }

        return node;
    }

    /**
     * On a Binary Search Tree, operations like inserting a new node, deleting a node, or searching for a node are actually O(h).
     * That means that the higher the tree is (h), the longer the operation will take.
     * For a balanced BST: O(h)=O(logn)
     * In case the BST is completely unbalanced: O(h)=O(n)
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(19);

        root.right.right.left = new TreeNode(18);

        // Traverse
        inOrderTraversal(root);
        System.out.println();

        // Search for a value
        TreeNode result = search(root, 8);
        if (result != null) {
            System.out.println("Found the node with value: " + result.data);
        } else {
            System.out.println("Value not found in the BST.");
        }

        // Inserting new value into the BST
        insert(root, 10);

        // Traverse
        inOrderTraversal(root);
        System.out.println();

        // Find The Lowest Value in a BST Subtree
        TreeNode minNode = minValueNode(root);
        System.out.println("Lowest value: " + minNode.data);

        // Delete node 15
        delete(root, 15);

        // Traverse
        inOrderTraversal(root);
    }
}
