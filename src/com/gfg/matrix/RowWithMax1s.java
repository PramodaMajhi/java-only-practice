package com.gfg.matrix;

public class RowWithMax1s {
    public static void main(String[] args) {
        int matrix[][] = {
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };
        System.out.println(rowWithMax1s(matrix));
    }
/*

 */
   public static int rowWithMax1s(int matrix[][]) {
       int R = matrix.length;
       int C = matrix[0].length;
       int max = -1;
       int ans = 0;
       // Traverse for each row and count number of 1s
       // finding the index of first 1
       int index;
       for (int i = 0; i < R; i++) {
            index = first(matrix[i], 0, C-1);
            if(index!=-1 && C-index > max){
                max = C-index;
                ans = i;
            }

       }
       return ans;
    }

    // Function to find the index of first index
    // of 1 in a boolean array arr[]

    private static int first(int arr[], int low, int high){

       if(high >= low) {
           // Get the middle index
           int mid = low + (high - low) / 2;
           // check if the middle index is first one, as array sorted
           if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1) return mid;
               // if element is 0 then recur right side.
           else if (arr[mid] == 0) {
               return first(arr, mid+1, high);
           } else {
               return first(arr, low, mid - 1);
           }
       }
       return -1;
       
    }
}
