package com.gfg.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
       int heights[] = {3,0,0,2,0,4};
      //  Output: 10
        System.out.println(trappingWater(heights));
        System.out.println(trappingWaterEfficient(heights));
    }
    /*
        O(n^2) solution
        Calculate lmax and rmax for each element
     */
    public static long trappingWater(int heights[]) {
        long water = 0;
        // first and last bar must be ignored for calculation
        // for left bar there is nothing to support from left side
        // Similarly, for right bar there is nothing to support from right side
        for (int i = 1; i < heights.length -1 ; i++) {
           int lmax = heights[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, heights[j]); // left max
            }
            int rmax = heights[i];
            for (int j = i+1; j < heights.length; j++) {
                rmax = Math.max(rmax, heights[j]); //right max
            }
            // calculating water
            water+= Math.min(lmax, rmax) - heights[i];
        }
        return water;
    }
    /*
       IDEA: Precompute lmax and rmax,
       Time: O(n)
       Space: O(n)
     */
    public static long trappingWaterEfficient(int heights[]) {
        long water = 0;
        int len = heights.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = heights[0]; // Initialize the lmax
        // check if current height is greater than the lmax
        // then update lmax
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(heights[i], lmax[i-1]);
        }
        // we need traverse from right side to build rmax,
        // We need rmax from right side
        rmax[len -1] = heights[len -1];
        for (int i = len -2; i >=0 ; i--) {
            // compare heights[i] and rmax[i+1]
            rmax[i] = Math.max(heights[i], rmax[i+1]);
        }
        // calculate water
        for (int i = 1; i <len ; i++) {
            water+= Math.min(lmax[i], rmax[i]) - heights[i];
        }

        return water;
    }
}
