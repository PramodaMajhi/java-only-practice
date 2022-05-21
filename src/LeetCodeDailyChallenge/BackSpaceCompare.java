package LeetCodeDailyChallenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackSpaceCompare {
    public static void main(String[] args) {
        String  s = "a#c", t = "b";
        System.out.println(backspaceCompare(s, t));
    }
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length() ; i++) {
            char c = stringBuilder.charAt(i);
            if(c != '#') {
                stringBuilder.append(c);
            } else {
                if(stringBuilder.length() > 0)
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
        StringBuilder stringBuilder1 = new StringBuilder(t);
        for (int i = 0; i < t.length() ; i++) {
            char c = stringBuilder1.charAt(i);
            if(c != '#') {
                stringBuilder1.append(c);
            } else {
                stringBuilder1.deleteCharAt(stringBuilder1.length()-1);
            }
        }
        return stringBuilder.toString().equals(stringBuilder1.toString());
    }

    public String build(String S) {
        Deque<Character> ans = new ArrayDeque();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.isEmpty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
