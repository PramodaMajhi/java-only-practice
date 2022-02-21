package com.concept.recursion;


import java.util.*;

public class UniqueBinarySearchTrees {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        List<TreeNode> result = generateTrees(3);
        System.out.println((result));
        printNode(result);
    }
    public static void printNode(List<TreeNode> result) {

    }
    /*
    Given an integer n, return the number of structurally unique BST's (binary search trees)
    which has exactly n nodes of unique values from 1 to n.
    IDEA:
        There are two ways we can solve this problem
        1) Recursive by counting left tree and right tree using combination to get the final count
        2) There is mathematical formula to compute called catalan number along with DP
           G(n) = G(i-1) * G(n-i)
     */
    public static int numTrees(int n) {
        int G[]  = new int[n +1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i<=n; i++) {

            for (int j = 1; j <= i; j++) {
                G[i]+= G[j-1] * G[i - j] ;
            }
        }
        return G[n];
    }
    /*
        Unique Binary Search Trees II
        IDEA:
        I will try to utilize the catalan recursive formula using DP (helper(start, i -1), helper(i+1, start))
        Only difference is instead of counting the number we need to return the
        list.
        In order to deal with list:
        helper(1, n) function and start with 1 and end with n
        (Only two arguments to helper function)
        In helper we need to create a new arraylist all_trees of type TreeNode
        Base condition
        start > end
        all_trees.add(null) and return the all_trees
        Now to pick up the root using for loop starting position would be your 1 and n inclusive
        lefsubtrees = all possible leftsubtree i is chosen to be helper(start, i -1)
        rightsubstrees = all possible rightsubtree i is chosen helper(i+1, start)
        for nested for loop to go over left subtree and right subtree
        to connect the left and right to the root of i;
        create a new TreeNode current  = new TreeNode(i);
        current.left = l
        current.right = r;
        then add into all_trees, finally return all_tree



     */
    public static List<TreeNode> generateTrees(int n) {

        if(n == 0 ) return new ArrayList<>();
        return helper(1, n);
    }

    private static ArrayList<TreeNode> helper(int start, int end) {
        ArrayList<TreeNode> all_trees = new ArrayList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            ArrayList<TreeNode> left_trees = helper(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            ArrayList<TreeNode> right_trees = helper(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
}
