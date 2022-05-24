package com.gfg.dp;

import java.util.*;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String,Integer> memo  = new HashMap<>();
            return helper(strs, m, n, 0, memo);
    }
    public int helper(String[] str, int zeros, int ones, int index, Map<String,Integer> memo) {
        if(str.length == index || zeros+ones == 0 )
            return 0;
        String key = zeros+"->"+ones+"->"+index;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int[]count1s0s = getCount1s0s(str[index]);
        // let's consider change of zeros and ones. as we are going to use.
        // we need subtract from the original value
        int consider = 0;
        int max = 0;
        if(zeros >= count1s0s[0] && ones >= count1s0s[1]){
            consider = 1 + helper(str, zeros-count1s0s[0], ones - count1s0s[1], index +1, memo);
        }
        int skip   = helper(str, zeros, ones , index +1, memo);
        max = Math.max(consider, skip);
        memo.putIfAbsent(key, max);
        return max;
    }

    private int[] getCount1s0s(String s) {
        int[]count = new int[2];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5, n = 3;
        int ans = findMaxForm.findMaxForm(strs, m, n);
        System.out.println(ans);

    }
}
