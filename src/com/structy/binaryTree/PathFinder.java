package com.structy.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder {

    public List<String> pathFinder(Node root, String target){

        List<String> result  = helper(root, target, new ArrayList<>());
        if(result.size() > 0) {
            Collections.reverse(result);
        }
        return result;
    }
    private List<String> helper(Node root, String target, List<String> res){
        if(root == null)
            return null;
        if(target.equals(root.str)){
            res.add(root.str);
            return res;
        }
        List<String> left = helper(root.left, target, res);
        if(left!=null){
            left.add(root.str);
            return left;
        }
        List<String> right = helper(root.right, target, res);
        if(right!=null){
            right.add(root.str);
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        Node b = new Node("b");
        Node a = new Node("a");
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
        PathFinder finder = new PathFinder();

        System.out.println(finder.pathFinder(a, "e")); // -> [ 'a', 'b', 'e' ]
    }
}
