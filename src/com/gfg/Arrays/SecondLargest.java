package com.gfg.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {5, 20, 12, 20, 8};
        System.out.println(secondLargest(arr));
    }
/*
    IDEA: Create two variables for indexes, initialize as follows
    One for res = -1, largest  = 0 (first element)
    Start looping through from second element and compare with first element
    if yes, then res = largest and lartest = i
    else if new element is greater than res  then assign to i

 */
    public static int secondLargest(int[] arr) {
        int res = -1;
        int largest = 0;
        // {5, 20, 12, 20, 8};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
            res  = largest;
            largest = i;
            } else if(arr[i]!= arr[largest]) // not equal to 20 and 12 is >  5
                if(res == -1 || arr[i] > arr[res]){
                res = i;
            }
        }
        return arr[res]; // you can return index
    }
}
