package com.gfg.dp;

import java.util.Arrays;

/*
https://leetcode.com/problems/longest-palindromic-subsequence/
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        // Make the memo big enough to hold the cases where the pointers
        // go over the edges of the strings.
        String text1 = s;
        String text2 = new StringBuilder(s).reverse().toString();
        int memo[][] = new int[text1.length()+1][text2.length()+1];
        // We need to initialise the memo array to -1's so that we know
        // whether or not a value has been filled in. Keep the base cases
        // as 0's to simplify the later code a bit.
        for (int[]row: memo) {
            Arrays.fill(row, -1);
        }

        int count = 0;
        count  = helperDp(text1, text2, text1.length(), text2.length(), memo);
        return count;
    }

    private static int helperDp(String s1, String s2, int m, int n, int memo[][]) {
        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if(memo[m][n]!= -1)
            return memo[m][n];
        if(m == 0 || n == 0) {
            return  memo[m][n] = 0;
        }

        if(s1.charAt(m-1) == s2.charAt(n-1))
            memo[m][n] =  1 + helperDp(s1,s2, m-1, n-1, memo);
        else {
            memo[m][n] =  Math.max(helperDp(s1,s2, m-1, n, memo), helperDp(s1,s2, m, n-1,memo));
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        int ans = longestPalindromeSubseq.longestPalindromeSubseq("bbbab");
        System.out.println(ans);

    }

}
