package com.gfg.Arrays;

public class MaxLengthEvenOddSubarray {
    public static void main(String[] args) {
        int[]arr  = {10, 12, 14, 7, 8};
        System.out.println(maxLengthOfEvenOddSubArray(arr));
    }
/*
IDEA: Kadane's algorithm
for every element there are two cases
you want to a new sub array or extend the previous sub array
In this case we are extending previous sub array, if current element is alternating with
previous element, if not we are begun a new sub array
O(n) solution
 */
    public static int maxLengthOfEvenOddSubArray(int[] arr) {
        int res = 0;
        int curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if((arr[i]%2 == 0 && arr[i-1]%2!=0) ||
                (arr[i]%2 != 0 && arr[i-1]%2==0)){
                curr++;
                res = Math.max(res, curr);
            } else
                curr =1;
        }
        return res;
    }
}
