package LeetCodeDailyChallenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicateString2 {

    public static String removeDuplicates(String s, int k) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i) && k!=0) {
                stack.pop();
                k--;
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.toString();
    }
}
