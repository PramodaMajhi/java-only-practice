package com.SDEPractice;

import java.util.Arrays;

public class Feb9 {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };
        System.out.println(cherryPickUpTopDown(grid));
    }
    /*
    We need to move the robots synchronously,
    Robot 1 and Robot 2 will be always on the same row, therefore row = row1
    dp state, (row, col1, col2)
     */

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];

        for (int row = m - 1; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int result = 0;
                    // current cell
                    // Collect the cherry at (m, col1) and (m, col2).
                    // Do not double count if col1 == col2.
                    result += grid[row][col1];
                    if (col1 != col2) {
                        result += grid[row][col2];
                    }
                    // transition
                    //If we are not in the last m, we need to add the maximum
                    // cherries we can pick in the future.
                    if (row != m - 1) {
                        int max = 0;
                        //  The maximum cherries we can pick in the future is the
                        //  maximum of dp[m+1][new_col1][new_col2], where new_col1
                        //  can be col1, col1+1, or col1-1, and new_col2 can be col2,
                        //  col2+1, or col2-1
                        for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                            for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                                if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                                    max = Math.max(max, dp[row + 1][newCol1][newCol2]);
                                }
                            }
                        }
                        result += max;
                    }
                    dp[row][col1][col2] = result;
                }
            }
        }
        return dp[0][0][n - 1];
    }

    public static int cherryPickUpTopDown(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // row, col1, col2
        int dpcache[][][] = new int[m][n][n];

        // initialize all elements to -1;
        for (int row[][] : dpcache) {
            for (int[] col1 : row) {
                Arrays.fill(col1, -1);
            }
        }
        return dp(0, 0, n - 1, grid, dpcache);
    }

    private static int dp(int row, int col1, int col2, int[][] grid, int[][][] dpCache) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }
        // check cache
        if (dpCache[row][col1][col2] != -1) {
            return dpCache[row][col1][col2];
        }
        // current cell
        int result = 0;
        result += grid[row][col1];
        // Collect the cherry at (row, col1) and (row, col2). Do not double count if col1 == col2.
        if (col1 != col2) {
            result += grid[row][col2];
        }
        // transition
        // If we do not reach the last row, we need to add the maximum cherries we can pick in the future.
        if (row != grid.length - 1) {
            int max = 0;
            //The maximum cherries we can pick in the future is the
            // maximum of dp(row+1, new_col1, new_col2)
            for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                    max = Math.max(max, dp(row + 1, newCol1, newCol2, grid, dpCache));
                }
            }
            result += max;
        }

        dpCache[row][col1][col2] = result;
        return result;
    }
}
