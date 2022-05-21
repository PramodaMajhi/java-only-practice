package com.SDEPractice;

import java.util.Arrays;

public class Feb23 {
    public static void main(String[] args) {
       // int[][] matrix = {{1,0,1},{0,-2,3}};
        int [][] matrix = {{2,2,-1}};
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix, k));
       int[] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }
/*
1346. Check If N and Its Double Exist
 */
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
          int res =   binarySearch(arr, arr[i]*2);
          if(res!=0 && res >= 0) {
              return true;
          }
        }
        return false;
    }

    private static int binarySearch(int[] arr, int x) {
        int low  = 0 ;
        int high  = arr.length;

        while (low < high) {
            int mid = (low + high) / 2 ;
            if(arr[mid] == x) return mid;
            else if( x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return  -1;
    }
/*
  363. Max Sum of Rectangle No Larger Than K

 */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int R = matrix.length;
        int C = matrix[0].length;

        int ans = 0;
        for (int i = 0; i < R; i++) {
            int sum = 0;
            for (int j = 0; j < C; j++) {
                sum+= matrix[i][j];
            }
            ans = Math.max(sum, ans);
        }
        if(ans <= k)
            return ans;
        return ans;
    }
}
