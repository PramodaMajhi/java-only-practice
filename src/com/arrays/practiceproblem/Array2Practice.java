package com.arrays.practiceproblem;

import java.util.Arrays;

public class Array2Practice {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1};

        System.out.println(Arrays.toString(zeroFront2(arr)));
    }
    /*
        zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
        zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
        zeroFront([1, 0]) → [0, 1]
    */
    public static int[] zeroFront2(int[] nums) {
        if(nums.length == 0)
            return nums;

        int i = 0;

        while(nums[i] == 0)
            i++;

        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return nums;
    }
    public static int[] zeroFront(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                nums[i] = nums[count];
                nums[count] = 0;
                count ++;
            }
        }
        return nums;
    }
/*
notAlone([1, 2, 3], 2) → [1, 3, 3]
notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 2]
notAlone([3, 4], 3) → [3, 4]
 */
    public static int[] notAlone(int[] nums, int val) {
        int max = 0;
        for (int i = 1; i < nums.length -1; i++) {
            if(nums[i] == val && nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                max  = Math.max(nums[i], nums[i+1]);
                nums[i] = max;
            }
        }
        return nums;
    }
/*
post4([2, 4, 1, 2]) → [1, 2]
post4([4, 1, 4, 2]) → [2]
post4([4, 4, 1, 2, 3]) → [1, 2, 3]
 */
    public static int[] post4(int[] nums) {
        int i = nums.length-1;
        while (nums[i]!=4) {
            i--;
        }
        int [] arr = new int[nums.length -1 - i];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = nums[i+j+1];
        }

        return arr;
    }

    public static int[] pre4(int[] nums) {
        int i = 0;
        while (nums[i]!=4){
            i++;
        }
        int[] arr = new int[i];
        for(int j = 0; j<i; j++) {
            arr[j] = nums[j];
        }
        return arr;
    }

    /*
tenRun([2, 10, 3, 4, 20, 5]) → [2, 10, 10, 10, 20, 20]
tenRun([10, 1, 20, 2]) → [10, 10, 20, 20]
tenRun([10, 1, 9, 20]) → [10, 10, 10, 20]
 */
    public int[] tenRun(int[] nums) {
        for(int i = 0 ; i < nums.length -1; i++) {
            if(nums[i]%10 == 0){
                if(nums[i+1]%10 !=0){
                    nums[i+1] = nums[i];
                }
            }
        }
        return nums;
    }

/*
shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
shiftLeft([1, 2]) → [2, 1]
shiftLeft([1]) → [1]
 */

    public static int[] shiftLeft(int[] nums) {

        for (int i = 0; i <nums.length -1 ; i++) {
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }

        return nums;
    }
/*
evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
evenOdd([3, 3, 2]) → [2, 3, 3]
evenOdd([2, 2, 2]) → [2, 2, 2]

 */

public static int[] evenOdd2(int[] nums) {
    int start = nums.length -1;
    for(int i = nums.length -1; i>=0; i--) {
        if(nums[i]%2!= 0) {
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            start--;
        }
    }
    return nums;
}
public static int[] evenOdd(int[] nums) {
    int start = 0;
    for(int i = 0 ; i< nums.length ; i++) {
        if(nums[i]%2 ==0) {
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            start++;
        }
    }
    return nums;
}
    public static  int[] zeroMax(int[] nums) {
        int max = 0;
        for (int i = nums.length -1; i >=0 ; i--) {
            if(nums[i]%2!=0) {
                max = Math.max(max, nums[i]);
            }
            if(nums[i] == 0)
              nums[i] = max;
        }
        return nums;
    }

    public static boolean modThree(int[] nums) {
        int odd = 0, even = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]%2 == 0) {
                even++;
                if(odd < 3) odd = 0 ;

            } else {
                odd ++;
                if(even < 3) even = 0;
            }

        }
        return (odd == 3 || even == 3) ;
    }
    public static int countEvens(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) count++;
        }
        return count;
    }
}
