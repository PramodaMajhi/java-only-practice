package com.FourteenDaysStudyPlan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day7DFS {
    public static void main(String[] args) {
        int [][]image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        //System.out.println(Arrays.deepToString(floodFill(image,sr,sc,newColor)));
        int [][]grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland1(grid));
    }

    public static int maxAreaOfIslandIterative(int[][] grid) {
        boolean [][] visited;
        int maxArea = 0;
        int m = grid.length;
        int n  = grid[0].length;
        visited  = new boolean[m][n];
        for (int r = 0; r < m ; r++) {
            for (int c = 0; c <n; c++) {
                if(grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid,r,c,visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    /**
     Time Complexity: O(R*C) where R is the number of rows in the given grid
     and C is the number of column in the grid
     we visited per square
     Space Complexity : O(R*C) the space used by visited to keep track of visited squares
     and the space used by the call stack during recursion
     */
    public static int maxAreaOfIsland1(int[][] grid) {
        boolean [][] visited;
        int maxArea = 0;
        int m = grid.length;
        int n  = grid[0].length;
        visited  = new boolean[m][n];
        for (int r = 0; r < m ; r++) {
            for (int c = 0; c <n; c++) {
                if(grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid,r,c,visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][]grid, int row, int col, boolean[][] visited) {
        if(     row < 0
                || col < 0
                || row >= grid.length
                || col >=grid[0].length
                || grid[row][col]!= 1
                || visited[row][col])
        {
            return 0;
        }
        visited[row][col] = true;
        int count = 1;
            count+= dfs(grid, row-1, col, visited);
            count+= dfs(grid, row+1, col, visited);
            count+= dfs(grid, row, col-1, visited);
            count+= dfs(grid, row, col+1, visited);
        return count;
    }


    /**
     695. Max Area of Island
     You are given an m x n binary matrix grid.
     An island is a group of 1's (representing land)
     connected 4-directionally (horizontal or vertical.)
     You may assume all four edges of the grid are surrounded by water.
     The area of an island is the number of cells with a value 1 in the island.
     Return the maximum area of an island in grid. If there is no island, return 0.

     */
    public static int maxAreaOfIsland(int[][] grid) {

        if(grid.length == 0) return  0;
        Set<String> visited = new HashSet();
        int minSize = 0;
        for (int row = 0; row<grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                  int size =  explore(grid,row,col,visited);
                  if(size > minSize) {
                      minSize = size;
                  }
            }
        }
        return  minSize;
    }

    private static int explore(int[][] grid, int row, int col, Set<String> visited) {

        boolean rowInbounds = (0 <= row ) && (row < grid.length);
        boolean colInbounds = (0 <=col) && (col < grid[0].length);
        if(!rowInbounds || !colInbounds) return  0;
        if(grid[row][col] == 0) return 0;
        String pos = new Integer(row).toString() +"," + new Integer(col).toString();
        if(visited.contains(pos)) return  0;
        visited.add(pos);
        int size = 1;
        size+=explore(grid,row-1, col, visited);
        size+=explore(grid,row+1, col, visited);
        size+=explore(grid,row, col-1, visited);
        size+=explore(grid,row, col+1, visited);
        return size;
    }
    /*
    Algorithm
    Say color is the color of the starting pixel. Let's floodfill the starting pixel:
    we change the color of that pixel to the new color, then check the 4 neighboring
    pixels to make sure they are valid pixels of the same color, and of the valid ones,
    we floodfill those, and so on.
    We can use a function dfs to perform a floodfill on a target pixel.

    Time complexity: O(n) where n is the number of pixel in the image,
    we might process every pixel
    Space Complexity: O(n) the size of the implicit call stack when calling dfs
    https://www.youtube.com/watch?v=g6HzWspalpU
     */
    public static  int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldcolor = image[sr][sc];
        if(oldcolor!=newColor) {
            dfs(image, sr,sc,oldcolor,newColor);
        }

        return image;
    }

    private static void dfs(int[][]image, int row, int col, int oldcolor, int newcolor) {
        if(row >= image.length ||
           col >=image[0].length ||
           row < 0 ||
           col<0 || image[row][col]!=oldcolor)
          return;
        if(image[row][col] == oldcolor) {
            image[row][col] = newcolor;
            dfs(image,row-1,col,oldcolor, newcolor);
            dfs(image,row+1,col,oldcolor, newcolor);
            dfs(image,row,col-1,oldcolor, newcolor);
            dfs(image,row,col+1,oldcolor, newcolor);
        }
    }
}
