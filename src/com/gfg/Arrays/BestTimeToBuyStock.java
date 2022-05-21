package com.gfg.Arrays;

public class BestTimeToBuyStock {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 8, 12};
        System.out.println(maxProfit(arr, 0, arr.length-1));
        System.out.println(maxProfit(arr));
    }

    /**
     * Naive Approach
     IDEA: Recursively consider every pair i and j such that i < j
     */
    public static int maxProfit(int[] price, int start, int end) {

        if(end <= start) // only single element base condition
            return 0;
        int profit = 0;

        for (int i = start; i < end; i++) {
            for (int j = i+1; j <= end; j++) {
                if(price[j] > price[i]) {
                    int curr_profit = price[j] - price[i] +
                                      maxProfit(price, start, i-1) + // left of i
                                      maxProfit(price, j+1 , end);  // right of j
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }/*

    /**
        O(N) solution
        IDEA: find the bottom and top point, when it reaches bottom point
        will buy the stock, and when its reaches the peek will sell
        In order to find peek and valley, we can check previous element to see
        if it is greater or not and keep adding profit
        // Kadane also work
    */
    public static int maxProfit(int[] price) {
        int profit = 0;
        for (int i = 1; i < price.length; i++) {

            if(price[i] > price[i-1]) {
                profit+=(price[i]  - price[i-1]);
            }
        }
        return profit;
    }
}
