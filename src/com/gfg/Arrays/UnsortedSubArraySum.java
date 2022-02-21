package com.gfg.Arrays;

public class UnsortedSubArraySum {
    public static void main(String[] args) {
        int [] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        System.out.println( unsortedNonNegativeSubArraySum(arr, sum));
    }
    /*
    Given an un-sorted array of non-negative integers.
    Find if there is a sub array with given sum.
    IDEA: Maintain a target sum window , start adding element into the sum,.
    if the sum is greater than target sum then keep removing elements from target sum
     */
   public static boolean unsortedNonNegativeSubArraySum(int [] arr, int target) {

       int sum = arr[0];
       int index = 0;
       for (int i = 1; i < arr.length; i++) {

           // If curr_sum exceeds the sum,
           // then remove the starting elements
           while(sum > target && index < i -1){
               sum-=arr[index++];
           }
           if( sum == target){
               int p = i - 1;
               System.out.println("Sum found between indexes " + index + " and " + p);
               return true;
           }
           // Add this element to curr_sum
           if(i < arr.length) {
               sum+=arr[i];
           }
       }
       return sum == target;
   }
}
