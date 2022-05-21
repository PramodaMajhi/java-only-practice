package com.gfg.Arrays;

public class MaximumConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSumOfSubArray(arr));

    }
    public static int maxSumOfSubArray(int[] arr){

        int maxSub  = arr[0];
        int currentSubarray  = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSubarray = Math.max(currentSubarray + arr[i], arr[i]);
            maxSub = Math.max(maxSub, currentSubarray);
        }
        return maxSub;
    }
    public static int maxConsecutive1s(int[] arr) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int count = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
            i++;
        }
        return max;
    }
}
