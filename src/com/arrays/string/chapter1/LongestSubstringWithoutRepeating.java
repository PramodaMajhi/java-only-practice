package com.arrays.string.chapter1;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    public static  int lengthOfLongestSubstring(String s) {
        if(s == null && s.length() == 0) return  0;
        Set<Character> set  = new HashSet<>();
        int max = 0, i = 0, j = 0;

        while (i < s.length()) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}
