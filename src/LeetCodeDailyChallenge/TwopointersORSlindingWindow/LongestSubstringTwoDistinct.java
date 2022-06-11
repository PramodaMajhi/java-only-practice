package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int left = 0, right = 0;
        int counter = 0, max = 0;
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequencies of the Characters)
        Map<Character,Integer> map  = new HashMap<>();
        while (right < s.length()){
            char c = s.charAt(right);// right pointer
            map.put(c, map.getOrDefault(c,0)+1);
            if(map.get(c) == 1) // new character, number of distinct
                counter++;
            right++;
            while (counter > 2){
                char cTemp = s.charAt(left);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }


    public static void main(String[] args) {
        String s =  "eceba"; //"abcabcbb";
        // Output: 3
        LongestSubstringTwoDistinct twoDistinct = new LongestSubstringTwoDistinct();
        int ans = twoDistinct.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(ans);
    }
}
