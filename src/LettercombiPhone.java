
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.OutputDeviceAssigned;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:

	Input: "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	
	*
* Approach 1: Backtracking
* Backtracking is an algorithm for finding all solutions by exploring all potential candidates. 
* If the solution candidate turns to be not a solution (or at least not the last one), 
* backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.

 Here is a backtrack function backtrack(combination, next_digits) which takes as arguments an ongoing letter combination and the next digits to check.

	If there is no more digits to check that means that the current combination is done.
	If there are still digits to check :
	Iterate over the letters mapping the next available digit.
	Append the current letter to the current combination combination = combination + letter.
	Proceed to check next digits : backtrack(combination + letter, next_digits[1:]).
	*
	*
	*Video
	*https://www.youtube.com/watch?v=QnemnSpaTKU
	*https://www.youtube.com/watch?v=21OuwqIC56E
 */
public class LettercombiPhone {
	static Map<String, String> phone = new HashMap<String, String>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	static List<String> output = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> result = phoneLetters("23");
		// letterCombs("23");
		// letterCombinations("23");
		for (String letter : result) {
			System.out.println(letter);
		}

	}

	/**
	 * Time Complexity The numbers in input string can represent strings of length
	 * of 3 or 4. Let m be the number of digits that map to 3 letters and n be the
	 * number of digits that map to 4 letters. Thus, the overall time complexity
	 * will be O(3m × 4n).
	 * 
	 * Space Complexity The recursive call will use the stack memory equal to O(3m ×
	 * 4n) and this will be the space complexity.
	 * 
	 * 
	 * 
	 * @param combination
	 * @param next_digits
	 */

	public static void backtrack(String combination, String next_digits) {

		if (next_digits.length() == 0) {
			output.add(combination);
		}

		// if there are still digits to check
		else {
			// iterate over all letters which map the next available digit

			String digit = next_digits.substring(0, 1);
			String letters = phone.get(digit);

			for (int i = 0; i < letters.length(); i++) {
				String letter = phone.get(digit).substring(i, i + 1);
				// append the current letter to the combination
				// and proceed to the next digits
				backtrack(combination + letter, next_digits.substring(1));
			}
		}

	}

	public static List<String> letterCombinations(String digits) {

		if (digits.length() != 0)
			backtrack("", digits);
		return output;
	}

	public static List<String> letterCombs(String digits) {

		List<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0) {
			return result;
		}

		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		letterCombiRecursive(result, digits, "", 0, mapping);

		return result;
	}

	public static void letterCombiRecursive(List<String> result, String digits, String current, int index,
			String[] mapping) {

		if (index == digits.length()) {
			result.add(current);
			return;
		}

		String letters = mapping[digits.charAt(index) - '0'];

		for (int i = 0; i < letters.length(); i++) {
			letterCombiRecursive(result, digits, current + letters.charAt(i), index + 1, mapping);
		}
	}

	public static List<String> phoneLetters(String number) {
		List<String> answer = new ArrayList<String>();
		answer.add(""); // empty string for first removal should not throw exceptions

		String[] phone = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		for (int i = 0; i < number.length(); i++) {

			int workingNumber = Character.getNumericValue(number.charAt(i));

			while (answer.get(0).length() == i) {
				String top = answer.remove(0);
				for (char c : phone[workingNumber].toCharArray()) {
					answer.add(top + c);
				}
			}

		}
		return answer;
	}

}
