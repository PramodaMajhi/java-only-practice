package com.gfg.Arrays.Hashing;

import java.util.HashMap;

public class ZeroSubarray {
    public boolean isZeroSubArray(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if(sum == 0){
                    return true;
                }
            }
        }
        return false;
    }
    /*
    IDEA: prefixSum + Hashing
    If sum of[i:j] is 0 then prefixSum1 must be same prefixSum2
    because we are adding prefixSum1 + 0(prefixSum2) = prefixSum1
    Don't forget to check explicitly the condition, because prefix sum itself
    is zero.
     */
    public boolean isZeroSubArrayEfficient(int[] nums, int k){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        for (int left = 0; left < nums.length; left++) {
            prefixSum+=nums[left];
            if(prefixSum == k) return true; // explicitly [-3,2,1]
            if(hashMap.containsKey(prefixSum-k)){
                return true;
            }
            if(!hashMap.containsKey(prefixSum)){
                hashMap.put(prefixSum,left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ZeroSubarray zeroSubarray = new ZeroSubarray();
        int[]nums = {-3,2,1,4};
        int k = 0;
        System.out.println(zeroSubarray.isZeroSubArray(nums));
        System.out.println(zeroSubarray.isZeroSubArrayEfficient(nums,k));
    }
}
