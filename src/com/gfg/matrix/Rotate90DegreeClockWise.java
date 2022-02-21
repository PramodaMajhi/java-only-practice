package com.gfg.matrix;

import java.util.Arrays;

public class Rotate90DegreeClockWise {
    public static void main(String[] args) {
        int [][]matrix = {
                { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 9}

        };

        System.out.println(Arrays.deepToString(rotate90Clockwise(matrix)));

    }
/*
   It is similar to anti clock wise direction we already solved
   The only different is print the elements in cycle in clock wise
   direction i.e NxN matrix will have N/2 square cycles
   IDEA:
   For each square cycle,we swap the elements involved with the corresponding
   cell in the matrix in clockwise direction.
   Just need a temp variable
 */
    public static int[][] rotate90Clockwise(int[][]matrix) {
        int R = matrix.length;

        for (int i = 0; i < R/2; i++) {
            for (int j = i; j < R - i - 1; j++) {

                int top = matrix[i][j];
                // left -> top
                matrix[i][j] = matrix[R-j-1][i];
                // Right bottom -> left
                matrix[R-j-1][i] = matrix[R-i-1][R-1-j];
                // Right to bottom
                matrix[R-i-1][R-1-j] = matrix[j][R-i -1];
                // top ->right
                matrix[j][R-i-1] = top;
            }
        }
        return matrix;
    }
}
