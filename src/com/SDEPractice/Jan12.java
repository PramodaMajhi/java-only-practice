package com.SDEPractice;

import com.arrays.practiceproblem.TrieRecursive;

import java.util.*;

public class Jan12 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode insertNode(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (root.val < data) {
            root.right = insertNode(root.right, data);
        } else if (root.val > data) {
            root.left = insertNode(root.left, data);
        } else {
            return root;
        }
        return root;
    }

    public static void printLeaf(TreeNode root) {
        if (root == null) return;
            System.out.print(root.val + ", ");
        if (root.left != null) {
            printLeaf(root.left);
        }
        if (root.right != null) {
            printLeaf(root.right);
        }
    }

    public static void main(String[] args) {

//        List<Integer> dataList = new ArrayList<>(Arrays.asList(4, 2, 7, 1, 3, 6, 9));
//        TreeNode root = null;
//        for (Integer data : dataList) {
//            root = insertNode(root, data);
//        }
//        invertTree(root);
//        printLeaf(root);
//        invertTreeBFS(root);
//        System.out.println();
//        printLeaf(root);
        String board = "WWRRBBWW";
        String hand = "WRBRW";
        System.out.println(findMinStep(board, hand));
    }
    /*
        488. Zuma Game
        Input: board = "WWRRBBWW", hand = "WRBRW"
        Output: 2
        Explanation: To make the board empty:
        - Insert 'R' so the board becomes WWRRRBBWW. WWRRRBBWW -> WWBBWW.
        - Insert 'B' so the board becomes WWBBBWW. WWBBBWW -> WWWW -> empty.
        2 balls from your hand were needed to clear the board.
     */

    public static int findMinStep(String board, String hand) {
        for (int i = 0; i < board.length(); i++) {

        }
        return 0;
    }


    /*
    226. Invert Binary Tree
    Input: root = [4,2,7,1,3,6,9]
    Output: [4,7,2,9,6,3,1]
     */

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
    public static TreeNode invertTreeBFS(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode current  = queue.poll();
            TreeNode temp  = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left!=null) {
                queue.add(current.left);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
        }

        return root;
    }
}
