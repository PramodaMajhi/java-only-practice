package com.structy.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllTreePaths {

    public List<List<String>> allTreePaths(Node root){
         if(root == null)
             return new ArrayList<>();
         if(root.left == null && root.right == null){
            List<String> tmp = new ArrayList();
            List<List<String>> ans  = new ArrayList<>();
            tmp.add(root.str);
            ans.add(tmp);
            return ans;
        }
       List<List<String>> res  = new ArrayList<>();

       List<List<String>> leftSubPaths = allTreePaths(root.left);
        for(List<String> subPath: leftSubPaths){
            subPath.add(0,root.str);
            res.add(subPath);
        }

       List<List<String>> rightSubPaths = allTreePaths(root.right);
        for(List<String> subPath: rightSubPaths){
            subPath.add(0,root.str);
            res.add(subPath);
        }
        return res;
    }


    public static void main(String[] args) {
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

             //   allTreePaths(a); // ->
        // [
        //   [ 'a', 'b', 'd' ],
        //   [ 'a', 'b', 'e' ],
        //   [ 'a', 'c', 'f' ]
        // ]
        AllTreePaths allTreePaths = new AllTreePaths();
        System.out.println(allTreePaths.allTreePaths(a));

    }

}
