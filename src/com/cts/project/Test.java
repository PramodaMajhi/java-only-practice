package com.cts.project;

import sun.jvm.hotspot.gc_implementation.parallelScavenge.PSYoungGen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String s  = "ss"; // take any input test
        Map<Character, Integer> result = getCharacterCount(s);

        for(Map.Entry<Character,Integer> entry: result.entrySet()){
            char ch = entry.getKey();
            int  count = entry.getValue();
            System.out.println(" Character " + ch + "   count   > " + count);
        }
        System.out.println(Arrays.toString(getCharacterCounts(s)));

    }
    // This method will return hashmap with each character and their count
    public  static Map<Character, Integer> getCharacterCount(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }
        return hashMap;
    }
    public  static int[] getCharacterCounts(String s) {
        int[]chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            chars[ch]++;
        }
        return chars;
    }
}
