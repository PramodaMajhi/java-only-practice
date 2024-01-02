package com.structy;

import java.util.HashMap;

public class MostFrequentChar {
    public char  mostFrequentChar(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char ch: s.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch,1) +1);
        }
        char temp = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if(hashMap.get(s.charAt(i)) > hashMap.get(temp)){
                temp = s.charAt(i);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        MostFrequentChar mostFrequentChar = new MostFrequentChar();
        System.out.println(mostFrequentChar.mostFrequentChar("riverbed"));
    }
}
