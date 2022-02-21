package com.SDEPractice;

import java.util.Arrays;

public class Jan11 {

    public static void main(String[] args) {
        int []piles = {2,4,1,2,7,8};
        System.out.println(maxCoins(piles));
    }
    /*
    1561. Maximum Number of Coins You Can Get
    There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:
    In each step, you will choose any 3 piles of coins (not necessarily consecutive).
    Of your choice, Alice will pick the pile with the maximum number of coins.
    You will pick the next pile with the maximum number of coins.
    Your friend Bob will pick the last pile.
    Repeat until there are no more piles of coins.
    Input: piles = [2,4,1,2,7,8]
    Output: 9
     */

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        // [1,2,2,4,7,8]
        int sum = 0;
        int i = piles.length - 2 ; // picking from the last, in this case second last
        int n  = piles.length/3;   // we are giving the largest one to alice.
        int j = 0;
        while(j++ < n) {
             sum+=piles[i];
             i-=2;
        }
       return sum;
    }
}
