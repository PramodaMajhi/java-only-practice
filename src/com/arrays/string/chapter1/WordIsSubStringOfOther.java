package com.arrays.string.chapter1;

/*
 * Assume you have a method isSustring which checks if one word is a substring another.
 * 
 * Given two strings, s1 and s2, write code to check,
 *  if s2 a rotation of s1 using one call to isSubstring(i.g "waterbottle" is a rotation of "erbottlewat"
 */

public class WordIsSubStringOfOther {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isRotation("waterbottle", "erbottlewat"));

	}
	
	/*
	 *  Checking whether substring of other
	 */
	public static boolean isSubstrings(String big, String small) {
		
		if(big.indexOf(small) >= 0) {
			
			return true;
		} else {
			return false;
		}				
	}
	
	/*
	 * Cut s1 into two parts  x and y
	 * s1 = = xy = waterbottle
	 * x = wat
	 * y = erbottle
	 * s2 = yx = erbottlewat
	 * 
	 */
	
	public static boolean isRotation(String s1 , String s2) {
		
		// Check both string s1 and s2 are equal and not empty
		
		if(s1.length() == s2.length() && s1.length() > 0) {
			
			String s1s1 = s1 + s1 ;
			
			return isSubstrings(s1s1, s2);
		}
		return false;
		
	}
	

}
