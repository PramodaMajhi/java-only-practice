package com.gfg.Arrays;

import java.util.Arrays;

public class RemoveDuplicateSorted {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 30, 30, 30};
        System.out.println(Arrays.toString(removeDuplicate(arr)));
    }

    public static int[] removeDuplicate(int[] arr) {

        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[index - 1]) {
                arr[index++] = arr[i];
            }
        }
       //  System.out.println(index);
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr;
    }
}
