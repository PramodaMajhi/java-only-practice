package com.gfg.pq;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProductOfTwoElemArray {
    // IDEA to sort array and use last two value for operations
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return ((nums[nums.length-1] -1)* (nums[nums.length-2]-1));
    }
    // Let's try to implement using priority queue
    public int maxProductPQ(int[] nums) {
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int num:nums) {
            priorityQueue.add(num);
        }
        int a = priorityQueue.poll()-1;
        int b = priorityQueue.poll()-1;
        return a*b;
    }

    public static void main(String[] args) {
        MaxProductOfTwoElemArray max = new MaxProductOfTwoElemArray();
        int[]nums = {3,4,5,2};
        int ans = max.maxProductPQ(nums);
        System.out.println(ans);
    }
}
