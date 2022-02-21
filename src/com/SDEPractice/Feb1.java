package com.SDEPractice;

import java.util.logging.SocketHandler;

public class Feb1 {
    public static void main(String[] args) {
       int[][] grid = {
                       {1,1,1,1,1,1,1,0},
                       {1,0,0,0,0,1,1,0},
                       {1,0,1,0,1,1,1,0},
                       {1,0,0,0,0,1,0,1},
                       {1,1,1,1,1,1,1,0}
                      };
       // int[][] grid = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        System.out.println(closedIsland(grid));
    }

    /*

    1254. Number of Closed Islands
    Input: grid = [
                   [0,0,1,0,0],
                   [0,1,0,1,0],
                   [0,1,1,1,0]
                  ]
    Output: 2
    Explanation:
    Islands in gray are closed because they are completely surrounded by
    water (group of 1s).
    */

    /*
         IDEA: DFS Solution, loop through row and column
         if you grid[row][col] == 0 then call dfs function and
         First, we need to remove all land connected to the edges using flood fill.
         Then, we can count and flood-fill the remaining islands
         return true if found grid[row][col] == 1 ,
         Definitely, we need to check row and col should not be out of bounds
         boolean rowInbounds = 0 <=row && row < grid.length;
         boolean colInbounds = 0 <=col && col < grid[0].length;

         Important point to keep in mind, check if dfs is returning true
         boolean result = true;
         result = result && dfs(grid, row - 1, col);
         IMPORTANT NOTE:
         BECAUSE IF ANY OF THE FIRST DFS() RETURNS FALSE, FOLLOWING ONES WILL NOT EXECUTE!!! THEN WE DON'T
         HAVE THE CHANCE TO MARK THOSE 0s TO 1s!!!

     */
    public static int closedIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int count = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 0) {
                    if (dfs(grid, row, col))
                        count++;
                }
            }
        }
        return count;
    }

    public static boolean dfs(int[][] grid, int row, int col) {
        boolean rowInbounds = 0 <= row && row < grid.length;
        boolean colInbounds = 0 <= col && col < grid[0].length;
        if (!rowInbounds || !colInbounds)
            return false;
        if (grid[row][col] == 1)
            return true;
        grid[row][col] = 1;
        boolean result = true;
        result = result && dfs(grid, row - 1, col);
        result = result && dfs(grid, row + 1, col);
        result = result && dfs(grid, row, col - 1);
        result = result && dfs(grid, row, col + 1);
        return result;
    }
}
