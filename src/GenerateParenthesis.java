

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

public class GenerateParenthesis {

	public static void main(String[] args) {
		List<String> res = generateParenthesis(4);
		for (String s : res) {
			System.out.println(s);
		}
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0)
			return res;
		String str = new String();
		dfs(res, str, n, n);
		return res;
	}

	private static void dfs(List<String> res, String str, int leftP, int rightP) {
		if (leftP > rightP)
			return;
		if (leftP == 0 && rightP == 0) {
			res.add(new String(str));
			return;
		}
		if (leftP >= 0)
			dfs(res, str + '(', leftP - 1, rightP);
		if (rightP >= 0)
			dfs(res, str + ')', leftP, rightP - 1);
	}
}
