package com.structy.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeMinValue {

    public int treeMinValue(Node root){
        if(root == null)
            return Integer.MAX_VALUE;
        int res = Math.min(treeMinValue(root.left),treeMinValue(root.right));
        return  Math.min(root.val, res);
    }
    public int treeMinValueIterative(Node root){
        Deque<Node> stack = new ArrayDeque<>();
        int smallest = Integer.MAX_VALUE;
        stack.push(root);
        while (stack.size() > 0) {
            Node current = stack.pop();
            if(current.val < smallest) {
                smallest = current.val;
            }
            if(current.left!=null)
                stack.push(current.left);
            if(current.right!=null)
                stack.push(current.right);
        }
        return smallest;
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
        TreeMinValue treeMinValue  = new TreeMinValue();
        System.out.println(treeMinValue.treeMinValue(a)); // -> -2
        System.out.println(treeMinValue.treeMinValueIterative(a)); // -> -2
    }
}
