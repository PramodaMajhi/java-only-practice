package com.gfg.matrix;

public class SpiralTraversalMatrix {
    public static void main(String[] args) {
        int[][]matrix = {
                {1,  2, 3,  4},
                {5,  6, 7,  8},
                {9,  10,11, 12},
                {13, 14,15, 16}
        };
        spiralTraversal(matrix);
    }
 /*
   Maintain 4 variables top,right, left and bottom
   1) First print top row, then increment top++
   2) Right to Bottom then right --
   3) Bottom to left(Reverse order) then bottom--
   4) left to top then left++

   1 2
   3 4
  */
    public static void spiralTraversal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = n -1;
        int bottom = m -1;

        // boundary check
        while (left <= right && top<=bottom){
            // Top -> Right
            for (int i = top; i <=right; i++) {
                System.out.print(matrix[top][i]+" ");
            }
            top++;
            // Right to Bottom
            for (int i = top; i <=bottom; i++) {
                System.out.print(matrix[i][right]+" ");
            }
            right --;
            if(top<=bottom) {
                // Bottom to left
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            if(left<=right) {
                // left to top
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
}
