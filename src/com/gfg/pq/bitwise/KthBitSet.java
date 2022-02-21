package com.gfg.pq.bitwise;

public class KthBitSet {

    public static void main(String[] args) {
        int num = 5;
        int k = 1;
        System.out.println(isKthBitSetRightShift(num, k));
    }
    public static boolean isKthBitSet(int num, int k) {
        // convert into binary then check
        String str =  Integer.toBinaryString(num);
        System.out.println(str);
        System.out.println(str.charAt(str.length()-k));
        if(str.charAt(str.length()-k) == '1') return true;

        return false;
    }

    public static boolean isKthBitSetLeft(int num, int k) {
        if((num & 1 << (k -1)) !=0) {
            return true;
        }

        return false;
    }
    public static boolean isKthBitSetRightShift(int num, int k) {
        if((num >> (k-1) & 1) == 1) {
            return true;
        }

        return false;
    }
}
