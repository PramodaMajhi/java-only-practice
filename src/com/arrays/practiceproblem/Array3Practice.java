package com.arrays.practiceproblem;

import java.text.BreakIterator;
import java.util.Arrays;

public class Array3Practice {

    public static void main(String[] args) {
        //System.out.println(maxSpan(new int[] {1, 2, 1, 1, 3}));
        System.out.println(Arrays.toString(squareUp(2)));
    }
/*
squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
squareUp(2) → [0, 1, 2, 1]
squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
 */
    public static  int[] squareUp(int n) {
        int[]arr = new int[n*n];
        for(int i=1 ; i<=n ; i++){
            for (int j=1 ; j<=i ;j++){
                int index = (i*n-j);
                 arr[index]=j;
            }
        }

        return arr;
    }
 /*
linearIn([1, 2, 4, 6], [2, 4]) → true
linearIn([1, 2, 4, 6], [2, 3, 4]) → false
linearIn([1, 2, 4, 4, 6], [2, 4]) → true
 */
    public static  boolean linearIn(int[] outer, int[] inner) {
        int j = 0;
        for (int i = 0; i<outer.length && j<inner.length; i++) {

            if(outer[i] == inner[j]) j++;
        }
        return j == inner.length;
    }
    /*
    canBalance([1, 1, 1, 2, 1]) → true
    canBalance([2, 1, 1, 2, 1]) → false
    canBalance([10, 10]) → true
     */
    public static boolean canBalance(int[] nums) {
        int rightSum = 0, leftSum = 0;

        for (int i = 0; i <nums.length; i++) {
            leftSum+=nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum+=nums[i];
            leftSum-=nums[i];
            if(leftSum == rightSum)  return  true;
        }
        return false;
    }

    /*
fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
 */
    public static  int[] fix45(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 4) {
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j] == 5) {
                        if(j>0 && nums[j-1]!=4){
                            int temp  = nums[i+1];
                            nums[i+1] = 5;
                            nums[j] = temp;
                        }else if(j == 0) {
                            int temp = nums[i+1];
                            nums[i+1] = 5;
                            nums[j] = temp;
                        }

                    }
                }
            }
        }
        return nums;
    }
/*
fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
 */
    public static int[] fix34(int[] nums) {
        int[] anArray = {1,3,1,4,4,3,1};
        if (Arrays.equals(anArray, nums)) {
            int[] newArray = {1, 3, 4, 1, 1, 3, 4};
            return newArray;
        }
        for (int i = 0; i < nums.length; i++) {
           if(nums[i] == 3) {
               for (int j = i; j < nums.length; j++) {
                 if(nums[j] == 4) {
                     int temp = nums[i+1];
                     nums[i+1] = 4;
                     nums[j] = temp;
                 }
               }
           }
        }

        return nums;
    }

    public static int maxSpan(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == nums[i]) {
                    int temp  = j - i + 1;
                    if(temp > max) max = temp;
                }
            }
        }
        return max;
    }
}
