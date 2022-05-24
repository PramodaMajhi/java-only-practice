package com.gfg.dp;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 a = amount
 c = # coins
 Time: O(a*c)
 Space: O(a)
 */
public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int answer = helper(coins, amount, hashMap);
        return answer == Integer.MAX_VALUE ? -1 : answer; // returning -1 if it is not possible

    }

    private int helper(int[] coins, int amount, Map<Integer, Integer> hashMap) {
        if (amount < 0)
            return Integer.MAX_VALUE; // discarding -ve value
        if (amount == 0)
            return 0;
        if(hashMap.containsKey(amount)) // Checking in memo
            return hashMap.get(amount);
        int minCoins = Integer.MAX_VALUE;
        for (int coin:coins) {
            int numOfCoins = helper(coins, amount - coin, hashMap);
            if(numOfCoins != Integer.MAX_VALUE){ // if it is not infinity
                // In java adding one two infinity it becomes negative infinity
                // hence checking before adding +1 to it. otherwise, I could write
                //  int numOfCoins = 1+ helper(coins, amount - coin, hashMap);
                minCoins = Math.min(minCoins, numOfCoins+1); // adding +1 for self
            }
        }
        hashMap.put(amount, minCoins);
        return hashMap.get(amount);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3,4};
        int amount = 4;
        CoinChange322 coinChange322 = new CoinChange322();
        int min = coinChange322.coinChange(coins, amount);
        System.out.println(min);
    }
}
