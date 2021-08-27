package com.arrays.string.chapter1;
/**
 * A String symbol table for extended ASCII string implemented using a 256-way trie.
 * 
 *Search hit. Need to examine all L characters for equality
 *
 *Search Miss
 *	. could have mismatch on first character
 *	. Typical case: examine only a few characters(sublinear)
 *
 *Space: 
 *		R null links at each leaf.
 *		(but sublinear space possible if many short string share common prefixes)
 *
 *Bottom line. fast search hit and even faster search miss, but wastes space.
 *
 *Goal: Design a data structure to perform efficient spell checking.
 */

public class TrieST<Value> {

	private static final int R = 256; // extended ASCII

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
	 * if the value is null, this effectively delets the key from symbol table.
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

}
