package com.gfg.dp;

import java.util.HashMap;

public class Fibo {
    public static void main(String[] args) {
        HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
        //fib(35); // -> 9227465
        System.out.println(fib(5,memo));
        System.out.println(fibTabulization(5));
        fib(5);
    }

    static void fib(int n)
    {
        int a = 0, b = 1, c;
        if (n >= 0)
            System.out.print( a + " ");
        if (n >= 1)
            System.out.print( b + " ");
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            System.out.print( c + " ");
            a = b;
            b = c;
        }
    }


    /*
     Topdown approach
     */
    public static int fib(int n,HashMap<Integer,Integer> memo) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        if(n <=2) return  1;
        int val = fib(n-1, memo) + fib(n-2, memo);
        memo.put(n, val);
        return val;
    }
    /*
        Tabulization solution is faster than memoization
        Bottom Up Solution
     */
    public static int fibTabulization(int n) {

        int []f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <=n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
