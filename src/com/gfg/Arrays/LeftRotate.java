package com.gfg.Arrays;

import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        int d = 2;
       // System.out.println(Arrays.toString(leftRotateByOne(arr)));
        System.out.println(Arrays.toString(leftRotateByDEfficient(arr, d)));
      }

    public static int[] leftRotateByOne(int[] arr) {

        for (int i = 0; i < arr.length -1; i++) {
            int temp  = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        return arr;
    }

    /**
     *IDEA: 1) First create a temp arr with d elements,
     * 2) Copy d elements into temp array
     * 3) Start a loop and replace with the d position with arr first position
     * 4) Copy temp array into main array, from n - d + i th position
     * Time: (n+D) space O(d)
     */
    public static int[] leftRotateByD(int[] arr, int d) {
        int[]temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i-d] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }
        return arr;
    }
    /**
     *  Efficient solution Time o(n), O(1)
     *  Couple reversal will help us to achieve the result
     *  1) First reverse the d elements
     *      reverse(arr, 0, d - 1)
     *  2) Reverse the remaining d elements from index d to n-1
     *      reverse(arr, d, n - 1)
     *  3) Reverse the whole array
     *      reverse(arr, 0, n - 1)
     *
     */
    public static int[] leftRotateByDEfficient(int[] arr, int d) {
        // First reverse the d elements
        reverse(arr, 0, d -1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length-1);
        return arr;
    }

    private static void reverse(int[] arr, int low, int high) {

        while(low < high){
            swap(arr, low, high);
            low++;
            high--;
        }
    }
    private static void swap(int[] arr, int i , int j) {
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
