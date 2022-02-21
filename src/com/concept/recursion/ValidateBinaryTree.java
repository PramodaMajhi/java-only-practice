package com.concept.recursion;

public class ValidateBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }
    /**
     IDEA:  Pass min and max as null value. and check x.val<=min and x.val>=max
     if any of the condition satisfied return false
     call isBST recursively for root.left, min and x.val and change the upper limit
     for isBST root.right, x.val, max
     **/
    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    public boolean isValidBST(TreeNode root) {
        return isBST(root,null, null);
    }
    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    private boolean isBST(TreeNode x, Integer min, Integer max) {
        if(x == null) return true;
        if(min!=null && x.val <= min ) return false;
        if(max!=null && x.val >= max ) return false;
        // lower limit remain same  and upper limit changes to the root
        return isBST(x.left, min, x.val) && isBST(x.right, x.val, max);
        // Lower limit is the root value and upper limmit remain same.
    }
}
