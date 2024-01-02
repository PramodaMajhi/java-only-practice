package com.structy.binaryTree;

import com.SDEPractice.Dec302021;

public class TreeValueCount {

    public int treeValueCount(Node root, int target) {
        return helper(root, target);
    }

    public int helper(Node root, int target){
        if(root == null)return 0;

        int count = (root.val == target) ? 1 : 0;

         int leftCount =  helper(root.left, target);
         int rightCount = helper(root.right, target);
        return count + leftCount + rightCount;
    }

    public static void main(String[] args) {
        Node a = new Node(12);
        Node b = new Node(6);
        Node c = new Node(6);
        Node d = new Node(4);
        Node e = new Node(6);
        Node f = new Node(12);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      12
        //    /   \
        //   6     6
        //  / \     \
        // 4   6     12
        TreeValueCount treeValueCount = new TreeValueCount();
        System.out.println(treeValueCount.treeValueCount(a,  6)); // -> 3
    }
}
