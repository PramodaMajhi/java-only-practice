package com.SDEPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class Feb2 {
    public static void main(String[] args) {
        int n = 2;
        int k = 1;
        System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));
    }

    /*
    967. Numbers With Same Consecutive Differences

    Input: n = 2, k = 1
    absolute difference
    Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
     */
    public static int[] numsSameConsecDiff(int n, int k) {
      /*
        Loop over the number starting from 1-9 and finding all
        absolute differences.
        Using DFS look for possible n digits with k absolute difference.
      */

        List<Integer> res = new ArrayList<Integer>();
        for(int i = 1; i < 10 ; i++) {
            dfs(n - 1, i, k, res);
        }
        return res.stream().mapToInt(i -> i).toArray(); // arraylist to int[] convert
    }

    private static void dfs(int N, int num, int k, List<Integer> res) {

        if(N == 0) {
            res.add(num);
            return;
        }
        int lastDigit = num%10;
        if(lastDigit + k < 10) {
            // eg: for 1
            // (1*10)+8 + k = (1*10)+8  - k
            dfs(N-1, num * 10 + lastDigit + k, k, res);
        }
        if(k > 0 && lastDigit - k >= 0){
            dfs(N-1, num * 10 + lastDigit - k, k, res);
        }

    }

    /*
        1331. Rank Transform of an Array
        Input: arr = [40,10,20,30]
        Output: [4,1,2,3]
        IDEA:
        Copy arr into A and sort it.
        Iterate sorted array A and record the rank for each element in hashmap rank.
        Iterate arr again, and assign rank[arr[i]] to A[i].
        return the final result A
     */
    public static int[] arrayRankTransform(int[] arr) {
        // Copy array
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int x : copy) {
            hashMap.putIfAbsent(x, hashMap.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = hashMap.get(arr[i]);
        }
        return arr;
    }

    /*
    1370. Increasing Decreasing String
    Input: s = "aaaabbbbcccc"
    Output: "abccbaabccba"
     */
    public static String sortString(String s) {
        if (s != null && s.length() == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        // Counting characters and their frequency.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }
        // Loop over starting from a z
        // ascii a = 97
        //
        while (!hashMap.isEmpty()) {
            for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                if (hashMap.containsKey(alphabet)) {
                    hashMap.put(alphabet, hashMap.get(alphabet) - 1);
                    stringBuilder.append(alphabet);
                    if (hashMap.get(alphabet) == 0)
                        hashMap.remove(alphabet);
                }
            }
            for (char alphabet = 'z'; alphabet >= 'a'; alphabet--) {
                if (hashMap.containsKey(alphabet)) {
                    hashMap.put(alphabet, hashMap.get(alphabet) - 1);
                    stringBuilder.append(alphabet);
                    if (hashMap.get(alphabet) == 0)
                        hashMap.remove(alphabet);
                }
            }
        }
        return stringBuilder.toString();
    }
}
