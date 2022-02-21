package com.gfg.Arrays;

public class MaxSumOfK {

    public static void main(String[] args) {
        int arr[] = {1, 8, 30, -5, 20, 7};
        int k = 3;
        System.out.println(maxSumOfK(arr, k));
    }
    /*
    Given an array of integers and a number k,
    find the maximum sum of k consecutive elements
    arr[] = {1, 8, 30, -5, 20, 7}
     */
    public static int maxSumOfK(int arr[], int k) {
     int max_sum  = Integer.MIN_VALUE;
        for (int i = 0; i<= arr.length-k ; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum+=arr[i+j];
            }
            max_sum = Math.max(max_sum, sum);
          //  System.out.println(sum);
        }
     return max_sum;
    }
}
