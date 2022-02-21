package com.gfg.dp;

import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(longestCommonSubSeq(str1, str2));
        System.out.println(lcsTabulation(str1, str2));
    }

    public static int longestCommonSubSeq(String s1, String s2) {
        // if there is no common subsequence. then its zero
        int memo[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int count = 0;
        // count  = helper(s1, s2, s1.length(), s2.length());
        count = helperDp(s1, s2, s1.length(), s2.length(), memo);
        return count;
    }

    private static int helper(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + helper(s1, s2, m - 1, n - 1);
        else {
            return Math.max(helper(s1, s2, m - 1, n), helper(s1, s2, m, n - 1));
        }
    }

    private static int helperDp(String s1, String s2, int m, int n, int memo[][]) {
        if (memo[m][n] != -1) return memo[m][n];
        if (m == 0 || n == 0) {
            return memo[m][n] = 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + helperDp(s1, s2, m - 1, n - 1, memo);
        else {
            memo[m][n] = Math.max(helperDp(s1, s2, m - 1, n, memo), helperDp(s1, s2, m, n - 1, memo));
        }
        return memo[m][n];
    }

    private static int lcsTabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
//        for (int i = 0; i<=m; i++) {
//                dp[i][0] = 0;
//            }
//        for (int j = 0; j<=n; j++) {
//                dp[0][j] = 0;
//        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    // filling first row and column to accommodate "" string
                    // Because we know it does not match
                    // we need something to fill when (m && n == 0)
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
