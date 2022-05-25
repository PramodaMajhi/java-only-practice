package com.gfg.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowerBound {
    /**
     Lowe_bound: It returns the address of the first occurrences of the element
     if found otherwise returns the address of greater element of the element
     */
    public int lower_bound(int[] arr, int element) {
        int lower_bound = 0;
        while (lower_bound < arr.length){
            if(element > arr[lower_bound]){
                lower_bound++;
            }else {
               return lower_bound;
            }
        }
        return lower_bound;
    }
    public int lower_bound_binarySearch(int[] arr, int element) {
        int low = 0, high = arr.length;
        int mid;
        while (low < high){
            mid = low + (high - low)/2;
            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if(element <= arr[mid]){
               high = mid;
            }
            // If key is greater than array[mid],
            // then find in right subarray
            else {
               low = mid + 1;
            }
        }
        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array, hence return next larger element
        if (low < arr.length && arr[low] < element) {
            low++;
        }
        return low;
    }

    /**
     It returns the address of greater element of the element

     Note: Q, where is the last place that we can insert a particular element
     Just we need to upper_bound_binarSearch(arr, 2) - 1
     */
    public int upper_bound(int[] arr, int element) {
        int upper_bound=0;
        while (upper_bound < arr.length) {
            if(arr[upper_bound] <= element)
                upper_bound++;
            else
                return upper_bound;
        }
        return upper_bound;
    }
    public int upper_bound_binarySearch(int[] arr, int element) {
        // [0,0,0,2,2]
        int low = 0;
        int high = arr.length;
        int mid;
        while (low < high) {
            mid = low + (high - low)/2; //
            // If key is less than
            // to array[mid], then find in
            // left sub array
            if(element < arr[mid]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    /**
     * Given an ascending integer array e.g. [0,0,0,2,2,3,3]
     * Return an array of the ascending indices (an index where the
     * number is larger than its previous element).
     * For the given input, the answer is [3,5],

     * The new condition: The number of unique values in the ascending array is less than 5,
     * However the array's length could still be very large.
      input =  [0,0,0,0,0....0,0,1,1,1,1,1,1,1,2,2,2,3,3,3,3 4,4,4,4,4,4,4,4]
     */
    public static void main(String[] args) {
        // O(klogn) - > n is distinct element in array

      //   int[] arr = {1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 5,8};
        // int[] arr = {0,0,0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,3,3,3,3,4,4,4,4,4,4,4,4,};
        //  int[] arr = {0,0,2,2};
          int[] arr = {5,7,7,8,8,10};
        // O(nlogn)
        LowerBound lowerBound = new LowerBound();
        List<Integer> result = new ArrayList<>();

//        int ans1 = 0;
//        do {
//              ans1 = lowerBound.upper_bound_binarySearch(arr, arr[ans1]);
//             if(ans1 < arr.length)
//              result.add(arr[ans1]);
//        }while (ans1 < arr.length);
        // n!=arr.length
         int ans1 = lowerBound.upper_bound_binarySearch(arr, 6);

        System.out.println("ans2  " + ans1);
        System.out.println("Index " + ans1 );
        if(ans1 < arr.length){
            System.out.println(arr[ans1]);
        }
        else
            System.out.println(-1);

       // System.out.println(result);
//                // - lowerBound.lower_bound_binarySearch(arr, 5);
//        int ans2 = lowerBound.upper_bound_binarySearch(arr, 2);
//        System.out.println("ans2" + ans2);
//        System.out.println("Index " + ans2 );
//        if(ans2 < arr.length){
//            System.out.println(arr[ans2]);
//        }
//        else
//            System.out.println(-1);
//
//        System.out.println(result);
    }
}
