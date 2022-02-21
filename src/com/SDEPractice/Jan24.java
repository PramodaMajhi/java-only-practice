package com.SDEPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Jan24 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");
       // Collections.sort(dictionary);
        Collections.sort(dictionary, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
        System.out.println(findLongestWord(s, dictionary));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        List<String> subsetRes = generateSubsets(s, "", 0, new ArrayList<String>());
        String res="";
        for (String str: subsetRes) {
             if(dictionary.contains(str)) {
                 if(res.length() <= str.length()) {
                     res = str;
                 }
             }
        }

        return res;
    }

    public static  List<String> generateSubsets(String s, String curr, int index, List<String> list) {
        if(index == s.length()) {
           // System.out.println(curr);
            list.add(curr);
            return list;
        }
        list =  generateSubsets(s, curr, index+1, list);
        list = generateSubsets(s, curr + s.charAt(index), index+1, list);
        return list;
    }
}
