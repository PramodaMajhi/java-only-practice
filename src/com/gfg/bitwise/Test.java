package com.gfg.bitwise;

public class Test {

    public static void main(String[] args) {
        int x = 1;
        System.out.println((~x));
        int a = 8, b = 13;
        int aDiff = Math.abs(a -10);
        int bDiff = Math.abs(b -10);
        if(aDiff > bDiff)
                System.out.println("B"+ bDiff);
        if(aDiff < bDiff)
            System.out.println("A" + aDiff);
    }
}

