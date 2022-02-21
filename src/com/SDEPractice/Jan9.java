package com.SDEPractice;

import java.util.*;

public class Jan9 {

    public static void main(String[] args) {
       //int[] nums = {3,0,1};
       //System.out.println(missingNumber(nums));
       int [] nums = {4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
    /*
    491. Increasing Subsequences
    Given an integer array nums, return all the different possible increasing subsequences
    of the given array with at least two elements. You may return the answer in any order.
    The given array may contain duplicates, and two equal integers should also be considered
    a special case of increasing sequence.
    Input: nums = [4,6,7,7]
    Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

     */
    public static Set<List<Integer>> listSet;
    public static List<List<Integer>> findSubsequences(int[] nums) {
        listSet  = new HashSet<>();
        backtrack(nums,0, new ArrayList<>());
        return new ArrayList<>(listSet);
    }

    private static  void backtrack(int nums[], int index, List<Integer> list) {
        if(list.size() >=2 ){
            listSet.add(new ArrayList<>(list));
        }
        for (int i = index; i <nums.length ; i++) {
            if(list.size() == 0 || list.get(list.size()-1) <= nums[i]){
                list.add(nums[i]);
                backtrack(nums, i+1, list);
                list.remove(list.size() -1);
            }
        }
    }

    /*
    268. Missing Number
       Given an array nums containing n distinct numbers in the range [0, n],
        return the only number in the range that is missing from the array.
     */
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int total = nums.length * ((nums.length + 1)/2);
        for (int num: nums) {
            sum+=num;
        }
        return total - sum;
    }
    /*
    If we initialize an integer to n and XOR it with every index and value
    we will be left with missing number
    missing
    Index	0	1	2	3
    Value	0	1	3	4
    =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
    =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
    =0∧0∧0∧0∧2
    =2

     */
    public int missingNumberBit(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
