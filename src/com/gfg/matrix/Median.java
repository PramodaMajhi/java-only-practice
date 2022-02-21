package com.gfg.matrix;

import java.util.Arrays;
import java.util.Comparator;

public class Median {
    public static void main(String[] args) {

        int[][] matrix = {
                {1,3,5}, {2,6,9}, {3,6,9}
        };


        System.out.println(medianOfSortedRowEfficient(matrix));
    }

    public static void medianOfSortedRow(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp[] = new int[m * n];
        int index = 0;
        //while()
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print(matrix[i][j] +" ");
                temp[index++] = matrix[i][j];
            }
        }
        Arrays.sort(temp);
        int median = temp.length / 2;
        System.out.println(temp[median]);
        //  return 0;
    }

    public static int medianOfSortedRowEfficient(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[0][C - 1];
        for (int i = 1; i < R; i++) {
            // Finding minimum element
            if (matrix[0][i] < min) {
                min = matrix[0][i];
            }
            ;
            // Finding max element
            if (matrix[i][C - 1] > max) {
                max = matrix[i][C - 1];
            }
        }
        int medianPos = (R * C + 1) / 2;

        while (min < max) {
            int mid = (min + max) / 2;
            int midPos = 0;
            // Find count of element smaller than mid
            for (int i = 0; i < R; i++) {
                // if element is not found in the binary search in the array
                // binarysearch() returns (-(insertion_point) -1)
                /*
                if element is found in the array it returns the
                index(any index in case of duplicate) ,
                so we go the last index of element which will give the number of
                element smaller than the number including the searched element
                 */
                int pos = Arrays.binarySearch(matrix[i], mid) + 1;
                midPos += Math.abs(pos);
            }
            if (midPos < medianPos) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
