package com.FourteenDaysStudyPlan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day6SlidingWindow {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion3(s1,s2));

    }
/*
    567. Permutation in String
    Given two strings s1 and s2, return true if s2 contains a permutation of s1,
    or false otherwise.
    In other words, return true if one of s1's permutations is the substring of s2.
 */

/*
The idea behind this approach is that one string will be a permutation
of another string only if both of them contain the same characters the
same number of times.
    Approach #5 Sliding Window [Accepted]:
    Instead of creating lookup array , we can create a lookup array once
    for the fist window of s2, then, later on when we slide the window,
    We know that we remove one preceding character and add a new succeeding character
    to the new window considered.Thus, we can update lookup array by just updating the
    indices associated with those characters only.
    Again, for every updated look up array,we compare all the elements of the lookup array
    for the equality to get the required result.
 */

    public static boolean checkInclusion3(String s1, String s2) {
        if(s1.length() > s2.length()) return  false;

        int[]s1arr = new int[26];
        int[]s2arr = new int[26];
        for (int i = 0; i <s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
            s2arr[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length() ; i++) {

            if(matches(s1arr, s2arr)) return true;
            s2arr[s2.charAt(i+s1.length()) - 'a']++;
            s2arr[s2.charAt(i) - 'a']--;
            return matches(s1arr,s2arr);
        }
        return  false;
    }
/*
Approach #4 Using Array [Accepted]
We can use simple data structure array to store the frequencies.
Given strings contains only lowercase alphabets[a-z], so need array size of 26
The rest of the process remains the same as the last approach.

    Time Complexity: O(l1+26*l1**(l2-l1) where l1 is the length of the string l1 and l2 is length of string l2
    Space: O(1) s1arr and s2arr are size of 26 used
 */
    public static boolean checkInclusion2(String s1, String s2) {
        if(s1.length() > s2.length()) return  false;

        int[]s1arr = new int[26];
        for (int i = 0; i <s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <=s2.length() - s1.length() ; i++) {
            int[]s2arr = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2arr[s2.charAt(i+j) - 'a'] ++;
            }
            if(matches(s1arr, s2arr)) return true;
        }
        return  false;
    }

    private static boolean matches(int[] s1arr, int[] s2arr) {
        for (int i = 0; i <26; i++) {
            if(s1arr[i] != s2arr[i]) return false;
        }
        return true;
    }

    /* TLE
    * Time Complexity: O(n!). We match all the permutation of the short string s1
    *  of length s1, with s2.
    * n refers to length of s1
    * Space complexity:
    * O(n2), The depth of the recursion tree is n(n refers ot the length of the short string s1)
    * Every node of the recursion tree contains a string of max. length n.
    * */

    public static boolean  checkInclusion(String s1, String s2) {
        ArrayList<String> permuteList = permute("", s1, new ArrayList<>());
        for(String s: permuteList) {
           // System.out.println(s);
            if(s2.indexOf(s)>=0)  return  true;
        }
        return  false;
    }
// searching permutation within second string.
    private static ArrayList<String> permute(String prefix, String s1, ArrayList<String>list) {
        // ab
        //ab, ba
        if(s1.length() <=1) {
            list.add(prefix+s1);
        } else {
            for (int i = 0; i <s1.length() ; i++) {
                String current = s1.substring(i,i+1);
                String before = s1.substring(0, i);
                String after = s1.substring(i+1);
                permute(prefix+current, after+before, list);
            }
        }
        return list;

    }
    /*
        3. Longest Substring Without Repeating Characters
        Given a string s, find the length of the longest substring without
        repeating characters.
        Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int i = 0, j = 0;
        Set<Character> set  = new HashSet<>();
        while (i < s.length()) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                result = Math.max(result, set.size());
                i++;
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return result;
    }

    /**
     * Time Complexity: O(n^3)
     * Space Complexity: O(min(n,m))
     * We need O(k) space for checking a substring has no duplicate characters
     */
    public static int lengthOfLongestSubstring1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <s.length() ; j++) {
                if(checkRepeat(s, i, j)) {
                    result = Math.max(result, j -i +1);
                }
            }
        }
     return result;
    }

    private static boolean checkRepeat(String s, int start, int end) {
        int[] chars = new int[128];
        for (int i = start; i <=end; i++) {
            char  c = s.charAt(i);
            chars[c] = chars[c]+1;
            if(chars[c] > 1) return false;
        }
        return true;
    }
}
