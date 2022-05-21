package com.SDEPractice;

import java.util.*;

public class RankTeams {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int wordLength = votes[0].length();
        for(String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char ch = vote.charAt(i);
                map.putIfAbsent(ch, new int[wordLength]);
                map.get(ch)[i]++;
            }
        }
        List<Character> list  = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a,b) -> {
            for (int i = 0; i < wordLength; i++) {
                if(map.get(a)[i]!=map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });
        StringBuilder stringBuilder  = new StringBuilder();
        for (char c : list) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[]votes = {"ABC","ACB","ABC","ACB","ACB"};
        RankTeams rankTeams = new RankTeams();
        String str =  rankTeams.rankTeams(votes);
        System.out.println(str);
    }
}
