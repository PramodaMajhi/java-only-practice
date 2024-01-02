package com.structy.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeIncludes {
    public boolean treeIncludes(Node root, String target){
        if(root == null) return false;
        if(root.str.equals(target)) return true;
        return treeIncludes(root.left, target) || treeIncludes(root.right, target);
    }

    public boolean treeIncludesItr(Node root, String target){
        if(root == null) return false;
        Deque<Node>  queue = new ArrayDeque<>();

        queue.offer(root);
        while (queue.size() > 0) {
            Node current =  queue.poll();
            if(current.str.equals(target))
                return true;
            if(current.left!=null)
                queue.offer(current.left);
            if(current.right!=null)
                queue.offer(current.right);
        }
        return false;
    }
    public static void main(String[] args) {
        TreeIncludes treeIncludes = new TreeIncludes();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f
        System.out.println(treeIncludes.treeIncludes(a, "e"));
        System.out.println(treeIncludes.treeIncludesItr(a, "e"));
    }
}
