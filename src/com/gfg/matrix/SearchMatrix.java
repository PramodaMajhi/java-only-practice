package com.gfg.matrix;

public class SearchMatrix {


    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int x = 29;
        System.out.println(searchMatrix(matrix,x));
    }
    /*
        IDEA: Naive approach to traverse row and column wise
        and match with target with O(MXN)
        Efficient solution is binary search because matrix is
        sorted, where to start?
        1) Begin from the top right corner
        2) If target is matches then we found
        3) If target is smaller move left
        4) If target is greater, move down
        Time: O(R+C)
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int j = n -1; // Top right corner
        int i  = 0; // First row
        while(i < n && j >=0) {

            if(matrix[i][j] == target){
                System.out.println(i+","+j);
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
