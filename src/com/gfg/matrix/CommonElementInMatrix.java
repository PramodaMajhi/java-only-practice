package com.gfg.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CommonElementInMatrix {

    public static void main(String[] args) {
    int [][] matrix = {
                       {1, 2, 1, 4, 8},
                       {3, 7, 8, 5, 1},
                       {8, 7, 7, 3, 1},
                       {8, 1, 2, 7, 9},
                      };

        printCommonElements(matrix);
    }
    /*
    Given an MXN matrix, find all common elements present in all rows in O(mn) time
    and one traversal
    Output:
     1 8 or 8 1
     8 and 1 are present in all rows.
     */
    public static void printCommonElements(int[][] matrix) {
        Map<Integer,Integer>  hashmap = new HashMap<Integer,Integer>();
        int R = matrix.length;
        int C = matrix[0].length;
        // Initial first row goes to map
        for (int i = 0; i < C; i++) {
           // System.out.println(matrix[0][i]);
            hashmap.put(matrix[0][i], 1);
        }
        // traverse the matrix
        for (int i = 1; i < R ; i++) {
            for (int j = 0; j < C; j++) {
                // if element is present in map
                // and is not duplicated with current row element
                if(hashmap.get(matrix[i][j])!=null && hashmap.get(matrix[i][j]) == i){
                    // we increment count of the element in map by 1
                    hashmap.put(matrix[i][j], i+1);
                    if(i == R - 1) // last row
                        System.out.println(matrix[i][j]);
                }
            }
        }

    }
}
