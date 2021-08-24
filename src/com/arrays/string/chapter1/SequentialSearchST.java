package com.arrays.string.chapter1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;



/**
 * This implementation uses a singly-linked list and sequential search. It
 * relies on the {@code equals()} method to test whether two keys are equal. It
 * does not call either the {@code compareTo()} or {@code hashCode()} method.
 * The <em>put</em> and <em>delete</em> operations take linear time; the
 * <em>get</em> and <em>contains</em> operations takes linear time in the worst
 * case. The <em>size</em>, and <em>is-empty</em> operations take constant time.
 * Construction takes constant time.
 */

public class SequentialSearchST<Key, Value> {

	private int n; // Number of key-value paired
	private Node first; // the link list of key-value pairs

	private class Node {
		private Key key;
		private Value value;
		private Node next;

		public Node(Key key, Value val, Node next) {

			this.key = key;
			this.value = val;
			this.next = next;
		}

	}

	// Initializes an empty symbol table.
	public SequentialSearchST() {

	}

	// Returns the number of key-value pairs in the symbol table

	public int size() {
		return n;

	}

	// Check if the symbol table is empty or not

	public boolean isEmpty() {
		return size() == 0;

	}

	// Does the symbol table contains given key

	public boolean contains(Key key) {
		return get(key) != null;
	}

	// Returns the value associated with the key
	public Value get(Key key) {

		for (Node x = first; x != null; x = x.next) {
			if (x.key.equals(key)) {
				return x.value;
			}
		}

		return null;

	}

	//
	/**
	 * Insert the key-value pair into symbol table, overwriting the old value with
	 * new one if key is already exist if the value is null, this effectively
	 * deletes the key from symbol table.
	 */

	public void put(Key key, Value val) {
		if (val == null) {
			delete(key); 
			return;
		}

		for (Node x = first; x != null; x = x.next) {

			if (key.equals(x.key)) {
				x.value = val;
				return;
			}
		}

		first = new Node(key, val, first); // creating a new item in the symbol table.
		n++; // Incrementing the size

	}

	/*
	 * Removes the key and associated value from the symbol table (if the key is in
	 * the symbol table).
	 */
	public void delete(Key key) {
		first = delete(first, key);

	}

	private Node delete(Node head, Key key) {

		if (key == null) {
			return null;
		}
		if (key.equals(head.key)) {
			n--;
			return head.next;
		}

		head.next = delete(head.next, key);
		return head;
	}
	
	public Iterable<Key> keys() {
		 Queue<Key> queue = new ArrayDeque<Key>();
		// ArrayList<Key> list = new ArrayList(); 
		for (Node x = first; x != null; x = x.next) {
			 queue.add(x.key);
		}
		return (Iterable<Key>) queue;
	}

	public static void main(String[] args) {
		SequentialSearchST<Integer, String> st = new SequentialSearchST<Integer, String>();
		st.put(1, "a");
		st.put(2, "b");
		st.delete(1);

		for(Integer a : st.keys()) {
			System.out.println(a + " " + st.get(a));
		}
		
		

	}

}
