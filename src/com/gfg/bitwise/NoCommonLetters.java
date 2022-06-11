package com.gfg.bitwise;

public class NoCommonLetters {
    public boolean noCommonLetters(String s1, String s2){
        int bitMask1 = 0;
        int bitMask2 = 0;
        for(char c : s1.toCharArray()) {
            bitMask1 = bitMask1 | 1 << getBitNumber(c);
        }
        for(char c : s2.toCharArray()) {
            bitMask2|= 1 << getBitNumber(c);
        }
        return (bitMask1 & bitMask2) == 0;
    }
    private int getBitNumber(char ch) {
        return (int)ch - (int)'a';
    }

    public static void main(String[] args) {
        NoCommonLetters noCommonLetters = new NoCommonLetters();
        boolean ans  = noCommonLetters.noCommonLetters("abc", "bd");
        System.out.println(ans);
    }
}
