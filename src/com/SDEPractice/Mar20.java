package com.SDEPractice;

public class Mar20 {
    public static void main(String[] args) {

    }
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        int first = nums[0];
        for(int i = 1 ; i < nums.length; i++) {
            max = Math.max(first^nums[i], first);
        }
        return max;
    }
}
