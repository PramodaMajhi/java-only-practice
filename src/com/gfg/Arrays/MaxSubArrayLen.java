package com.gfg.Arrays;

import java.util.HashMap;

public class MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarray = 0;
        HashMap<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Check if all of the numbers seen so far sum to k.
            if (prefixSum == k) {
                longestSubarray = i + 1;
            }

            // If any subarray seen so far sums to k, then
            // update the length of the longest_subarray.
            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }

            // Only add the current prefix_sum index pair to the
            // map if the prefix_sum is not already in the map.
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarray;
    }

    public static void main(String[] args) {
       int[] nums = {1,-1,5,-2,3};
       int k = 3;
       // Output: 4
       // Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
        MaxSubArrayLen  maxSubArrayLen = new MaxSubArrayLen();
        int ans = maxSubArrayLen.maxSubArrayLen(nums,k);
        System.out.println(ans);
    }
}
