package mixedproblem;


import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	An input string is valid if:
	
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Note that an empty string is also considered valid.
	
	*
	* Complexity analysis

	* Time complexity : O(n)O(n) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1)O(1) time.
	* Space complexity : O(n)O(n) as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
	*
	*
 */

public class ValidParentheses {

	private static final char LEFT_PAREN = '(';
	private static final char RIGHT_PAREN = ')';
	private static final char LEFT_BRACE = '{';
	private static final char RIGHT_BRACE = '}';
	private static final char LEFT_BRACKET = '[';
	private static final char RIGHT_BRACKET = ']';

	public static void main(String[] args) {

		System.out.println(isValidParenth("()"));

	}

	public static boolean isValidParenth(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == LEFT_PAREN)
				stack.push(LEFT_PAREN);

			if (s.charAt(i) == LEFT_BRACE)
				stack.push(LEFT_BRACE);

			if (s.charAt(i) == LEFT_BRACKET)
				stack.push(LEFT_BRACKET);

			if (s.charAt(i) == RIGHT_PAREN) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFT_PAREN)
					return false;
			}
			if (s.charAt(i) == RIGHT_BRACE) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFT_BRACE)
					return false;
			}
			if (s.charAt(i) == RIGHT_BRACKET) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFT_BRACKET)
					return false;
			}

		}
		return stack.isEmpty();
	}
}
