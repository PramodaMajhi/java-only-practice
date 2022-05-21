package com.SDEPractice;

import java.util.*;

public class Mar3 {

    public static void main(String[] args) {
        // root = [2,1,1]
        Dec302021.TreeNode  root = new Dec302021.TreeNode(2);
        Dec302021.TreeNode left  = new Dec302021.TreeNode(1);
        Dec302021.TreeNode right  = new Dec302021.TreeNode(1);
        root.left = left ;
        root.right = right;
        List<Dec302021.TreeNode> list = findDuplicateSubtrees(root);
        for (Dec302021.TreeNode node : list) {
            System.out.println(node.val);
        }
    }
/*
    652. Find Duplicate Subtrees
    IDEA: Create hashmap key as string and value as integer
    postorder traversal, create a key as string,  leftSubtree + rightSubtree
    and count the key , if key == 2 that means duplicate tree
 */

    public static List<Dec302021.TreeNode> findDuplicateSubtrees(Dec302021.TreeNode root) {
        List<Dec302021.TreeNode> list  = new ArrayList<Dec302021.TreeNode>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            dfs(root, hashMap, list);
        return list;
    }

    private static String dfs(Dec302021.TreeNode root, HashMap<String,
            Integer> hashMap, List<Dec302021.TreeNode> list) {
        if(root == null) {
            return "#";
        }
        String serialID  = root.val + "," + dfs(root.left, hashMap, list)
                + dfs(root.right, hashMap, list);
        hashMap.put(serialID, hashMap.getOrDefault(serialID,0) +1);
        if(hashMap.get(serialID) == 2) {
          //  System.out.println(root.val);
            list.add(root);
        }
        return serialID;
    }
    /*
        1832. Check if the Sentence Is Pangram
     */
    public static boolean checkIfPangram(String sentence) {
       int []ch = new int[26];
       if(sentence.length() < 26) return false; // early check

        for(char c : sentence.toCharArray()) {
            ch[c - 'a'] ++;
        }
        for (int i = 0; i <ch.length ; i++) {
            if(ch[i] == 0 ) return false;
        }
        return true;
    }


    public static List<Integer> traverse(Dec302021.TreeNode root) {
        List<Integer> list  = new ArrayList<Integer>();
        return helper(root, list);
    }
    private static List<Integer> helper(Dec302021.TreeNode root, List<Integer> list){
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = traverse(root.left);
        List<Integer> right = traverse(root.right);

        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }

}
