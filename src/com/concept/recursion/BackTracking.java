package com.concept.recursion;

public class BackTracking {

    public static void main(String[] args) {
        int []nums = {2, 4, 8};
        int start = 0;
        int target  = 10;
        System.out.println(groupSum(start, nums , target));
    }
    public static boolean groupSum(int start, int[] nums, int target) {
        if(start >= nums.length)  {
            return (target == 0);
        }

        if(groupSum(start+1, nums,target-nums[start])){
            return true; // considering
        }
        if(groupSum(start+1, nums, target)) {
            return true;
        }

        return false;
    }
}
