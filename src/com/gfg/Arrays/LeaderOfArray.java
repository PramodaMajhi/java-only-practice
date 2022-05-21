package com.gfg.Arrays;

public class LeaderOfArray {
    public static void main(String[] args) {
        int [] arr = {7, 10, 4, 10 , 6, 5, 2};
        leader(arr);
        leaderEfficient(arr);
    }
    /*
     Compare each element with the remaining element in an array by using two loops
     and also create a boolean flag variable to ensure there is nothing greater
     encountered, then print that element

     */
    public static void  leader(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] <= arr[j])
                {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println(arr[i]);
        }
    }
    /*
        Time O(n)
     */
    public static void  leaderEfficient(int arr[]) {
        int curr_leader = arr[arr.length -1];
        System.out.print(curr_leader);
        // {7, 10, 4, 10 , 6, 5, 2};
        for (int i = arr.length - 2; i >= 0; i--) {
            if(curr_leader < arr[i]){
                curr_leader = arr[i];
                System.out.print(arr[i]);
            }
        }
    }
}
