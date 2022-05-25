package com.gfg.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i <envelopes.length ; i++) {
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }

    public int lengthOfLIS(int[] nums) {
        int[]dp = new int[nums.length];
        int len  = 0;
        for(int num: nums){
            int i = Arrays.binarySearch(dp, 0 , len, num);
            if(i < 0){
                i = -(i+1);
            }
            dp[i] = num;
            if(i == len){
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
          int[][]envelopes = {{5,4},{6,4},{6,7},{2,3}};
         // int[][]envelopes = {{1,1},{1,1},{1,1}};
        //int[][]envelopes = {{2,3},{5,4},{5,6},{6,5}};
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        int ans = maxEnvelopes.maxEnvelopes(envelopes);
        System.out.println(ans);
    }
}
