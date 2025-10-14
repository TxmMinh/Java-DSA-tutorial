package com.completedsa.dsa.trees.binaryTree.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class BInaryTree {
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

    public static void bfs(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        int level = 0;
        while(!queue.isEmpty()) {
            System.out.print("level " + level + ": ");
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.removeFirst();
                System.out.print(curr.data + " ");
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            level++;
            System.out.println();
        }
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

        // Traverse
        bfs(root);
        /**
         * level 0: R
         * level 1: A B
         * level 2: C D E F
         * level 3: G
         */
        System.out.println();
    }
}
