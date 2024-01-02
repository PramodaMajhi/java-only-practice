package com.structy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public boolean anagrams(String s1, String s2){
        char[] crr1 = s1.toCharArray();
        Arrays.sort(crr1);

        char[] crr2 = s2.toCharArray();
        Arrays.sort(crr2);
        String s1Sorted = new String(crr1);
        String s2Sorted = new String(crr2);
        return s1Sorted.equals(s2Sorted);
    }
    /*
    O(M+N)
    O(n) - Space
     */
    public boolean anagramsHash(String s1, String s2){
        Map<Character,Integer> hashmap = new HashMap<>();
        for (int i = 0; i <s1.length() ; i++) {
            char c = s1.charAt(i);
            if(!hashmap.containsKey(c)){
                hashmap.put(c, 1);
            }else {
                hashmap.put(c,hashmap.get(c) +1);
            }
        }

        for (int i = 0; i <s2.length() ; i++) {
            char c2 = s2.charAt(i);
            if(hashmap.get(c2)== null)
                return false;
            else{
                hashmap.put(c2, hashmap.get(c2) -1);
            }

        }
        for(Integer value: hashmap.values()){
            if(value != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagrams("tax", "taxi"));
        System.out.println(anagrams.anagramsHash("tax", "taxi"));
    }
}
