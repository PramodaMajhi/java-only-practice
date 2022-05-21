package com.SDEPractice;

import java.util.*;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrderRec(Dec302021.TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) return levels;
        helper(root, levels, 0);
        return levels;
    }
    private static void helper(Dec302021.TreeNode root, List<List<Integer>> levels, int level) {
        // start the current level
        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        //fulfill the current level
        levels.get(level).add(root.val);
        // process the child node for the next level
        if(root.left!=null)
        helper(root.left, levels, level+1);
        if(root.right!=null)
            helper(root.right, levels, level+1);
    }
    public static List<List<Integer>> levelOrder1(Dec302021.TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<Dec302021.TreeNode> queue  = new LinkedList<Dec302021.TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
           // start the current level
            result.add(new ArrayList<Integer>());
            // Number of element in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                Dec302021.TreeNode node = queue.poll();
                //fulfill the current level
                result.get(level).add(node.val);
                // add child nodes of the current level
                // in the queue for the next level
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            // go to the next level
            level++;
        }
        return result;
    }
    public static List<List<Integer>> levelOrder(Dec302021.TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Dec302021.TreeNode, Integer> hashmap = new HashMap<>();
        Deque<HashMap<Dec302021.TreeNode, Integer>> queue  = new ArrayDeque<>();
        hashmap.put(root, 0);
        queue.offer(hashmap);
        int level = 0;
        while (queue.size() > 0) {
            HashMap<Dec302021.TreeNode, Integer> temp = queue.remove();
            Dec302021.TreeNode node = null;
            int levelNum = 0;
            for (Map.Entry<Dec302021.TreeNode, Integer> entry: temp.entrySet()) {
                node  = entry.getKey();
                levelNum = entry.getValue();
            }
            if(result.size() == levelNum) {
                List sub = new ArrayList();
                sub.add(node.val);
                result.add(sub);
            }else {
                result.get(levelNum).add(node.val);
            }

            if(node.left!=null) {
                hashmap.put(node.left, levelNum +1);
                queue.offer(hashmap);
            }
            if(node.right!=null) {
                hashmap.put(node.right, levelNum +1);
                queue.offer(hashmap);
            }
            hashmap.remove(node);
        }
        return result;
    }

    public static void main(String[] args) {
        Dec302021.TreeNode  root = new Dec302021.TreeNode(3);
        Dec302021.TreeNode  firstLeft = new Dec302021.TreeNode(9);
        Dec302021.TreeNode  firstRight = new Dec302021.TreeNode(20);
        Dec302021.TreeNode  secondLeft = new Dec302021.TreeNode(15);
        Dec302021.TreeNode  secondRight = new Dec302021.TreeNode(7);
        root.left = firstLeft;
        root.right = firstRight;
        firstRight.left = secondLeft;
        firstRight.right = secondRight;
        System.out.println(levelOrder(root));
        System.out.println(levelOrder1(root));
        System.out.println(levelOrderRec(root));
    }
}
