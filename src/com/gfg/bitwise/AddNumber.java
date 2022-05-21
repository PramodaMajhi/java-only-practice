package com.gfg.bitwise;

public class AddNumber {
    public static int getSum(int a , int b) {
        while(b!=0) {
            int answer = (a ^ b);
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }
        return a;
    }
    public static int getSubtract(int a , int b) {
        while(b!=0) {
            int answer = (a ^ b);
            int carry = (~a & b) << 1;
            a = answer;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(2,3));
        System.out.println(getSubtract(2,3));
    }
}
