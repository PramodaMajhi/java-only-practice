package com.SDEPractice;

public class Feb8 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode leftChild  = new TreeNode(0);
        TreeNode rightChild = new TreeNode(0);
        root.left = leftChild;
        root.right = rightChild;
        System.out.println(distributeCoins(root));
    }
    /*
        979. Distribute Coins in Binary Tree
        IDEA: Write a dfs helper, return the number of coins given to the parent.
        We traverse child first(Post order) and return the balance of coins
        If we get '+3' from the left child, that means that the left subtree has three extra
        coins to move out, if we get '-1' from the right child we need to move one coin in.
        increase the moves by 4( 3 moves out left + 1 move in right)
        then we return  root.val + 3 left +(-1) right -1 (keep one coin for the root)
     */
    static  int  res = 0;
    public static int distributeCoins(TreeNode root) {
          dfs(root);
         return res;
    }

    private static int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res+=  Math.abs(left) + Math.abs(right);
        int val =  (root.val + left + right) -1;
        return val;
    }
}
