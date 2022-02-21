package com.SDEPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jan26 {

    public static void main(String[] args) {
        String s = "HOW ARE YOU";
             //   "TO BE OR NOT TO BE"; //
       // System.out.println(printVertically(s));
       int [] nums = {1,2,3,4,4,9,56,90};
       int target = 8;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
/*
167. Two Sum II - Input Array Is Sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 */
    public static int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++) {
            int complement  = target - nums[i];
            // This will not work if duplicate is found
            // If there are duplicates, there is no guarantee which one will be found.
            int index = Arrays.binarySearch(nums, complement);
            if(index>0) {
                return new int[]{i+1, index+1};
            }
        }
        return null;
    }
/*

 */
    public static int[] twoSumTwoPointer(int[] nums, int target) {
      /* IDEA: Initialize two pointers
          i =0; j = nums.length -1
          sum = nums[i] + nums[j] == target
          search for higher  or lower number in the array
       */
      int i = 0;
      int j  = nums.length -1;
      while (i<j) {
          int sum = nums[i] + nums[j];
          if(sum == target) {
              return new int[] {i+1, j+1};
          } else if(sum < target) {
              i++;
          } else {
              j--;
          }
      }
      return  new int[]{-1, -1};
    }
    /**
     *Medium: [1324] Print Words Vertically (58%)
     * https://leetcode.com/problems/print-words-vertically
     */
    public static List<String> printVertically(String s) {
        String[] words = s.split(" ");
        List<String> ans  = new ArrayList<String>();

        int max = 0 ;
        // To find the max word. without sorting because retain the order
        for (int i = 0; i < words.length; i++) {
            max = Math.max(max, words[i].length());
        }


        for (int i = 0; i < max; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            // creating string builder for each word to delete character at the end
            for (String w: words) {
                stringBuilder.append(i< w.length() ? w.charAt(i) : " ");
            }
            // Remove trailing space if found at the last
            while (stringBuilder.charAt(stringBuilder.length()-1) == ' ') {
                stringBuilder.deleteCharAt(stringBuilder.length()-1); // remove trailing space
            }
            ans.add(stringBuilder.toString());
        }

        return ans;
    }
}
