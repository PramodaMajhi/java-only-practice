package com.arrays.string.chapter1;



public class StringandArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(reverseAString("Hello"));
		 System.out.println(isUniqueCharacters("zabca"));
		//System.out.println(reverseUsingHalfway("abc"));

	}
	/* Q1: Reverse a string
	 * 
	 * Traverse only of half of string (n/2)  and swap character with start and end 
	 * using temporary variable. String is an immutable.
	 */
	public static String reverseAString(String s) {
		
		char c[] = s.toCharArray();
		int i = 0, j = s.length()-1 ;
		
		while(i < j) {
			char temp  = c[i];
			c[i] = c[j];
			c[j] = temp;
			j--;
			i++;
		}
		return new String(c);
	}
	
	public static String reverseUsingHalfway (String s) {
		// abc
		char c[] = s.toCharArray();
		for (int i = 0; i < c.length/2; i++) {
			char temp = c[i];
			c[i] = c[c.length -i - 1];
			c[c.length -i - 1] = temp;
			
		}
		return new String(c);
	}
	
	/*Q2 
	 * 
	 * Implement an algorithm to determine if a string has all unique characters.
	 * what if you can't use additional data structure ?
	 * 
	 * Note:   Create boolean array of 128 ASCII character and keep marking
	 * Complexity : O(n) and O(1) where n is the length of string
	 */
	
	public static boolean isUniqueCharacters(String str) {
		
		if(str.length() > 128) {
			return false;
		}
		
		boolean bol [] = new boolean [128];
		
		for(int i=0; i <str.length(); i++) {
			int val = str.charAt(i);
			System.out.println(val+ " from char at " +i);
			if(bol[val]) { // already found this char in string.
				return false;
			}
			else {
				bol[val] = true;
			}
			//System.out.println(val);
		}
		
		
		
		return true;
		
	}
	

}
