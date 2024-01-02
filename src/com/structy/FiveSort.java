package com.structy;

import java.util.Arrays;

public class FiveSort {
    public int[] fiveSort(int[]nums){
        int i = 0;
        int j = nums.length -1;
        while(i < j) {
            while (j >=0 && nums[j]==5){
                j--;
            }
            if(nums[i] == 5){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
            i++;
        }
        return nums;
    }

    public static void main(String[] args) {
        FiveSort fiveSort = new FiveSort();
        int[]nums= {5, 5, 6, 5, 5, 5, 5};
        System.out.println(Arrays.toString(fiveSort.fiveSort(nums)));
    }
}

