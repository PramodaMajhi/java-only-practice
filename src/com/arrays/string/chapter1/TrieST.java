package com.arrays.string.chapter1;

import java.util.ArrayList;

/**
 * A String symbol table for extended ASCII string implemented using a 256-way
 * trie.
 * 
 * Search hit. Need to examine all L characters for equality
 *
 * Search Miss . could have mismatch on first character . Typical case: examine
 * only a few characters(sublinear)
 *
 * Space: R null links at each leaf. (but sublinear space possible if many short
 * string share common prefixes)
 *
 * Bottom line. fast search hit and even faster search miss, but wastes space.
 *
 * 
 *Goal: Design a data structure to perform efficient spell checking.
 *	Solution: Build 26-way trie (key=word, value = bit)
 */

public class TrieST<Value> {

	private static final int R = 128; // 256; // extended ASCII

	private Node root; // root of trie
	private int n; // number of keys in trie

	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}

	/*
	 * Initializes an empty string symbol table.
	 */
	public TrieST() {

	}

	/*
	 * Returns the value associated with the given key The value associated with the
	 * given key id the key is in symbol table and {@code null} if the key is not in
	 * the symbol table.
	 * 
	 * if the value is null, this effectively deletes the key from symbol table.
	 */

	public Value get(String key) {
		if (key == null) {
			throw new IllegalArgumentException("Argument to get() is null");
		}
		Node x = get(root, key, 0);
		if (x == null) {
			return null;
		}

		return (Value) x.val;
	}

	public Node get(Node x, String key, int d) {

		if (x == null) {
			return null;
		}
		if (d == key.length()) {
			return x;
		}
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}

	public void put(String key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("first Argument to put is null");
		if (val == null)
			delete(key);
		else {
			root = put(root, key, val, 0);
		}

	}

	public Node put(Node x, String key, Value val, int d) {

		if (x == null) { // root node is not null because we created a new object
			x = new Node();
		}
		if (d == key.length()) { // our length is not 0 because we have key to add.
			if (x.val == null) {
				n++; // increment the count of trie table
				x.val = val;
				return x;
			}
		}
		char c = key.charAt(d); // started picking a character from start of the string key.
		x.next[c] = put(x.next[c], key, val, d + 1);

		return x;
	}

	/**
	 * Does this symbol contain a given key
	 * 
	 * @return
	 */

	public boolean contains(String key) {

		if (key == null)
			throw new IllegalArgumentException("Argument to contain() is null");
		return get(key) != null;

	}

	/**
	 * returns the size of trie
	 */
	public int size() {
		return n;
	}

	/*
	 * Is this symbol table is empty
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Removes the key from the set if the key is present
	 * 
	 * @param key
	 */
	public void delete(String key) {

		if (key == null)
			throw new IllegalArgumentException("Argument to delete() is null");
		root = delete(root, key, 0);
	}

	/**
	 * actual delete using recursive call
	 */
	private Node delete(Node x, String key, int d) {

		if (x == null)
			return null;
		if (d == key.length()) {
			if (x.val != null) {
				n--;
				x.val = null;
			}
		} else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		
		
		// remove subtrie rooted at x if it is completely empty
		if (x.val != null) {
			return x;
		}
		for (int c = 0; c < R; c++) {
			if (x.next[c] != null) {
				return x;
			}
		}
		return null;
	}

	/**
	 * Returns all keys in the symbol table as an Iterable. To iterate over all of
	 * the keys in the symbol table named. use the foreach notation:
	 * {@code for (Key key : st.keys())}. return all keys in the symbol table as an
	 * Iterable.
	 */

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	/**
	 * Returns all of the keys in the set that start with {@code prefix}.
	 * 
	 * @param prefix the prefix
	 * @return all of the keys in the set that start with {@code prefix}, as an
	 *         iterable
	 */

	public Iterable<String> keysWithPrefix(String prefix) {
		ArrayList<String> results = new ArrayList<String>();

		Node x = get(root, prefix, 0);

		collect(x, new StringBuilder(prefix), results);

		return results;
	}

	private void collect(Node x, StringBuilder prefix, ArrayList<String> results) {
		if (x == null) {
			return;
		}

		if (x.val != null) {
			results.add(prefix.toString());
		}
		for (char c = 0; c < R; c++) {
			prefix.append(c);
			collect(x.next[c], prefix, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}

	}

	/**
	 * Returns all of the keys in the symbol table that match 
	 * where '.' is interpreted as wild card 
	 * character. 
	 * 
	 **
	 * all the keys in the symbol table that match as as iterable 
	 * where . is treated as a wild card character. 
	 */
	
	
	public Iterable<String> keysThatMatch(String pattern) {
		
		ArrayList<String> results = new ArrayList<String>();
		collect(root, new StringBuilder(), pattern, results);
		return results;
	}

	public void collect(Node x, StringBuilder prefix, String pattern, ArrayList<String> results) {

		if (x == null)
			return;
		int d = prefix.length();
		if (d == pattern.length() && x.val != null) {
			results.add(prefix.toString());
		}

		if (d == pattern.length()) {
			return;
		}

		char c = pattern.charAt(d);
		
		if (c == '.') {
			for (char ch = 0; ch < R; ch++) {
				prefix.append(ch);
				collect(x.next[ch], prefix, pattern, results);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		} else {
			prefix.append(c);
			collect(x.next[c], prefix, pattern, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}

	}

	public static void main(String args[]) {
		
		// Build symbol table
		
		TrieST<String> st = new TrieST<String>();
		st.put("apple","0");
		st.put("grape","1");
		st.put("ape","2");
		st.put("she","3");
		st.put("santosh","4");
		// st.put("ape", "1");
		
//		for(String key: st.keys()) {
//			System.out.println(key + " " +st.get(key));
//		}
//		st.delete("a");
//		
//		for(String key: st.keys()) {
//			System.out.println(key + " " +st.get(key));
//		}
//		
		for (String s : st.keysWithPrefix("a"))
            System.out.println(s);
	}

}
