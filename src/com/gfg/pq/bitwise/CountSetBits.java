package com.gfg.pq.bitwise;

public class CountSetBits {

    public static void main(String[] args) {
        int n = 5;
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
}
