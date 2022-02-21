package com.gfg.matrix;

public class PrintBoundary {

    public static void main(String[] args) {
        int [][] matrix = {
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9,10,11,12},
                            {13,14,15,16}
                        };
       // printBoundary(matrix);
        printBoundaryRightToleft(matrix);
    }
    /*
    Time: O(R+C)
     */
    public static void printBoundaryRightToleft(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

       // Only single row
       if(R == 1) {
           for (int i = 0; i < C; i++) {
               System.out.print(matrix[0][i] + " ");
           }
       }
       // Single column
       else if(C == 1) {
           for (int i = 0; i < R; i++) {
               System.out.print(matrix[i][0] + " ");
           }
       }
       else {
           for (int i = 0; i < C; i++) {
               System.out.print(matrix[0][i] + " ");

           }
           //System.out.println("");
           for (int i = 1; i < R ; i++) {
               System.out.print(matrix[i][C-1] + " ");
           }
           //System.out.println("");
           for (int i = C-2; i >=0; i--) {
               System.out.print(matrix[R-1][i] + " ");
           }
          // System.out.println("");
           for (int i = R-2; i >=1 ; i--) {
               System.out.print(matrix[i][0] + " ");
           }
           System.out.println();
       }

    }
    /*
        Print Boundary elements
     */
    public static void printBoundary(int[][] matrix) {
        int M  = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {

            for (int j = 0; j < N; j++) {
                if(i == 0){
                    System.out.print(matrix[i][j] + " ");
                }
                else if(i == M-1){
                    System.out.print(matrix[i][j] + " ");
                }
                else if(j == 0) {
                    System.out.print(matrix[i][j] + " ");
                }
                else if(j == N -1) {
                    System.out.print(matrix[i][j] + " ");
                }
                else
                    System.out.print("");
            }
            System.out.println("");
        }

    }
}
