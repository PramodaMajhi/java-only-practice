package com.gfg.Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqualzerosAndOnes {
    public int longestSubEqual0s1sNaive(int nums[]) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int c1 = 0, c0 = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0)
                    c0++;
                else
                    c1++;
                if (c1 == c0) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public int longestSubEqual0s1sEfficient(int nums[]) {
        int res = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 1 ? 1 : -1);
            // Array from index 0 to i contains equal number of 0's and 1's
            if (prefixSum == 0) {
                res = Math.max(res, i + 1);
            }
            if (hashmap.containsKey(prefixSum)) {
                res = Math.max(res, i - hashmap.get(prefixSum));
            }
            if(!hashmap.containsKey(prefixSum)){
                hashmap.put(prefixSum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 0};
        LongestSubArrayWithEqualzerosAndOnes obj = new LongestSubArrayWithEqualzerosAndOnes();
        System.out.println(obj.longestSubEqual0s1sNaive(nums));
        System.out.println(obj.longestSubEqual0s1sEfficient(nums));
    }
}
