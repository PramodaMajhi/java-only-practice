package com.gfg.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[]arr = {20, 5, 40, 60, 10, 30};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    /**
     IDEA: keep your array in two parts, sorted and unsorted
     start with index 1, and keep

     O(n^2) worst case
     In-place and stable
     Used in practice for small arrays(TimSort and IntroSort)
     O(n) in Best case

     Note: We used greater than for comparison instead of greater than equals
     just to maintain sort stable
     */
    public static int[] insertionSort(int[]arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
}
