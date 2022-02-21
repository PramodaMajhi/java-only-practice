package com.concept.recursion;

import java.util.HashMap;

public class Fibo {

    public static void main(String[] args) {
        System.out.println(fibo(5));
    }
    public static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public static int fibo(int n) {
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        int result;
         if(n<2) {
             result =  n;
         }else {
             result = fibo(n-1) + fibo(n-2);
         }
         // keep the result in cache
        cache.put(n, result);
        return result;
    }
}
