package com.SDEPractice;

import java.util.Arrays;

public class Jan27 {
    public static void main(String[] args) {
        System.out.println(Math.floor(-1/2));
    }
 /*
   IDEA: Check if both are null then true
   if either of them are null return false
   if val does not match return false;
   using tail recursion call one function left and one for right
   and compare with logical end.

   Another IDEA to think of by using deque
   Start from the root and left then at each iteration pop the current node out of the deque
   the check p and q are not same
   p.val is equal to q.val

   Create two deque
   one for p and another for q
   p.addLast(p)
   q.addLast(q)
   loop through it, then remove from the front
  */
    public boolean isSameTree(Dec302021.TreeNode p, Dec302021.TreeNode q) {
        // p and q are both equal
        if(p == null && q==null)
            return true;
        // one of p or q are null
        if(p == null || q==null)
            return false;
        if(p.val != q.val) {
           return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
/*
462. Minimum Moves to Equal Array Elements II
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
IDEA: step 1: sort the array
      step 2: Find the middle element of the array
      Now loop through the array to measure absolute value from mid element
      using math function Math,abs(mid - nums[i]) and count it
 */
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length/2];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            count+= Math.abs(mid - nums[i]);
        }
        return count;
    }
}
