package com.gfg.dp;
/*
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c"
Time Complexity: O(n^2)
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s){
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans+= countPalindrome(s, i, i); // Odd number
            ans+= countPalindrome(s, i, i+1); // Even number
        }
        return ans;
    }
    public int countPalindrome(String s, int start, int end) {
        int ans = 0;
        while (start>=0 && end< s.length()) { // boundary check
            if(s.charAt(start)!=s.charAt(end)) {
                break;
            }
            ans++;
            start--;
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        int count  = palindromicSubstrings.countSubstrings(s);
        System.out.println(count);

    }
}
