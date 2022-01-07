package com.SDEPractice;

import java.util.Arrays;
import java.util.Locale;

public class Jan2 {

    public static void main(String[] args) {
        String sentence = "bbaaacbd";
        System.out.println(longestSubstringOne(sentence, 3));
    }
/*
395. Longest Substring with At Least K Repeating Characters
Given a string s and an integer k, return the length of the
longest substring of s such that the frequency of each character
in this substring is greater than or equal to k.
Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.


 */

    /*
    Time: O(n^2) for each recursive call its takes O(n) time to build the countMap
    resulting O(n^2)
    Space: O(n)
     */
    /*
    Algorithm:
    Build the countMap with the frequency of each character in the string s.
    Find the position for mid index by iterating over the string.
    The mid index would be the first invalid character in the string.
    Split the string into 2 substrings at the mid index and recursively find the result.
    To make it more efficient, we ignore all the invalid characters after
    the mid index as well, thereby reducing the number of recursive calls.
     */
public static int longestSubstringOne(String s, int k) {

    return longestSubstringUtil(s,0, s.length(), k);
}

    public static int longestSubstringUtil(String s, int start, int end, int k) {

        if(end < k ) return 0;
        int[] countMap = new int[26];
        // Update the countMap with the count of each character

        for(int i = start; i < end ; i ++) {
            countMap[s.charAt(i) - 'a'] ++;
        }
        // "bbaaacbd";
        for(int mid = start; mid < end ; mid++) {
           // System.out.println(countMap[s.charAt(mid)- 'a']);
            if(countMap[s.charAt(mid)- 'a'] >= k){
                continue;
            }


            int midNext = mid +1;
            while(midNext < end && countMap[s.charAt(midNext) - 'a'] < k) {
                midNext++;
            }
            int midVal = longestSubstringUtil(s,start,mid,k);
            int midNextVal = longestSubstringUtil(s,midNext,end,k);
            return Math.max(midVal, midNextVal);
        }

        return end - start;
    }
    public static int longestSubstring(String s, int k) {
        if((s == null) || (s.isEmpty()) || (k > s.length()))
        return 0;
        
        int[] countMap = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // reset the countMap
            Arrays.fill(countMap,0);
            for (int j = i; j <s.length() ; j++) {
                countMap[s.charAt(j) - 'a'] ++;
                if(isValid(s, i, j, k, countMap)) {
                    result = Math.max(result, j - i +1);
                }
            }
        }
        return result;
    }
    private static boolean isValid(String s, int start, int end, int k, int[] countMap) {
        int countLetters = 0;
        int countAtleastK = 0;
        for(int freq: countMap) {
            if(freq > 0 ) countLetters ++;
            if(freq >=k) countAtleastK++;
        }
        return countLetters == countAtleastK;
    }
   /*
   824. Goat Latin
    Input: sentence = "I speak Goat Latin"
    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

    */
   public static String toGoatLatin(String sentence) {

       if(sentence == null) return null;

       String arr[] = sentence.split(" ");
       String vowels = "aeiou";
       StringBuilder sb = new StringBuilder();
       String a = "a";
       for (int i = 0; i <arr.length; i++) {
           String s = arr[i];
               char c  = s.charAt(0);
               if(vowels.contains(Character.toString(c).toLowerCase())) {
                   sb.append(s);

               } else {
                   String sub = s.substring(1);
                   sb.append(sub);
                   sb.append(c);
               }
               sb.append("ma");
               for (int j = 0; j <=i; j++) {
                   sb.append(a);
               }
               if(i!=arr.length-1)
                 sb.append(" ");
       }
       return sb.toString();
   }

}
