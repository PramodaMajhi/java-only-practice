package com.gfg.Arrays;

public class MaxSumOfK {

    public static void main(String[] args) {
        int arr[] = {1, 8, 30, -5, 20, 7};
        int k = 3;
        System.out.println(maxSumOfK(arr, k));
        System.out.println(maxSumOfKOptimal(arr, k));
    }
    /*
    Given an array of integers and a number k,
    find the maximum sum of k consecutive elements
    arr[] = {1, 8, 30, -5, 20, 7}
    // This is O(n-k)*k
    Note: There is O(n) solution
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
    // n^2 solution
    public static int maxSumOfKOptimal(int arr[], int k) {
        int current_window_sum = 0;
        for (int i = 0; i < k; i++) {
            current_window_sum+= arr[i];
        }
        // start with k
        int max_sum_window = current_window_sum;
        for (int i = k; i < arr.length; i++) {
           // add first element of the next window
           // then remove the last element from previous element
           current_window_sum+= (arr[i] - arr[i-k]);
           max_sum_window = Math.max(max_sum_window, current_window_sum);
        }
        return max_sum_window;
    }
}
