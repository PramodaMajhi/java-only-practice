package com.gfg.Arrays;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {0,3,5,6,94,97};
        System.out.println(isSorted(arr));
    }
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i -1]) {
                return false;
            }
        }
        return true;
    }
}
