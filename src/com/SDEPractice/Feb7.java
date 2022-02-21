package com.SDEPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Feb7 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        Input: s = "eccbbbbdec"
//        Output: [10]
        System.out.println(partitionLabels(s));
    }

    /*
        543. Diameter of Binary Tree
     */
    private static int diameter;
    public static int diameterOfBinaryTree(Dec302021.TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }

    private static int helper(Dec302021.TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left,right) + 1;
    }
    /*
        763. Partition Labels
        Input: s = "ababcbacadefegdehijhklij"
        Output: [9,7,8]
     */
    /*
    IDEA:
        1) Traverse the string record the last index of each char.
        2) Using pointer to record end of the current sub string.
     */
    public static List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return null;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        // Record the last index of each character
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), i);
        }
        // Make division
        int start = 0;
        int last = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i <s.length() ; i++) {
            last = Math.max(last, hashMap.get(s.charAt(i)));
            if(i == last) {
                ans.add(last - start +1);
                start = last +1;
            }
        }
        return ans;
    }
}
