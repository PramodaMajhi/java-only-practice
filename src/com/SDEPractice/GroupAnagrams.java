package com.SDEPractice;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key  = String.valueOf(ch);
            if(!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
      String[] strs = {"eat","tea","tan","ate","nat","bat"};
      GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> res = groupAnagrams.groupAnagrams(strs);
        System.out.println(res);
    }
}
