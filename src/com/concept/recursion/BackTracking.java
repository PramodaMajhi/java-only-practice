package com.concept.recursion;

public class BackTracking {

    public static void main(String[] args) {
        int[] nums = { 5,6,2 };
        int start = 0;
        int target = 8;
        System.out.println(groupSum6New(start, nums, target));
    }

    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return (target == 0);
        }

        if (groupSum(start + 1, nums, target - nums[start])) {
            return true; // considering
        }
        if (groupSum(start + 1, nums, target)) {
            return true;
        }

        return false;
    }

    /**
     * 
     * Given an array of ints, is it possible to choose a group of some of the ints,
     * beginning at the start index, such that the group sums to the given target?
     * However, with the additional constraint that all 6's must be chosen. (No
     * loops needed.)
     * 
     * 
     * groupSum6(0, [5, 6, 2], 8) → true
     * groupSum6(0, [5, 6, 2], 9) → false
     * groupSum6(0, [5, 6, 2], 7) → false
     * 
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupSum6(int start, int[] nums, int target) {
        int sum = 0;
        return backtrak(start, nums, target, sum);
    }

    public boolean backtrak(int start, int[] nums, int target, int sum) {
        if (sum == target)
            return true;
        if (start == nums.length)
            return false;

        for (int i = start; i < nums.length; i++) {
            sum += nums[i];

            if (backtrak(i + 1, nums, target, sum))
                return true;
            if (nums[i] != 6)
                sum -= nums[i];

        }
        return false;
    }

    public static boolean groupSum6New(int start, int[] nums, int target) {

        if (start >= nums.length) {
            return (target == 0);
        }
        // if the current element is 6, it must include in sum
        if (nums[start] == 6) {
            return groupSum6New(start + 1, nums, target - 6);
        }
        // Recursive call trying the case that nums[start] substract it from the target
        // in the call
        if (groupSum6New(start + 1, nums, target - nums[start])) {
            return true;
        }
        // Not included
        if (groupSum6New(start + 1, nums, target)) {
            return true;
        }
        return false;
    }
}