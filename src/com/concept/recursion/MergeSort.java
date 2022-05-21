package com.concept.recursion;

import java.util.Arrays;
import java.util.HashMap;

public class MergeSort {

    public static void main(String[] args) {
        int[] n  = {1,5,3,2,8,7,6,4};
        System.out.println(Arrays.toString(merge_sort(n)));
    }

    /*
    There are two approach to implement
    1) Top Down
    2) Bottom Up

    IDEA:
        TopDown approach can be naturally implemented using recursion
        1) Divide the given unsorted list into several sub lists(Divide)
        2) Sort each of the sub lists recursively (conquer)
        3) Merge the sorted sub lists to produce new sorted list (combine)
     */
    public static int [] merge_sort(int [] input) {

        if(input.length <=1)
            return input;
        int pivot = input.length/2;
        int[] left = merge_sort(Arrays.copyOfRange(input, 0, pivot));
        int[] right  = merge_sort(Arrays.copyOfRange(input,pivot, input.length));
        return merge(left, right);
    }
    public static  int[] merge(int[] leftArr, int[] rightArr) {
        int[] ret = new int[leftArr.length + rightArr.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int retIndex = 0;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex])
                ret[retIndex++] = leftArr[leftIndex++];
            else {
                ret[retIndex++] = rightArr[rightIndex++];
            }
        }
        // append left over for left array
        while (leftIndex < leftArr.length) {
            ret[retIndex++] = leftArr[leftIndex++];
        }
        // append left of right array
        while (rightIndex< rightArr.length) {
            ret[retIndex++] = rightArr[rightIndex++];
        }
        return ret;
    }
}
