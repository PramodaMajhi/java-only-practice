package com.gfg.dp;

import java.util.*;

public class LongestStrChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<>();
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words); // added to set
        int ans = 0;
        for (String word : words){
            ans =  Math.max(ans, dfs(wordsPresent, memo, word));
        }
        return  ans;
    }

    private int dfs(Set<String> words, Map<String, Integer> memo, String currentWord){
        // if the word is encountered previously we just return its value present
        // in the map
        if(memo.containsKey(currentWord))
            return memo.get(currentWord);
        // This stores the maximum length of the word sequence possible with the currentWord
        int maxLength = 1;
        StringBuilder stringBuilder = new StringBuilder(currentWord);
        // Creating all possible string taking out one character at a time from the currentWord
        for (int i = 0; i < currentWord.length()    ; i++) {
            stringBuilder.deleteCharAt(i);
            String newWord = stringBuilder.toString();
            // if the new word formed present in the list. we do a dfs search with newWord
            if(words.contains(newWord)){
                int currentLength = 1 + dfs(words,memo,newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            stringBuilder.insert(i,currentWord.charAt(i));
        }
        memo.put(currentWord,maxLength);
        return maxLength;
    }
    public static void main(String[] args) {
        String[]words = {"a","b","ba","bca","bda","bdca"};
        LongestStrChain obj = new LongestStrChain();
        System.out.println(obj.longestStrChain(words));
    }
}
