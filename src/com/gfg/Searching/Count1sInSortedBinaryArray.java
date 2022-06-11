package com.gfg.Searching;

public class Count1sInSortedBinaryArray {
    //Time complexity O(logn). we will binary search
    //IDEA: find last occurrence of 0 then subtract n - position found
    public int count1s(int[]arr){
        int low = 0, high = arr.length;
      while (low < high) {
          int mid = low + (high - low)/2;
          if(arr[mid] == 0){
              low = mid + 1;
          }else {
              if(arr[mid] == 0 || arr[mid - 1] == 0){ // this can be written
                                                    // arr[mid - 1] != arr[mid]
                  return  arr.length - mid;
              }else {
                  high = mid - 1;
              }
          }
      }
      return 0;
    }
    public static void main(String[] args) {
        Count1sInSortedBinaryArray obj = new Count1sInSortedBinaryArray();
        int[]arr ={0,0,0,1,1,1,1};
        int ans = obj.count1s(arr);
        System.out.println(ans);
    }
}
