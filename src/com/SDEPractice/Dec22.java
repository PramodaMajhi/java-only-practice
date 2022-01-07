package com.SDEPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Dec22 {

    public static void main(String[] args) {
       int[] nums = {10,20,30,40,50};
       int[]index = {0,1,2,2,1};
       // createTargetArray(nums,index);
      // System.out.println(Arrays.toString(createTargetArrayWithoutArrayList(nums,index)));
      // System.out.println(Arrays.toString(createTargetArray(nums,index)));

        int []temp  = {1,2,3,4,5};

        System.arraycopy(nums, 0, index, 0, index.length);
        System.out.println(Arrays.toString(index));
    }
/*
1389. Create Target Array in the Given Order
Given two arrays of integers nums and index.
Your task is to create target array under the following rules:
Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.
It is guaranteed that the insertion operations will be valid.
Example 1:
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
 */


    // Without arraylist
    public static int[] createTargetArrayOnePosMovingRight(int[] nums, int[] index) {

        int[] target = new int[nums.length];
        int count = 0;
        while (count < target.length) {
            if (index[count] >= count) {
                target[index[count]] = nums[count];
            }
            else{
                for (int i = target.length - 1; i > index[count]; i--)
                    target[i] = target[i - 1];
                target[index[count]] = nums[count];
            }
            count++;
        }
        return target;
    }
    public static  int[] createTargetArrayWithoutArrayList(int[] nums, int[] index) {
        int i = 0, j = 0;
        int[] target = new int[nums.length];
       // Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
        while(i < nums.length){
            if(index[i] == i){
                target[index[i]] = nums[i];
            }
            else{
                int temp;
                for(j = index[i] ; j < i + 1 ; j++){
                    temp = target[j];
                    target[j] = nums[i];
                    nums[i] = temp;
                }
            }
            i++;
        }
        return target;
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        int []result  = new int[index.length];
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i<nums.length; i++) {
            arrayList.add(index[i], nums[i]);
        }
        for (int i = 0; i <nums.length ; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }


}
