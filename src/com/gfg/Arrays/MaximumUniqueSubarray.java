package com.gfg.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        // Value -> index
        Map<Integer,Integer> lastIndexMap = new HashMap<Integer,Integer>();
        int[] prefixSum = new int[nums.length +1];

        int result = 0;
        int left = 0; // start pointer

        for(int right = 0; right < nums.length; right++){
            int currentElement = nums[right]; // 4
            prefixSum[right + 1] = prefixSum[right]+currentElement;
            // If the last index of current element is greater than left,
            // then update left to the position after last index of currentElement
            if(lastIndexMap.containsKey(currentElement)){
                left = Math.max(left, lastIndexMap.get(currentElement) +1);
            }
            // Update the result with maximum sum found so far.
            result = Math.max(result, prefixSum[right+1] - prefixSum[left]);
            lastIndexMap.put(currentElement, right);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumUniqueSubarray maximumUniqueSubarray = new MaximumUniqueSubarray();
        int[]nums = {4,2,4,5,6};
        // output: 17
        System.out.println(maximumUniqueSubarray.maximumUniqueSubarray(nums));
    }
}
