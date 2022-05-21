package com.SDEPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aaabbbcdd"));
        System.out.println(reorganizeStringPQ("aaabbbcdd"));
    }

    public static String reorganizeStringPQ(String S){
        if(S == null || S.length() == 0)
            return "";
        Map<Character, Integer> cMap = new HashMap<Character, Integer>();
        // store char frequency into map
        for(char c : S.toCharArray()) {
            cMap.put(c,cMap.getOrDefault(c,0)+1);
        }
        // Push all map entry into priority element,
        // by sorting from high frequency to low frequency

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a,b) ->(b.getValue() - a.getValue())
        );
        for(Map.Entry<Character,Integer> entry: cMap.entrySet()){
            pq.offer(entry);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character,Integer> cache = pq.poll();
            // If character in cache is different with tail character in current string
            if(stringBuilder.length() == 0 ||
                    cache.getKey()!=stringBuilder.charAt(stringBuilder.length() -1)) {
                stringBuilder.append(cache.getKey());
                cache.setValue(cache.getValue() - 1);
                // if current character still have more quota left,
                // push back to queue
                if(cache.getValue()!=0){
                    pq.offer(cache);
                }
            }
            // if character in cache is same as tail character in string
            // we need to try the character with the second-highest frequency
            else {
                Map.Entry<Character,Integer> cache2 = pq.poll();
                // corner case: if no more elements in queue, the input string should be invalid
                // because  we do not have any other characters that different with current string tail

                if(cache2 == null)
                    return "";
                stringBuilder.append(cache2.getKey());
                cache2.setValue(cache2.getValue() -1);
                // if current character still have more quota left, push back to queue
                if(cache2.getValue()!=0) {
                    pq.offer(cache2);
                }
                // do not forget to push frequency entry into queue as well
                pq.offer(cache);
            }
        }
        return stringBuilder.toString();
    }
/*
IDEA:
    1. Count letter appearance and store in hash[i]
    2. Find the letter with the largest occurrence.
    2. Put the letter into even index number (0, 2, 4 ...)
    char array put the rest into the array

    We construct the resulting string in sequence: at position 0, 2, 4, ...
    and then 1, 3, 5, ...
    In this way, we can make sure there is always a gap between the same characters

    Consider this example: "aaabbbcdd", we will construct the string in this way:
    a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
    a b a _ a _ b _ b // fill in "b" at position 6, 8, 10
    a b a c a _ b _ b // fill in "c" at position 3
    a b a c a d b d b // fill in "d" at position 5, 7
 */
    public static String reorganizeString(String S){
        int hash[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0; int letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if(hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if(max > S.length() + 1 /2){
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }


}
