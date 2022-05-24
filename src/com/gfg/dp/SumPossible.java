package com.gfg.dp;

import java.util.HashMap;
import java.util.Map;

/*
a = amount
n = length of numbers
Time: O(a*n)
Space: O(a)
 */
public class SumPossible {
    public boolean sumPossible(int amount, int[] numbers) {
        Map<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
        return helper(amount, numbers, hashMap);
    }
    public boolean helper(int amount, int[]numbers, Map<Integer, Boolean> hashMap){
        if(amount < 0)
            return false;
        if(amount == 0)
            return true;
        if(hashMap.containsKey(amount))
            return hashMap.get(amount);
        boolean result = false;
        for(int num: numbers) {
             result = helper(amount - num, numbers, hashMap);
        }
        hashMap.put(amount, result);
        return result;
    }

    public static void main(String[] args) {
        int amount = 13;
        int[]numbers = {6, 2, 1};
        SumPossible sumPossible = new SumPossible();
        boolean ans  = sumPossible.sumPossible(amount, numbers);
        System.out.println(ans);

    }
}
