package com.gfg.dp;

/**
 5. Longest Palindromic Substring
 Input: s = "babad"
 Output: "bab"
 Explanation: "aba" is also a valid answer.
 */

import java.util.Map;

/**
 IDEA:

 As right and left will be shifted 1 step ahead of actual start and end indexes
 For each character, consider center and expand on both sides to find maximum
 length of palindrome
 Two possibilities of center
    i) for odd length palindrome , center = i
    ii) For even length palindrome, center = i+1
 Length = right - left -1;
 https://www.youtube.com/watch?v=QfZvw8_jz1w
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int max = 0;
        int start =0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCorner(s, i, i); // odd length
            int even = expandAroundCorner(s, i, i + 1); // even length
            max = Math.max(odd,even);
            if(max >  end - start) {
                // Even max(6) -> 2 start -> i-2, end i + 3
                // Odd max(5) -> 2 start i -2 , end -> i+2
                start = i - (max-1)/2;
                end = i + max /2;
            }
        }
        String ans = s.substring(start, end+1);
        return ans;
    }
    public int expandAroundCorner(String s, int start, int end) {
        int ans= 0;
        while(start>=0 && end < s.length() && s.charAt(start)==s.charAt(end)) {
            start--;
            end++;
        }
        return end - start -1;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String ans = longestPalindrome.longestPalindrome("cbbd");

    }
}
