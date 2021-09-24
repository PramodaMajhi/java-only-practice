// package com.java-practice.binaryTree.chapter4;

/**
 * Implement a function to check binary tree is a binary search tree.
 */
public class IsBinarySearchTree {
    private Node root;

    static class Node {
        private int val;
        private Node left = null;
        private Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    public boolean isBinarySearch(Node root) {

        return isBinarySearch(root, 1, 20);
    }

    private boolean isBinarySearch(Node root, int min, int max) {
        if (root == null)
            return true;
        if ((min != 0 && root.val <= min) || (max != 0 && root.val >= max)) {
            return false;
        }
        if (!isBinarySearch(root.left, min, root.val) || 
        !isBinarySearch(root.right, min, root.val)) {
            return false;
        }
        return true;
    }
}
