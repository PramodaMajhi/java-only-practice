package com.gfg.Arrays;

public class MaximumCircularSubarraySum {
    public static void main(String[] args) {
        int[]arr = {5, -2, 3, 4};
        // I/P : 12
        System.out.println(maxCircularSubArrayEfficient(arr));
    }

    /*
     Efficient: O(n)
     IDEA: 1) get the max sub array using kadane
     2) Get the maximum sub array of circular array, to find the max sub array
        a) get the min sub array using Kadane
        b) Get the max sub array using kadane
        finally subtract from min from max
      Then compare with max sum from kadane with max sum of circular

      Note: if you want to reuse to kadane function for minimum, you can revert th array
      instead of subtract, you can add to get the result
     */
    public static int maxCircularSubArrayEfficient(int[] arr){
        int maxSubArray =  kadane(arr);
        if(maxSubArray < 0)
            return maxSubArray;
        // This is make sense, we don't have to calculate further
        // This means all the element in array are negatives
        int kadaneMin = kadaneMin(arr);
        int maxCir = maxSubArray - kadaneMin;
        return  Math.max(maxSubArray, maxCir);
    }
    private static int kadaneMin(int[] arr){
        int res = arr[0];
        int minEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minEnding = Math.min(minEnding + arr[i], arr[i]);
            res = Math.min(minEnding, res);
        }
        return res;
    }
    private static int kadane(int[] arr){

        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }
    /*
     O(n^2) solution
     IDEA: Nested loop, first loop through all the elements
     and initialize curr_max  and curr_sum = arr[i]
     second loop starting from j = 1 tp n-1
     and get the index till that number using arithmetic module operator
     index = (i+j)%n
     calculate curr_sum  of the index and update curr_max
     when inner loop finishes update res as well finally return res
     */
    public static int maxCircularSubArray(int[] arr){
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int curr_max = arr[i];
            int curr_sum = arr[i];
            for (int j = 1; j < arr.length - 1; j++) {
                int index = (i + j) % arr.length;
                curr_sum+= arr[index];
                curr_max = Math.max(curr_max, curr_sum);
            }
            res = Math.max(res, curr_max);
        }
        return res;
    }
}
