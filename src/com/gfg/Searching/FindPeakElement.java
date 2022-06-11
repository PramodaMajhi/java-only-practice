package com.gfg.Searching;

public class FindPeakElement {
    public int findPeak(int[]arr) {
        int low = 0; int high = arr.length -1;
        while (low <= high){
            // Finding mid
            int mid = low +(high - low)/2;
            //First case if mid is the answer
            if(mid == 0 || arr[mid -1] <= arr[mid] &&
                    (mid == arr.length  -1
                            || arr[mid+1] <= arr[mid]
                            )){
                 return mid;
            }
            // move the right pointer
            if(mid > 0 && arr[mid-1] >= arr[mid]){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 20, 4, 1, 0 };
        FindPeakElement peakElement = new FindPeakElement();
        int ans = peakElement.findPeak(arr);
        System.out.println(ans);
    }
}
