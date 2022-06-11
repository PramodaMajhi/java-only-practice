package com.gfg.Searching;

public class SearchInInfiniteSortedArray {
    /*
    Naive solution, run an infinite loop, and check if it's greater than the target return -1
    if it matches during the step starting from left to right then return i
    Time: O(pos)
    Space O(1)
    */
    public int search(int[] arr, int target) {
        int i = 0;
        while(true) {
            if(arr[i] == target)
                return i;
            if(arr[i] > target)
                return -1;
            i++;
        }
    }
    public int searchEfficient(int[] arr, int target) {
       if(arr[0] == target) return 0;
       int i = 1;
       while (arr[i] < target){
           i = i*2;
           if(arr[i] == target)
               return i;
       }
       return binarySearch(arr, target, i/2+1, i);
    }
    public int binarySearch(int[]arr, int target, int low, int high) {
        if(low > high)
            return -1;
        int mid = low + (high - low)/2;
        if(target > arr[mid]) {
            return binarySearch(arr,target, mid +1 , high);
        }else if(target < arr[mid]) {
            return binarySearch(arr,target, low, mid-1);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        SearchInInfiniteSortedArray search = new SearchInInfiniteSortedArray();
        int ans = search.search(arr, 18);
        System.out.println(ans);
        int ansEfficient = search.searchEfficient(arr, 18);
        System.out.println(ansEfficient);
    }
}
