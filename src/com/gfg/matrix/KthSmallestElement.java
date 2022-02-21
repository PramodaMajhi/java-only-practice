package com.gfg.matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyHeapNode {
    int row;
    int col;
    int val;

    public MyHeapNode(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}

class  MyHeapComparator implements Comparator<MyHeapNode> {

    @Override
    public int compare(MyHeapNode x, MyHeapNode y) {
        return  x.val - y.val;
    }
}

public class KthSmallestElement {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int k = 2;
        System.out.println(kthSmallestUsingHeap(matrix, k));
    }
/*
      1) Initialize min Heap,
      2) We can treat each column as individual list, since column are sorted
      3) Each code will contain triplet information, The value, column and row position,
         this will help us to move forward with the next replacement of the matrix in case popped off
      4) Our Heap contains min(N, K), start a loop  for the first column until we iterate over k elements
      5) At each step,we remove min element from the heap, The element will tell us which row should
         be further consumed.(r, c+1)
      6) keep iterating till, we exhaust k elements. The last element to be popped at the end
         of the loop will be Kth the smallest element
 */
    public static  int kthSmallestUsingHeap(int [][]matrix, int k) {
        int N = matrix.length;
        PriorityQueue<MyHeapNode> minHeap =
                new PriorityQueue<MyHeapNode>(Math.min(N, k), new MyHeapComparator());
        // preparing min heap
        for(int row = 0; row < Math.min(N,k); row ++) {
            // We add triplets of information for each cell
            minHeap.add(new MyHeapNode(row, 0, matrix[row][0]));
        }
        MyHeapNode element  = minHeap.peek();

        while (k-- > 0) {

            // Extract-min
            element = minHeap.poll();
            int r  = element.getRow();
            int c = element.getCol();
            // if we have any element in the current row, add them
            if(c < N-1) {
                minHeap.add(new MyHeapNode(r, c +1, matrix[r][c+1]));
            }
        }
        return element.getVal();

    }

    /*
    Given an N x N matrix, where every row and column is sorted in non-decreasing order.
    Find the kth the smallest element in the matrix.
    Explanation: 27 is the 3rd smallest element.
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int index = 0;
        int[] temp = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[index++] = matrix[i][j];
            }
        }
        Arrays.sort(temp);

        return temp[k - 1];
    }
}
