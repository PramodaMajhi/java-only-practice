package com.gfg.matrix;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int [][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };
        TransposeMatrix(matrix);
        System.out.println(Arrays.deepToString(transposeEfficient(matrix)));
    }

    /*
      Transpose Efficient
      IDEA: will swap the upper half  with lower half elements
      without touching diagonal elements
     */
    public static int[][] transposeEfficient(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i<m ; i++) {
            for (int j = i+1; j<n ; j++) {
                swap(matrix, i,j);
            }
        }
        return matrix;
    }
    private static void swap(int [][]matrix, int i, int j) {
        int temp  = matrix[i][j];
           matrix[i][j] = matrix[j][i];
           matrix[j][i] = temp;
    }

    /*
        Transpose matrix means, row become column
        Idea: Naive
        Create a temp[][] and copy tem[i][j] = matrx[j][i]
        then copy back to main array to transpose
     */
    public static void TransposeMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[j][i];
            }
        }

        // just use temp array instead of original one
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(temp[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
