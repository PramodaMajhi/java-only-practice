package com.SDEPractice;

public class Feb13 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "abcd";
        System.out.println(findTheDifference(s,t));

    }
    /*
     389. Find the Difference
     */
    public static char findTheDifference(String s, String t) {
        // Initialize ch with 0, because 0 ^ X = X
        // 0 when XORed with any bit would not change the bits value.
        char ch = 0;
        // XOR all the characters of both s and t.
        for (int i = 0; i < s.length() ; i++) {
            ch^=s.charAt(i);
        }
        for (int i = 0; i < t.length() ; i++) {
            ch^=t.charAt(i);
        }
       // System.out.println(Character.toString(ch));
        return ch;
    }
}
