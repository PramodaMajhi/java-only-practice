package com.SDEPractice;

public class NumArrayJan23 {
    int [] nums;
    public NumArrayJan23(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum+=nums[i];
        }
        return sum;
    }
}
