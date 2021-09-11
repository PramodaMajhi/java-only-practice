package mixedproblem;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*Given a string, find the length of the longest substring without repeating characters.
 * Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3.
*/
public class LongestSubString {

	public static void main(String[] args) {
		
		// Count repeated characters
		// CountRepeatCharacters();
		
   //  Length of Longest substrings
		String s  = "abcabcbb";
		
	System.out.println(lengthOfLongestSubstring(s));

	}

	private static void CountRepeatCharacters() {
		// Problem one where count repeated character 
		String s = "abcabcbb";
		int count =1;
		HashMap<Character, Integer> myhashMap = new HashMap<Character, Integer>();
	
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// System.out.print(c);
			if(myhashMap.containsKey(c)) {
				Integer value  = myhashMap.get(c);
			  myhashMap.put(c, new Integer(value +1));
			}
			else {
				myhashMap.put(c, 1);
			}
			
		}
		
		Iterator<Entry<Character, Integer>> itr  =  myhashMap.entrySet().iterator();
		while(itr.hasNext()) {
			 Map.Entry pair = (Map.Entry)itr.next();
			System.out.print(pair.getKey() + ""+ pair.getValue());
		}
		
	}
	
	public static  int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
