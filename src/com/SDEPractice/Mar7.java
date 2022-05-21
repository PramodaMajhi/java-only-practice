package com.SDEPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mar7 {
    public static void main(String[] args) {
       String s = "??yw?ipkj?";
        System.out.println(modifyString(s));
    }
    public static String modifyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i < s.length() -1; i ++) {
            stringBuilder.append(s.charAt(i));
            if(s.charAt(i) == '?') {
                stringBuilder.deleteCharAt(i);
                char ch = s.charAt(i);
                if( i == s.length()) {
                    ch = ch == 'z' ? 'a' : (char)((s.charAt(i-1) +1));
                } else
                {
                    ch = ch == 'z' ? 'a' : (char)((s.charAt(i+1) +1));
                }

               // System.out.println(val);

                int a = ch;
                if(a >= 97 && a <= 122)
                    stringBuilder.append(ch);
                else {
                    stringBuilder.append('z');
                }
            }
        }
        return stringBuilder.toString();
    }
    public static boolean hasAllCodes(String s, int k) {
     Set<String> set = new HashSet<>();
     int need = 1 << k;
        for (int i = 0; i <= s.length()-k; i++) {
            String match  = s.substring(i, k);
            System.out.println(match);
            set.add(match);
        }
        System.out.println(set);
     return set.size() == need;// Math.pow(2,k);
    }
    private static void generateSubsets(String s, String curr, int index, Set<String> set, int k) {
        if(s.length() == index) {
            if(curr.length() == k)
               set.add(curr);
            return;
        }
        generateSubsets(s, curr, index+1, set, k);
        generateSubsets(s, curr+s.charAt(index), index+1, set, k);
    }
}
