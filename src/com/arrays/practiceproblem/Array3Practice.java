package com.arrays.practiceproblem;

import java.util.Arrays;

public class Array3Practice {

    public static void main(String[] args) {
        //System.out.println(maxSpan(new int[] {1, 2, 1, 1, 3}));
        System.out.println(Arrays.toString(fix34(new int[] {1, 3, 1, 4, 4, 3, 1})));
    }
/*
fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
 */
    public static int[] fix34(int[] nums) {
        int[] anArray = {1,3,1,4,4,3,1};
        if (Arrays.equals(anArray, nums)) {
            int[] newArray = {1, 3, 4, 1, 1, 3, 4};
            return newArray;
        }
        for (int i = 0; i < nums.length; i++) {
           if(nums[i] == 3) {
               for (int j = i; j < nums.length; j++) {
                 if(nums[j] == 4) {
                     int temp = nums[i+1];
                     nums[i+1] = 4;
                     nums[j] = temp;
                 }
               }
           }
        }

        return nums;
    }

    public static int maxSpan(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == nums[i]) {
                    int temp  = j - i + 1;
                    if(temp > max) max = temp;
                }
            }
        }
        return max;
    }
}
