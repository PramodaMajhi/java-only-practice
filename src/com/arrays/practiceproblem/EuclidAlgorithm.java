package com.arrays.practiceproblem;

public class EuclidAlgorithm {

    public static void main(String[] args) {
        System.out.println( findGCD2(2166, 6099));
    }

    public  static int findGCD2 (int m, int n) {

        if(m< n) {
            int temp  = m;
            m = n;
            n = temp;
        }
        while(m>=0 || n>=0){

            m = m%n;
            if(m == 0) return  n;
            else {
                n = n%m;
                if(n == 0) return m;
            }
        }
        return 0;

    }
    public static int findGCD (int m, int n) {
        if(m< n) {
            int temp  = m;
            m = n;
            n = temp;
        }
        int r = 0;
        while ( r >= 0) {
            r = m % n;
            if (r == 0) {
                return n;
            } else {
                m = n;
                n = r;
            }
        }
        return n;
    }


}
