package com.arrays.practiceproblem;

import java.util.Arrays;

public class GeeksforSeekArray {

    public static void main(String[] args) {
        int [] nums  =  {1, 2, 3, 4, 5, 6, 7};
        int d = 3;
        int n = nums.length;
        for (int i = 0; i < d; i++) {
            arrayRotation(nums, n);
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void arrayRotation(int[]nums, int n) {
        // arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7

        int temp  = nums[0];
        for (int i = 0; i < n -1; i++) {
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }

    }
}
