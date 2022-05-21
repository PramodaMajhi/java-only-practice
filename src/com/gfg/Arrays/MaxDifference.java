package com.gfg.Arrays;

public class MaxDifference {
    public static void main(String[] args) {
        int[]arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDiff(arr));
        System.out.println(maxDiffEfficient(arr));
    }
    /*
      IDEA: O(n^2), Initialize the second and first difference
     */
    public static int maxDiff(int[] arr) {
        int res = arr[1] - arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }
        }
        return res;
    }
    /*
      IDEA:  Initialize the second and first difference
      Keep track of min element we have seen so far, and for every element we subtract
      from min element, keep updating the min value
     */
    public static int maxDiffEfficient(int[] arr) {
        int res = arr[1] - arr[0];
        int minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > minVal){
                res = Math.max(res, arr[i] -minVal);
            }
            minVal = Math.min(minVal, arr[i]);
        }
        return res;
    }
}
