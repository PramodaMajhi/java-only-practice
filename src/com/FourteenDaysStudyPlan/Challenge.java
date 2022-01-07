package com.FourteenDaysStudyPlan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Challenge {

    public static void main(String[] args) {
        int arr [] = {-1,-2,3,4};

        System.out.println(Arrays.toString(maxSubsequence(arr, 3)));
    }
    /*
    Input: nums = [2,1,3,3], k = 2
    Output: [3,3]
    Explanation:
    The subsequence has the largest sum of 3 + 3 = 6.
     */
    public static int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k];
        Queue<Integer> minHeap  = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int i = 0;
        for(int a: minHeap) {
            res[i++] = a;
        }

//        int resIndex=0;
//        for (int i = 0; i <nums.length ; i++) {
//            if(resIndex == k) return res;
//            if(minHeap.contains(nums[i])) {
//                res[resIndex++] = nums[i];
//                minHeap.remove();
//            }
//        }
        return res;
    }

}
