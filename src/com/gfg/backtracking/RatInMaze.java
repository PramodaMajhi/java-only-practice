package com.gfg.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class RatInMaze {
    /*
        https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
        Output: DDRDRR DRDDRR
     */
    public static ArrayList<String> findPath(int [][]matrix) {
        ArrayList<String> res = new ArrayList<String>();
        int m = matrix.length;
        int n = matrix[0].length;
        // boolean [][]visited = new boolean[m][n];
        HashSet<String> visited = new HashSet<String>();
        helper(visited, res,matrix, 0, 0, "");
        return  res;
    }

    private static void helper(HashSet<String> visited, ArrayList<String> res,
                                            int[][] matrix, int row,
                                            int col, String str) {
            boolean inbounds =  0 <= row && row < matrix.length;
            boolean outbounds = 0 <= col && col < matrix[0].length;

            if(!inbounds || !outbounds)
                return;
            if(matrix[row][col] == 0)
                return;
            String pos = row + "," + col;
            if(visited.contains(pos))
                return;
            if(row == matrix.length -1  && col == matrix.length-1){
                res.add(str);
                str = "";
                return;
            }
              visited.add(pos);
              helper(visited,res, matrix, row-1, col, str+"U"); // up
              helper(visited,res, matrix, row+1, col, str+"D"); // down
              helper(visited,res, matrix, row, col-1, str+"L"); // left
              helper(visited, res, matrix, row, col+1, str+"R"); // right
              visited.remove(pos);
    }

    public static void main(String[] args) {
        int[][]matrix = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        System.out.println(findPath(matrix));
    }
}
