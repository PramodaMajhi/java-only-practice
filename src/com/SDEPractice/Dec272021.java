package com.SDEPractice;

import java.util.*;

public class Dec272021 {

    public static void main(String[] args) {
       // String[]arr  = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
       // System.out.println(Arrays.toString(getFolderNames(arr)));
        int arr [] = {2,4,9,3};
        int k = -2;
        System.out.println(Arrays.toString(decrypt(arr, k)));

    }
    /*
    1652. Defuse the Bomb
    Input: code = [5,7,1,4], k = 3
    Output: [12,10,16,13]
    Explanation: Each number is replaced by the sum of the next 3 numbers.
    The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1].
    Notice that the numbers wrap around.
     */
    public static  int[] decryptReverse(int[] code, int k) {

        if(k > 0) return caseOne(code,k);

        return caseTwo(code,k);
    }
    private static int[]caseOne(int[] code, int k) {
        int sum = 0;
        for (int i = 0; i < code.length; i++) {
            sum+=code[i];
        }
        int[] res = new int[code.length];
        for (int i = 0; i <code.length; i++) {
            sum-= code[i];
            sum+=code[(i+k)%code.length];
            res[i] = sum;
        }
        return res;
    }
    private static int[]caseTwo(int[] code, int k) {
        k  = -k;
        reverse(code, code.length);
        caseOne(code, k);
        reverse(code, code.length);
        return null;
    }
    private static void reverse(int arr[] , int len){
        int start = 0 , end = len-1;

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static  int[] decrypt(int[] code, int k) {
        int[]res = new int[code.length];
        if(k == 0) return res;
        int start = 1, end = k, sum = 0;

        if(k<0) {
            k = -k;
            start = code.length - k;
            end = code.length -1;
        }
        for (int i = start; i <=end ; i++) {
            sum+=code[i];
        }
        for (int i = 0; i <code.length ; i++) {
            res[i] = sum;
            System.out.println((start)%code.length);
            sum-=code[(start++)%code.length];
            System.out.println((end)%code.length);
            sum+=code[(++end)%code.length];
        }
        return res;
    }
    public static int longestMountain(int[] arr) {
        int ans = 0;
        int N = arr.length -1;
        int i = 0;
        boolean peak = false;
        boolean valley = false;
        while (i < N) {
            int base = i ; // starting position of the mountain
            if(arr[i] < arr[i+1]) {

                while(i < N && arr[i] < arr[i+1]) {
                    i++;
                    peak = true;
                }
                while(i < N && arr[i] > arr[i+1]) {
                    i++;
                    valley = true;
                }
                if(peak == true && valley == true) {
                    ans  = Math.max(ans, i - base +1);
                }
                peak = false;
                valley = false;
            }else i++;
        }


        return ans;
    }

        public static  String[] getFolderNames(String[] names) {

        Map<String, Integer> map = new HashMap<String,Integer>();

        for (int i = 0; i <names.length ; i++) {
            names[i] = getName(map, names[i]);
        }
        return names;
    }

    private static String getName(Map<String,Integer>map, String name) {

        if(map.containsKey(name)) {
         int n = map.get(name) +1;

         while(map.containsKey(name +"("+n+")")) {
            n++;
         }
        map.put(name, n);
        name = getName(map, name + "(" + n + ")");
        } else {
            map.put(name, 0);
        }
        return name;
    }
}
