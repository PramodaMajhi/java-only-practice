package com.gfg.Arrays;

import java.util.Arrays;

public class DeleteOperation {
    public static void main(String[] args) {
        int []arr = {3, 8, 12,5 ,6};
        int element = 12;
        System.out.println(largestElement(arr));
    }

    public static int largestElement(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(arr[i], res);
        }
        return res;
    }
    public static int[] delete(int[]arr, int element) {
        int i;
        for (i = 0;  i < arr.length; i++)
            if(arr[i] == element)
            break;

            for (int j = i; j < arr.length -1 ; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length -1] = 0;
        return arr;
    }
}
