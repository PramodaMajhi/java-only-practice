package com.structy.binaryTree;

public class Node {
    int val;
    Node left;
    Node right;
    String str;
    public Node(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public Node(String str)
    {
        this.str = str;
        this.left = null;
        this.right = null;
    }

}
