package com.SDEPractice;
/*
1750. Minimum Length of String After Deleting Similar Ends
 */
public class Jan4 {

    public static void main(String[] args) {
        String s = "aabccabba";
        System.out.println(minimumLength(s));
    }
    /*
    Input: s = "ca"
    Output: 2
    Explanation: You can't remove any characters, so the string stays as is.
    Input: s = "aabccabba"
    Output: 3
     */
    public static int minimumLength(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r && s.charAt(l) == s.charAt(r)) {

              char ch = s.charAt(l);
              // prefix
              while (l<=r && s.charAt(l) == ch) l++;
              // suffix
            while (r >=l && s.charAt(r) == ch)  r--;
        }
        return l > r ? 0 : (r - l)+1; // 0 based
    }
}
