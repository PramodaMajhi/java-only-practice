package com.gfg.dp;
/*
IDEA: Create an auxiliary space to calculate overlapping subsequence
Total number of increasing subsequence is 2^n
Time complexity is n^2, because we need to check how many previous element
are less than the current element, then take the maximum out of it and followed by +1
Once we populate the auxiliary array,then find the max in the entire array, and that
is the result.
 */
public class LongestIncreasingSubsequence {
    // O(n^2) solution can we do better using binary search o(nlogn) ?
    // Refer binary search implementation
    public int longestIncreasingSubsequence(int[] arr) {
        //int[]arr = [10, 5, 18, 7, 2, 9];
        int[]aux = new int[arr.length];
        aux[0] = 1; // because  this is first element, and there is no element left to it
                    // Hence, the elements itself so 1.
        for (int i = 1; i <arr.length; i++) {
            aux[i] = 1; // we always add 1 for all lis, if there is no smaller element it becomes 1 only
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                   aux[i] = Math.max(aux[i], aux[j]+1);
                }
            }
        }
        int res = aux[0];
        for (int i = 1; i < aux.length; i++) {
            res = Math.max(res, aux[i]);
        }
        return res;
    }
    public int longestIncreasingSubsequenceBinarySearch(int[] arr) {
        // [10, 5, 18, 7, 2, 9];
        int[]tail = new int[arr.length];
        tail[0] = arr[0]; // first element goes to first place
        int len  = 1;
        for (int i = 1; i <arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > tail[len - 1]) {
                    tail[len] = arr[i];
                    len++;
                } else {
                    int c = ceilIndex(tail, 0, len -1, arr[i]);
                    tail[c] = arr[i];
                }
            }
        }
        return len;
    }
    public int ceilIndex(int[]arr, int low, int high, int target){
        while(high > low) {
            int mid = low + (high - low)/2;
            if(arr[mid] >= target) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int[]arr = {10, 5, 18, 7, 2, 9};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int ans = lis.longestIncreasingSubsequence(arr);
        int ans2 = lis.longestIncreasingSubsequenceBinarySearch(arr);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
