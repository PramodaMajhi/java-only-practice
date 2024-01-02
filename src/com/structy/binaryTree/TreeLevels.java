package com.structy.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeLevels {

    public List<List<String>> treeLevels(Node root){
        if(root == null)
            return  new ArrayList<>();
        if(root.left == null && root.right == null){
            List<List<String>> res = new ArrayList<>();
            List<String> valList = new ArrayList<>();
            valList.add(root.str);
            res.add(valList);
            return  res;
        }
        List<List<String>> ans = new ArrayList<>();
        List<List<String>> left =  treeLevels(root.left);
        List<List<String>> right = treeLevels(root.right);
        for (List<String> leftPath: left){
            leftPath.add(0, root.str);
            ans.add(leftPath);
        }
        for (List<String> rightPath: right){
            rightPath.add(0,root.str);
            ans.add(rightPath);
        }
        return ans;
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

      //  treeLevels(a); // ->
// [
//   ['a'],
//   ['b', 'c'],
//   ['d', 'e', 'f']
// ]

        TreeLevels treeLevels = new TreeLevels();
        System.out.println(treeLevels.treeLevels(a));
    }
}
