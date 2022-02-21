package com.SDEPractice;

public class Jan17 {


    public static int maxArea(int[] height) {
        /**
         * IDEA :
         * 1) Using two pointers, we need pick first and last element to calculate the
         * widest container
         * 2) All other containers are less wide and thus would need a higher in order to hold
         *    more water
         * 3) The smaller one of the first and last line does not support a higher
         *    water level so can be ignored
         *  Note: formula to calculate
         *  water = Max(water, currentWater)
         *  currentWater = height * length
         *  height = Min(left, right)
         *  length  = right - left
         */
        int i = 0;
        int j = height.length -1;
        int water = 0;
        while (i < j) {
            water = Math.max(water, Math.min(height[i], height[j])* (j - i));
            if(height[i] > height[j]) j--;
            else i++;
        }
        return water;
    }
}
