package com.gfg.matrix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][]matrix = {
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };

        System.out.println(maxSizeRectangle(matrix));

    }

    private static int maxHist(int[] row){
        int n = row.length;
        Stack<Integer> stack = new Stack<Integer>();
        // As we are getting array elements we can't store values
        // because we need find the index for a particular value present in the stack.
        // we will be storing indices instead of value
         stack.push(-1); // first entry
        // First thing we need to make sure is all the indices
        // that actually goes into the stack, the height for them is increasing order
        int maxArea = 0;
        for (int i = 0; i <n ; i++) {
            //{0,1,1,0},
            while (stack.peek()!=-1 && row[stack.peek()] >= row[i]) { //  not increasing order
                // in this case we will be popping out from the stack
                int currentHeight  = row[stack.pop()];
                int currentWidth = (i - stack.peek() -1); // exclude both extreme ends
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        // The case that we are left with in case the stack is not empty

        while(stack.peek()!=-1) {
            int currentHeight  = row[stack.pop()];
            int currentWidth = (n - stack.peek() -1);
            // n is going to be the right most limit for all the elements
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;
    }
/*
   Algorithm
   1) Run a loop to traverse through the rows
   2) Now, if the current rows is not the first row then update the rows as follows
    if matrix[i][j] = matrix[i-1][j]+matrix[i][j]
   3) Find the maximum rectangle area under the histogram, consider the ith row as
      heights of bars of a histogram
   4) Repeat above two steps for all rows and print maximum area of all the rows
 */
    public static int maxSizeRectangle(int[][] matrix) {
        // Calculate area for first row and initialize it as result
        int R = matrix.length;
        int C = matrix[0].length;
        // Get the max area of histogram of first row

        int area = maxHist(matrix[0]);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // if A[i][j] is 1 then add A[i -1][j]
                    if(matrix[i][j] == 1) {
                        matrix[i][j] = matrix[i-1][j] + matrix[i][j];
                    }
            }
            // Update result if area with current row (as
            // last row of rectangle) is more
            area = Math.max(area, maxHist(matrix[i]));
        }
        return area;
    }

    // Before I solve max area in a rectangle, I need to solve this problem
   // https://leetcode.com/problems/largest-rectangle-in-histogram/
    // 84. Largest Rectangle in Histogram
    // This is TLE Solution
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
                int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                    minHeight = Math.min(minHeight, heights[j]);
                    int width = (j - i + 1);
                    maxArea = Math.max(maxArea, minHeight * width);
            }
        }
        return maxArea;
    }
    public static int largestRectangleAreaStack(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek()!=-1 && heights[stack.peek()] >= heights[i]) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = (i - stack.peek() -1);
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int currentHeight = heights[stack.pop()];
            int currentWidth = (n - stack.peek() -1);
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }

}
