package com.gfg.Searching;

public class FirstOccurrence {
    public int firstOccurrence(int[] arr, int target) {
        int low = 0; int high = arr.length;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(target <= arr[mid]) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        if(low!= arr.length && arr[low] == target)
            return low;
        return -1;

    }
    public int firstOccurrenceBinary(int[]arr, int target){
        int low = helper(arr, target, 0, arr.length);
        return low;
    }
    public int helper(int[] arr, int target, int low, int high){
        if(low >= high)
            return -1;
        int mid = low + (high - low)/2;
        if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target)
            return mid;
        if(target <= arr[mid]) {
            return helper(arr,target, low, mid);
        } else {
            return helper(arr,target, mid + 1, high);
        }
    }
    public int firstOcc(int[] arr, int target){
        int low = 0; int high = arr.length;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] > target) {
                high = mid - 1;
            }else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                if(mid == 0 || arr[mid -1]!=arr[mid]){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public int firstOccRec(int[] arr, int target){
        return helperOne(arr, target, 0, arr.length);
    }
    public int helperOne(int[]arr, int target, int low, int high){
        if(low > high)
            return -1;
        int mid = low + (high - low)/2;
        if(target > arr[mid]){
            return helperOne(arr,target,mid +1, high);
        }else if(target < arr[mid]) {
            return helperOne(arr,target,low, mid -1);
        }else {
            if(mid == 0 || arr[mid -1]!=arr[mid]) {
                return mid;
            }else{
                return helperOne(arr,target, low, mid -1);
            }
        }
    }
    public static void main(String[] args) {
        int[]arr = {10,20, 20, 20,30,30, 30};
        int target = 20;
        FirstOccurrence firstOccurrence = new FirstOccurrence();
        int norec = firstOccurrence.firstOccurrence(arr, target);
        int rec = firstOccurrence.firstOccurrenceBinary(arr, target);
        int firstOcc = firstOccurrence.firstOcc(arr, target);
        int firstOccRec = firstOccurrence.firstOccRec(arr, target);
        System.out.print("No Recursion -> " + norec);
        System.out.println();
        System.out.print(" Recursion -> " + rec);
        System.out.println();
        System.out.print(" first Occ -> " + firstOcc);
        System.out.println();
        System.out.print(" first Occ rec-> " + firstOccRec);
    }
}
