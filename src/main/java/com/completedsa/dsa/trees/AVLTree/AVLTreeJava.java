package com.completedsa.dsa.trees.AVLTree;

/**
 * AVL trees are self-balancing, which means that the tree height is kept to a minimum so that a very fast runtime is guaranteed for searching, inserting and deleting nodes, with time complexity O(logn) .
 * The Balance Factor (BF) for a node (X) is the difference in height between its left and right subtrees:
 *   BF(X) = height(leftSubtree(X)) − height(rightSubtree(X))
 *   Balance factor values:
 *      0: The node is in balance.
 *      more than 0: The node is "left heavy".
 *      less than 0: The node is "right heavy".
 *   => If the balance factor is less than -1, or more than 1, for one or more nodes in the tree, the tree is considered not in balance, and a rotation operation is needed to restore balance.
 *   The Four "out-of-balance" Cases:
 *      CASE	         -  DESCRIPTION	                                            -   ROTATION TO RESTORE BALANCE
 *      Left-Left (LL)	 -  its left child node are both left-heavy.	            -   A single right rotation.
 *      Right-Right (RR) -	its right child node are both right-heavy.	            -   A single left rotation.
 *      Left-Right (LR)	 -  left heavy, and its left child node is right heavy.	    -   First do a left rotation on the left child node, then do a right rotation on the unbalanced node.
 *      Right-Left (RL)	 -  right heavy, and its right child node is left heavy.	-   First do a right rotation on the right child node, then do a left rotation on the unbalanced node.
 */
public class AVLTreeJava {
    public static class AVLTree {
        class TreeNode {
            char data;
            TreeNode left, right;
            int height;

            public TreeNode(char data) {
                this.data = data;
                height = 1;
            }
        }

        TreeNode root;

        private int height(TreeNode node) {
            if (node == null) {
                return 0;
            }

            return node.height;
        }

        public int getBalance(TreeNode node) {
            if (node == null) {
                return 0;
            }

            return height(node.left) - height(node.right);
        }

        //        Y                   X
        //       / \                 / \
        //      X   B       ->      C   Y
        //     / \ / \                 / \
        //    C  D E  F               D   B
        //                                / \
        //                               E   F
        private TreeNode rightRotate(TreeNode y) {
            TreeNode x = y.left;
            TreeNode T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        //        X                   Y
        //       / \                 / \
        //      A   Y               X   C
        //         / \             / \
        //        B   C           A   B
        private TreeNode leftRotate(TreeNode x) {
            TreeNode y = x.right;
            TreeNode T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        public TreeNode insert(TreeNode node, char data) {
            if (node == null) {
                return new TreeNode(data);
            }

            if (data < node.data) {
                node.left = insert(node.left, data);
            } else if (data > node.data) {
                node.right = insert(node.right, data);
            } else {
                return node; // Duplicate data is not allowed
            }

            node.height = Math.max(height(node.left), height(node.right)) + 1;
            int balance = getBalance(node);

            // Left Left Case
            if (balance > 1 && getBalance(node.left) >= 0) {
                return rightRotate(node);
            }

            // Left Right Case
            if (balance > 1 && getBalance(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Right Case
            if (balance < -1 && getBalance(node.right) <= 0) {
                return leftRotate(node);
            }

            // Right Left Case
            if (balance < -1 && getBalance(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        private TreeNode minValueNode(TreeNode node) {
            TreeNode current = node;

            while (current != null && current.left != null) {
                current = current.left;
            }

            return current;
        }

        public TreeNode delete(TreeNode node, char data) {
            if (node == null) {
                return node;
            }

            if (data < node.data) {
                node.left = delete(node.left, data);
            } else if (data > node.data) {
                node.right = delete(node.right, data);
            } else {
                if (node.left == null || node.right == null) {
                    TreeNode temp = node.left != null ? node.left : node.right;

                    if (temp == null) {
                        // No child
                        node = null;
                    } else {
                        // One child
                        node = temp;
                    }
                } else {
                    // Two children
                    TreeNode temp = minValueNode(node.right);
                    node.data = temp.data;
                    node.right = delete(node.right, temp.data);
                }
            }

            if (node == null) {
                return node;
            }

            node.height = Math.max(height(node.left), height(node.right)) + 1;
            int balance = getBalance(node);

            // Left Left Case
            if (balance > 1 && getBalance(node.left) >= 0) {
                return rightRotate(node);
            }

            // Left Right Case
            if (balance > 1 && getBalance(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Right Case
            if (balance < -1 && getBalance(node.right) <= 0) {
                return leftRotate(node);
            }

            // Right Left Case
            if (balance < -1 && getBalance(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        public void inOrderTraversal(TreeNode node) {
            if (node == null) {
                return;
            }

            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }

        public static void main(String[] args) {
            AVLTree tree = new AVLTree();
            char[] letters = {'C', 'B', 'E', 'A', 'D', 'H', 'G', 'F'};
            for (char letter : letters) {
                tree.root = tree.insert(tree.root, letter);
            }

            tree.inOrderTraversal(tree.root);

            System.out.println("\nDeleting A");
            tree.root = tree.delete(tree.root, 'A');
            tree.inOrderTraversal(tree.root);
        }
    }
}
