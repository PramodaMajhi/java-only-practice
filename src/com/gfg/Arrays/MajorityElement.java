package com.gfg.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(findMajority(arr));
        System.out.println(findMajorityMoore(arr));
    }
    /*
     IDEA: O(n) solution using Moore voting
     Two Phase
     1) find out the majority
     2) Ensure its majority
     Note: Second phase is not needed if you are sure
     there is a majority element

     */

    public static int findMajorityMoore(int[] arr) {
        int res = 0;  // first element as majority
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i])
                count++;
            else
                count--;
            if (count == 0) {
                res = i; // reset majority
                count = 1; // reset count
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i])
                count++;
        }
        if (count <= arr.length / 2) {
            res = -1;
        }
        return res;
    }


    /*
    IDEA: This is brute force solution, don't forget to initialize count = 1
     */
    public static int findMajority(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return arr[i];

            }
        }
        return -1;
    }
}
