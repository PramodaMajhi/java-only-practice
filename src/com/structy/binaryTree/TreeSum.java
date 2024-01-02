package com.structy.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeSum {
    public int treeSum(Node root){
        if(root == null)
            return 0;

        return root.val + treeSum(root.left) + treeSum(root.right);
    }
    public int treeSumIterative(Node root){
        if(root == null)
            return 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int sum = 0;
        while (queue.size() > 0){
            Node current  = queue.poll();
            sum+=current.val;
            if(current.left!=null) queue.offer(current.left);
            if(current.right!=null) queue.offer(current.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(11);
        Node c = new Node(4);
        Node d = new Node(4);
        Node e = new Node(-2);
        Node f = new Node(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //       3
        //    /    \
        //   11     4
        //  / \      \
        // 4   -2     1
        TreeSum treeSum = new TreeSum();
        System.out.println("Rec  " +treeSum.treeSum(a)); // 21
        System.out.println("Itr  " + treeSum.treeSumIterative(a)); // 21
    }
}
