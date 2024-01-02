package com.gfg.dp;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int minfallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
             minfallingSum = Math.min(minfallingSum,helper(matrix,0, startCol));
        }
        return minfallingSum;
    }

    public int helper(int[][]matrix, int row, int col){
        /*
        Base case are follows
        1) The row or col values are not within the matrix boundaries.
        2) We have reached the last row. In this case, we will return
           the value of the current cell and not make any other recursive calls.
         */
        // check if we are out of the left or right boundary of the matrix
        if(col < 0 || col == matrix.length){
            return Integer.MAX_VALUE;
        }
        // check if we have reached the last row
        if(row == matrix.length -1){
            return matrix[row][col];
        }
        // calculate the minimum falling path sum starting from each
        // possible next steps
        int left = helper(matrix,row +1, col+1);
        int middle = helper(matrix, row +1, col);
        int right = helper(matrix, row+1, col - 1);
        return Math.min(left, Math.min(middle,right)) + matrix[row][col];
    }

    public static void main(String[] args) {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        int[][]matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum.minFallingPathSum(matrix));
    }
}
