package com.gfg.Searching;

public class LastOccurrence {
    public int lastOccurrenceUpperBound(int[]arr, int target){
        int low = 0, high = arr.length;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(target < arr[mid]) {
                high = mid;
            }else {
                low = mid +1;
            }
        }
        low--;
        if(low>=0 && arr[low] == target)
            return low;
        else
            return -1;
    }
    public int lastOccurrenceRec(int[]arr, int target){
        return helper(arr, target, 0, arr.length);
    }
    public int helper(int[] arr, int target, int low, int high){
        if(low > high)
            return -1;
        int mid = low + (high - low)/2;
        if(target < arr[mid]){
            return helper(arr,target, low, mid -1);
        }else if(target > arr[mid]){
            return helper(arr, target, mid +1 , high);
        }else {
            if(mid == arr.length-1 || arr[mid]!=arr[mid+1]) {
                return mid;
            }else{
                return helper(arr,target, mid +1, high);
            }
        }
    }
    public static void main(String[] args) {
        int[]arr = {5,10, 10, 10, 10, 20, 20};
        int target = 20;
        LastOccurrence lastOccurrence = new LastOccurrence();
        int upperBound = lastOccurrence.lastOccurrenceUpperBound(arr,target);
        System.out.println(upperBound);
        int upperBoundRec = lastOccurrence.lastOccurrenceRec(arr,target);
        System.out.println("Rec -> " + upperBoundRec);
    }
}
