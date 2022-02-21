package com.FourteenDaysStudyPlan;

import java.util.Arrays;
import  java.util.*;

/*
977. Squares of a Sorted Array
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */
public class Day2TwoPointer {

    public static void main(String[] args) {
        int []arr = new int[] {1,2,3,4,5,6,7};
        //Arrays.sort(arr);
        System.out.println(Arrays.toString(rotateReverseApproach(arr,3)));
    }
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
/*
    This approach on the fact that when we rotate the array k times,
    k elements from the back end of the array come to the front and the rest of the
    elements from the  shift backwards

    In this approach,we firstly reverse all the elements of the array,
    Then reversing the first k elements followed by reversing the rest n-k
    elements give us the required result.
    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 */
    public static  int[] rotateReverseApproach(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k -1); // reversing first k times
        reverse(nums, k, nums.length -1 ); // reversing last n -k numbers.
        return nums;
    }
    private static  void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

/*
    We use an extra array in which we place every element of the array at its
    correct position i.e the number at index i in the original array is placed
    at the index (i+k)%length of the array, then we can copy the new array to
    original one.

    Time Complexity: O(n) one pass is used to put the numbers in the new array
    and another pass to copy the new array to the original one.
    Space Complexity : O(n) another array of the same size is used.
  */
    public static  int[] rotateSecondApproach(int[] nums, int k) {
        int [] arr = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            int index = (i+k)%nums.length;
            arr[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }
    // The below solution did not work for large input
    public static  int[] rotate1(int[] nums, int k) {
        // speed up the rotation
        k %= nums.length; // steps do not repeat duplicate times
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        return nums;
    }
/*
    This is brute force approach will run the loop k times, by
    keep last element in temp variable. and shift last element
    with previous element,
    Basically loop runs starting from last order.
    end of the loop we can bring the last element to zeroth position.
    Time Complexity: O(n*K)
    Space Complexity: O(1)
 */
    // The below solution did not work for large inputs
    public static  int[] rotate(int[] nums, int k) {

        int j = 0;
        while (k > 0) {
            int temp = nums[nums.length -1]; // last element
            for (j = nums.length-1; j>0; j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = temp; // Bring into front.
            k--;
        }
        return  nums;
    }
/*
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
 */
public static  int[] sortedSquares3(int[] nums) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for(int num: nums) {
        q.add(num * num);
    }
    int k = 0;
    while(!q.isEmpty()) {
        nums[k++] = q.remove();
    }
    return nums;
}
public static  int[] sortedSquares2(int[] nums) {
        int [] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length -1; i >=0; i--) {

            int square;
            if(Math.abs(nums[left]) < Math.abs(nums[right])) { // This is the trick
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;

        }
        return result;
}

    public static  int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
