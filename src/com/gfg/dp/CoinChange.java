package com.gfg.dp;

public class CoinChange {

    public static void main(String[] args) {
        int[]coins = {2,5,3,6};
        int sum = 10;
        System.out.println(getCount(coins, sum));
        System.out.println(getCountDp(coins, sum));
    }


    public static int getCountDp(int[] coins, int sum) {
        int n = coins.length;
        int dp[][] = new int[sum+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        // It should begin from second row.
        for (int i = 1; i <=n ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <=sum; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] = dp[i][j-1]; // does not include
               if(coins[j-1] <= i) {
                   dp[i][j]+=dp[i- coins[j-1]][j];
               }
            }
        }

        return dp[sum][n];
    }
    /*
        coins[] = {2,5,3,6}, sum = 10;
        O/P: 5
        10 = 5 + 5
        10 = 2 + 2 + 6
        10 = 2 + 3 + 5
        10 = 2 + 2 + 3 + 3
        10 = 2+2+2+2+2
     */

    public static int getCount(int[] coins, int sum) {

        return helper(coins, coins.length, sum);
    }


    private static int helper(int[]coins, int len, int sum) {


        // if sum is 0 then there is 1 solution
        // do not include any coin
        if(sum == 0) return 1;

        // if sum < 0 then there is no solution exits
        if(sum < 0) return 0;
        // if there are no coin and sum is greater than 0
        // then no solution exist
        if(len<=0 && sum >= 1) return 0;
           return helper(coins, len - 1, sum)+ // does not exclude
                     helper(coins, len, sum - coins[len-1]); // include
    }

}
