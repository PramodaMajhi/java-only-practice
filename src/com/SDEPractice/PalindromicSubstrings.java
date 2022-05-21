package com.SDEPractice;

import java.util.HashSet;
import java.util.Set;

/*
647. Palindromic Substrings
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 */
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            // odd length palindromes, single character  center
            ans+= countPalindromesAroundCenter(s, i, i);
            // Even length palindromes, consecutive characters center
            ans+= countPalindromesAroundCenter(s, i, i+1);
        }
        return ans;
    }

    private static int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while(lo >= 0 && hi < ss.length()) {
            if(ss.charAt(lo) != ss.charAt(hi)){
                break; // first and last characters does not match
            }
            // expand around the center
            lo--;
            hi++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
