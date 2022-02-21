package com.SDEPractice;

import java.util.Arrays;

public class Jan18 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestDivisors(123)));
        System.out.println(Arrays.toString(closestDivisorsworking(123)));
    }

    /**
     * 1362. Closest Divisors
     * IDEA: How to find the divisor, finding divisor is pattern
     * lets take an arbitrary number 100,
     * 1 100
     * 2 50
     * 4 25
     * 5 20
     * 10 10
     * 20 5
     * after the square root the divisor will be same as beginning
     * we will start with sqaure root until 1 (descending)
     * (num + 2) is larger than (num+1)
     * Hence num+1 is closer pair.
     *
     * Strategy : will start a for loop starting with square root
     * for each iteration will check num+1/i  = x
     * otherwise will check num+2/i = x
     */
    public static int[] closestDivisors(int num) {
        for (int i = (int)Math.sqrt(num+2); i > 0; i--) {
            if((num + 1) % i == 0) {
                    return new int[]{ (num + 1) / i, i};
            }
            if((num + 2) % i == 0) return new int[]{ (num+2)/i, i};
        }
        return new int[]{}; // empty array
    }

    public static int[] closestDivisorsworking(int x) {
        for (int a = (int)Math.sqrt(x + 2); a > 0; --a) {
            if ((x + 1) % a == 0)
                return new int[]{a, (x + 1) / a};
            if ((x + 2) % a == 0)
                return new int[]{a, (x + 2) / a};
        }
        return new int[]{};
    }
}
