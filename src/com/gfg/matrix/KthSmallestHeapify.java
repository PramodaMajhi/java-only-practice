package com.gfg.matrix;


public class KthSmallestHeapify {
   private  static class HeapNode {
    int val;
    int row;
    int col;
        HeapNode(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
       int N = matrix.length;
       // K must
       if(k < 0 && k >= N*N){
         return Integer.MAX_VALUE;
       }
       // create a min heap of elements from first
       // row of 2D matrix
       // Can we crate a min heap size instead on N.Math.min(N, K) ?
       HeapNode[] heapArr  = new HeapNode[N];
        for (int i = 0; i < N; i++) {
            heapArr[i] = new HeapNode(matrix[0][i], 0, i);
        }
        // Build heap
        HeapNode hr  = new HeapNode(0,0,0); // Empty object
        for (int i = 1; i <= k; i++) {
            // Get the current heap root
            hr = heapArr[0];
            // Get next value from column root's value.
            // If the value stored at root was last value in its column
            // the Assign infinite as last value
            int nextVal = hr.row < N-1 ? matrix[hr.row+1][hr.col] : Integer.MAX_VALUE;
            // Update heap root with next value
            heapArr[0] = new HeapNode(nextVal, hr.row+1, hr.col);
            minHeapify(heapArr, 0 , N);
        }
       return hr.val;
    }

    private static void minHeapify(HeapNode[] heapArr, int i, int heapSize)
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest  = i;

        if(left < heapSize && heapArr[left].val < heapArr[i].val) {
            smallest = left;
        }
        if(right < heapSize && heapArr[right].val < heapArr[smallest].val) {
            smallest = right;
        }
        if(smallest!= i) {
            swap(i, smallest, heapArr);
            minHeapify(heapArr,smallest, heapSize);
        }
    }
    private static void swap(int i, int smallest, HeapNode[]arr) {
       HeapNode temp  = arr[i];
       arr[i] = arr[smallest];
       arr[smallest] = temp;
    }
    public static void main(String[] args) {
        int matrix[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 25, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };
        int k = 3;
        int res = kthSmallest(matrix, k);
        System.out.println(res);
    }
}
