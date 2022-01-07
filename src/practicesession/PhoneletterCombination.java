package practicesession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PhoneletterCombination {

	public static ArrayList letteCombi(String str) {
		String phoneKeypad [] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		ArrayList<String> finalList = new ArrayList<String>();
		
		finalList.add("");
		
		for(int i =0 ; i < str.length(); i ++) {
			int inputNumber = Character.getNumericValue(str.charAt(i));
			String letters = phoneKeypad[inputNumber];

			// combination logic
			while(finalList.get(0).length() == i) {
				String top = finalList.remove(0);
				for(char c : letters.toCharArray()) {
					finalList.add(top+c);
				}
			}

		}
		return finalList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> result = letteCombi("23");
		for(String s : result) {
			System.out.println("" + s);

		}
		
	}

}
