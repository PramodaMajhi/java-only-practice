package com.gfg.Arrays;

import com.gfg.bitwise.MaxProduct;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaxProductSubarray {
    /*
    IDEA: Idea to use Kadane
     */
    
     public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];
        // /* Traverse through the array.
        // the maximum product subarray ending at an index
        // will be the maximum of the element itself,
        // the product of element and max product ending previously
        // and the min product ending previously. */
        for(int right = 1; right < nums.length; right++){
            int temp = Math.max(Math.max(maxEnding * nums[right], nums[right]),nums[right] * minEnding);
            minEnding = Math.min(Math.min(maxEnding * nums[right], nums[right]),nums[right] * minEnding);
            maxEnding = temp;
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static void main(String[] args) {
    //    int[]nums = {-2,3,-4};
            MaxProductSubarray obj = new MaxProductSubarray();
    }
}
