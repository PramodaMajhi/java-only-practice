package com.FourteenDaysStudyPlan;


import java.util.Arrays;
import java.util.HashMap;

public class Day3TwoPointer {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
    /*
    167. Two Sum II - Input Array Is Sorted
    Given a 1-indexed array of integers numbers that is
    already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.
    Let these two numbers be numbers[index1]
    and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2,
    added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution.
    You may not use the same element twice.
    Example 1:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
    */
    // Point to be noted. the array is sorted , This is enhanced version than hashMap solution

    public static int[] twoSum1(int[] nums, int target) {
       // Two Pointer strategy
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if(sum < target) {
                low++;
            } else if(sum > target) {
                high--;
            } else {
                return new int[] {low, high};
            }
        }
        return  null;
    }


    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> twoSum = new HashMap<>();
        for (int i = 0; i <numbers.length; i++) {
            int num = numbers[i];
            int complement  = target - num;
            if(twoSum.containsKey(complement)) {
                return new int[] {twoSum.get(complement)+1, i+1};
            } else {
                twoSum.put(num, i);
            }
        }
        throw new IllegalArgumentException("IllegalArgument Exception");
    }
/*
    283. Move Zeroes
    Given an integer array nums, move all 0's to the end of it while maintaining
    the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.
    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
 */
    public static int[] moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) {
                nums[k++] = nums[i];
            }
        }
        while (k < nums.length) {
            nums[k++] =0;
        }
        return nums;
    }
}
