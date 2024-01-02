package com.structy.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DepthFirstValues {

    public List<Integer> depthFirstValues(Node root) {
        return dfs(root, new ArrayList<Integer>());
    }
    private List<Integer> dfs(Node root, List<Integer> result){
        if(root == null){
            return result;
        }
         result.add(root.val);
        //if(root.left!=null){
          List<Integer> leftValues =  dfs(root.left, result);
       // }
        //if(root.right!=null){
           List<Integer> rightValues =  dfs(root.right, result);
       // }
        // result.add(root.val);
        //result.addAll(leftValues);
        //result.addAll(rightValues);
        return result;
    }
    public List<Integer> depthFirstValuesIterative(Node root) {
        if(root == null) return new ArrayList<>();
        Deque<Node> stack   = new ArrayDeque<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (stack.size() > 0){
            Node current = stack.pop();
            result.add(current.val);
            if(current.right!=null)
                stack.push(current.right);
            if(current.left!=null)
                stack.push(current.left);
        }
        return result;
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

        DepthFirstValues depthFirstValues = new DepthFirstValues();
        System.out.println(depthFirstValues.depthFirstValues(a));
        System.out.println(depthFirstValues.depthFirstValuesIterative(a));
    }
}
