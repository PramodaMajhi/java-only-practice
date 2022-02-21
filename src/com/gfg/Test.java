package com.gfg;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("12");
        BigInteger c = a.add(new BigInteger("10"));
       // System.out.println(c);
        System.out.println(factorial(3));
    }

    private static BigInteger factorial(int n) {

        BigInteger f = new BigInteger("1");
        for (int i = 2; i <=n ; i++) {
            BigInteger x = BigInteger.valueOf(i);
            f = f.multiply(x);
        }
        return f;
    }
}
