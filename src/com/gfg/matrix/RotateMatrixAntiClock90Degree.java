package com.gfg.matrix;

import java.util.Arrays;

public class RotateMatrixAntiClock90Degree {
    public static void main(String[] args) {

        int[][]matrix = {
//                {1, 2, 3,  4},
//                {5, 6, 7,  8},
//                {9, 10,11,12},
//                {13,14,15,16}
                {1,2},
                {3,4}
              };
        System.out.println(Arrays.deepToString(rotateAntiClockWise90WithoutSpace(matrix)));
    }
    /*
    IDEA:
    Naive: If you notice the pattern
     last column become first row
     and second last column become second row and so on.
     4 8 12 16
     3 7 11 15
     2 6 10 14
     1 5 9  13
     Implementation:
     create a temp[][] and loop through and keep assigning
     Time Complexity would be O(n^2)
     Space: O(n)
    */
    public static int[][] rotate90(int [][]matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    temp[n-j-1][i] = matrix[i][j];
                    // (0,0) element placed in top left corner
                    // and so on to make last column to fist row
                }
        }
        return temp;
    }
    /*
        How to make O(1) space ?
        1) First transpose the matrix : 
            Swap upper half of the element with lower half without touching diagonal
        2) Reverse individual columns
        Time: O(n^2)
        Space: O(1)

 / An Inplace function to
// rotate a N x N matrix
// by 90 degrees in
// anti-clockwise direction
     */
    public static int[][] rotateAntiClockWise90WithoutSpace(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < n; j++) {
                swap(matrix, i, j);
            }
        }
  /*
     1 2
     3 4  => 1 3 => 2 4
             2 4    1 3
   */
        for (int i = 0; i < n ; i++) {
            int low = 0; int high = n -1;
            while (low < high) {
                swapCol(matrix, i, low, high);
                low++;
                high --;
            }
        }
        return matrix;
    }
    private static void swap(int [][]matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;

    }
    // swap columns
    private static void swapCol(int [][]matrix, int i , int low, int high) {
        int temp = matrix[low][i];
        matrix[low][i] = matrix[high][i];
        matrix[high][i] = temp;

    }
}
