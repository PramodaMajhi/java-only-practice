package com.SDEPractice;
import apple.laf.JRSUIUtils;

import  java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Dec21 {
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {

       // System.out.println(numSubarraysWithSum(nums,2));
        int []nums = {1,0,1,0,1};
       System.out.println(numSubarraysWithSumBruteforce(nums,2));
//        TreeNode root = null;
//        List<Integer> list = new ArrayList<>(Arrays.asList(4,2,7,1,3));
//        for(Integer data: list) {
//          root =  insertIntoBSTIterative(root, data);
//        }
//        root =  insertIntoBSTIterative(root, 5);
//        printLeaf(root);

    }
    public static TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode cur = root;
        // if cur.val == val, that means we've inserted val into the tree
        while (cur.val != val) {
            if (cur.val > val) {
                // go left
                if (cur.left == null) cur.left = new TreeNode(val);
                cur = cur.left;
            } else {
                // go right
                if (cur.right == null) cur.right = new TreeNode(val);
                cur = cur.right;
            }
        }

        return root;
    }

    private static void printLeaf(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left ==  null && root.right == null) {
            System.out.println(root.val);
        }
        if(root.left!=null){
            printLeaf(root.left);
        }
        if(root.right!=null) {
            printLeaf(root.right);
        }

    }


    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
           root =  new TreeNode();
           root.val = val;
           return  root;
        }
        if(root.val < val) {
            root.right  = insertIntoBST(root.right, val);
        }
        else if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            return root;
        }
        return root;
    }

    /*
    930. Binary Subarrays With Sum
    Given a binary array nums and an integer goal, return the number of non-empty
    subarrays with a sum goal.
    A subarray is a contiguous part of the array.
    Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
     */

    // Brute force

    public static int numSubarraysWithSumBruteforce(int[] A, int S) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int sum_so_far = 0;

            for (int j = i; j < A.length; j++) {
                sum_so_far+=A[j];
                if(sum_so_far == S) {
                    count++;
                    print(A, i, j);
                }
            }
        }
        return count;
    }
    public static void print(int[] nums, int i, int j)
    {/// This will create new array  from your range.
        System.out.println(IntStream.range(i, j + 1)
                .mapToObj(k -> nums[k])
                .collect(Collectors.toList()));
    }
    // This algorithm called accumulative sum.
    public static int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) return 0;
        // key: prefix sum value, value: count of key that have been seen so far
        Map<Integer, Integer> counter = new HashMap<>();
        int sum = 0;
        int ans = 0;
        counter.put(0, 1);  // don't forget this trivial case
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int target = sum - S;
            ans += counter.getOrDefault(target, 0);
            counter.put(sum, counter.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
