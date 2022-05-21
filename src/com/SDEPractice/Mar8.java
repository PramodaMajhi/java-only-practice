package com.SDEPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Mar8 {
    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};
        System.out.println(increasingTriplet(nums));
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        List<String> list = Arrays.asList(wordDict);
        System.out.println(wordBreak(s, list));
    }

    /*
       139. Word Break
       Input: s = "leetcode", wordDict = ["leet","code"]
       Output: true
   */
    public static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<String>(wordDict), 0);
    }

    private static boolean helper(String s, HashSet<String> hashSet, int start) {
        if (start == s.length()) return true;
        for (int i = start + 1; i <= s.length(); i++) {
             String newS = s.substring(start, i);
               System.out.println(newS);
            if (hashSet.contains(newS) && helper(s, hashSet, i))
                return true;
        }
        return false;
    }

    /*
    334. Increasing Triplet Subsequence
     */
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else return true;
        }
        return false;
    }
}
