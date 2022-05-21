package com.gfg.bitwise;

public class CountSetBits {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getcountBitsBrianKerningam(n));
        System.out.println(getCountSetBits(n));
    }
    public static int getCountSetBits(int n) {
         String str = Integer.toBinaryString(n);
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }
        return count;
    }
    public static int getCountSetBitsOperator(int n) {
        String str = Integer.toBinaryString(n);
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }
        return count;
    }
    public static int getcountBitsBrianKerningam(int n){
        int res = 0;
        while (n > 0) {
            n = n &(n-1);
            res++;
        }
        return res;
    }
    public static int getCountBitNaiveApproach(int n){
        int res = 0;
        while (n > 0) {
            if(n%2!=0) // if(n&1) == 1 // res = res+(n&1)
            res++;
            n = n/2; // n = n>>1
        }
        return res;
    }

}
