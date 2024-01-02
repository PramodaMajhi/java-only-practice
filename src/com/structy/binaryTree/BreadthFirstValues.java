package com.structy.binaryTree;

import java.sql.SQLOutput;
import java.util.*;

public class BreadthFirstValues {

    public List<Integer> breadthFirstValues(Node root){
        List<Integer> result = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        if(root == null)
            return result;
        queue.add(root);
        while (queue.size() > 0) {
            Node current  = queue.pop();
            result.add(current.val);
            if(current.left!=null)
                queue.add(current.left);
            if(current.right!=null)
                queue.add(current.right);
        }

        return  result;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      1
        //    /   \
        //   2     3
        //  / \     \
        // 4   5     6

        BreadthFirstValues breadthFirstValues = new BreadthFirstValues();
        //    -> ['1', '2', '3', '4', '5', '6']
        System.out.println(breadthFirstValues.breadthFirstValues(a));
    }
}
