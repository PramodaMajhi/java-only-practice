package com.gfg.matrix;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int [][]matrix={
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}
        };
        System.out.println(Arrays.deepToString(sortedMatrix(matrix)));

    }
    public static int[][] sortedMatrix(int matrix[][]) {
        int R = matrix.length;
        int C = matrix[0].length;
        int temp[] = new int[R*C];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[index++] = matrix[i][j];
            }
        }
        Arrays.sort(temp);
        index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = temp[index++];
            }
        }
        return matrix;
    }
}
