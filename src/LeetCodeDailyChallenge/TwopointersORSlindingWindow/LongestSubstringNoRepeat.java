package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstringBF(String s){
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len ; j++) {
                if(hasAllUniqueChar(s, i, j)){
                    res  = Math.max(res, j -i + 1);
                }
            }
        }
        return res;
    }
    private boolean hasAllUniqueChar(String s , int start , int end){
        int[] chars = new int[128];
        for (int k =start ; k <= end ; k++) {
            char c = s.charAt(k);
            chars[c]++;
            if(chars[c] > 1)
                return false;
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s){

        Set<Character> set  = new HashSet<Character>();
        int start = 0;
        int max = 0, j = 0;
        // pwwkew
        while (start < s.length()) {
            if(!set.contains(s.charAt(start))){
                set.add(s.charAt(start));
                start++;
                max = Math.max(max, set.size());
            }else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringMapApproach(String s) {
        int left = 0, right = 0;
        int max = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            char c  = s.charAt(right);
            map.put(c, map.getOrDefault(c,0) +1);
            if(map.get(c) > 1) {
                counter++;
            }
            right++;

            while (counter > 0){
                char cTemp = s.charAt(left);
                if(map.get(cTemp) > 1){
                    counter--;
                }
                map.put(cTemp, map.get(cTemp) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
    public static void main(String[] args) {
        String s =  "pwwkew"; //"abcabcbb";
        // Output: 3
        LongestSubstringNoRepeat repeat = new LongestSubstringNoRepeat();
        int ans = repeat.lengthOfLongestSubstringBF(s);
        System.out.println(ans);
        int ans1 = repeat.lengthOfLongestSubstring(s);
        System.out.println(ans1);
        System.out.println(repeat.lengthOfLongestSubstringMapApproach(s));
    }
}
