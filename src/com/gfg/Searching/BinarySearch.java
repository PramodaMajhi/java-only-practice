package com.gfg.Searching;

public class BinarySearch {
    public int bSearch(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            if(target > arr[mid]) {
                low = mid + 1;
            }else if(target < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return  -1;
    }
    public int bSearchRecursive(int[] arr, int target) {

       return helper(arr, target,0, arr.length);
    }
    public int helper(int[]arr, int target, int low, int high){
        if(low > high) {
            return -1;
        }
        int mid = low + (high - low)/2;
        if (target > arr[mid]) {
            return helper(arr, target,mid+1, high);
        } else if(target < arr[mid]){
            return helper(arr, target, low, mid-1);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[]arr = {10,20, 30, 40, 50, 60};
        int target  = 50;
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.bSearchRecursive(arr, target);
        System.out.println("Index " + index);
    }
}
