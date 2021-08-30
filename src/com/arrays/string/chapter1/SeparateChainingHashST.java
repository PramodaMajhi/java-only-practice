package com.arrays.string.chapter1;

import java.util.ArrayDeque;
import java.util.Queue;


// Design and implement a hash table which uses chaining (Link list) to handle collisions

/*
 * This is a very light version
 */

/*
 *  This implementation uses a separate chaining hash table. It requires that
 *  the key type overrides the {@code equals()} and {@code hashCode()} methods.
 *  The expected time per <em>put</em>, <em>contains</em>, or <em>remove</em>
 *  operation is constant, subject to the uniform hashing assumption.
 *  The <em>size</em>, and <em>is-empty</em> operations take constant time.
 *  Construction takes constant time.
 */
public class SeparateChainingHashST<Key, Value> {
	private static final int INIT_CAPACITY = 4;
	
	 private int n; // Number of key-value pairs
	 private int m; // hash table size
	 private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables

	 // Initialize an empty symbol table 
	
	 public SeparateChainingHashST() {
		 this(INIT_CAPACITY);
	 }

	 // Initialize an empty symbol table with m chains
	 /**
	  * 
	  * @param m
	  * The m represents the initial number of chains
	  */

	public SeparateChainingHashST(int m) {
		this.m = m;
		st =  (SequentialSearchST<Key,Value>[]) new SequentialSearchST[m];
		for (int i = 0; i < m; i++) {
			st[i] = new SequentialSearchST<Key,Value>();
		}
		
	}
	
	// resize the hash table to have the given number of chains 
	// rehashing all of the keys
	
	private void resize(int chains) {
		
		SeparateChainingHashST<Key, Value> temp  = new SeparateChainingHashST<Key, Value>();
		for(int i =0; i < m; i ++) {
			for(Key key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}
		this.m = temp.m;
		this.n = temp.n;
		this.st = temp.st;
	}
	
	private int hashTextbook(Key key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}
	
	// hash function for keys - returns value 0 and m-1 (assume m is a power 2)
	// from java 7 implementation, protects against poor quality hashCode() implementations) 
	
	private int hash(Key key) {
		int h = key.hashCode();
		h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
		return h & (m-1);
	}
	
	// Returns the number of key-value pairs in the symbol table.
	
	public int size() {
		
		return n;
	}
	
	// Returns true if the symbol table is empty
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// returns true if the specified key contains in symbol table 
	
	public boolean contains(Key key) {
		if(key == null) throw new IllegalArgumentException("Argument contains null");
		
		return get(key)!=null; 
	}
	
	// Returns the value associated with specified key in the symbol table.
	/*
	 * * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	
	public Value get(Key key) {
		if(key == null) throw new IllegalArgumentException("Argument to get() is null");
		
		int i  = hash(key); // get the hashcode
		return st[i].get(key);
	}
	
	/**
	 * Insert the specified key-value pair into the symbol table. overwriting the old value with the new value 
	 * if the symbol table already contains the specified key
	 * 
	 * Deletes the specified key (and its associated value) from this symbol table 
	 * if the specified value is null
	 */
	
	public void put(Key key , Value value) {
		if(key == null) throw new IllegalArgumentException("Argument to put is null");	
		if(value == null) {
			delete(key);
			return;
		}
		
		// Double the table size if average length of list  >=10
		
		if(n >= 10 * m)  {
			resize(2*m);
		}
		
		int i  =  hash(key);
		if(!st[i].contains(key)) {
			n++;
		}
		
		st[i].put(key,value);
	}
	
	/**
	 * Removes the specified key and its associated value from the symbol table.
	 * if the key is in this symbol table 
	 * @param key
	 */
	public void delete(Key key) {
		
		if(key == null) throw new IllegalArgumentException("Argument to delete() is null");
		
		int i = hash(key);
		if(st[i].contains(key)) n--;
		st[i].delete(key);
		
		if(m > INIT_CAPACITY && n <= 2*m) resize(n/2);
		
	}
	
	public Iterable<Key> keys() {
		 Queue<Key> queue = new ArrayDeque<Key>();
		// ArrayList<Key> list = new ArrayList(); 
		for (int i = 0; i < m; i++) {
			for(Key key : st[i].keys())
			 queue.add(key);
		}
		return (Iterable<Key>) queue;
	}
	
	public static void main(String args[]) {
		SeparateChainingHashST<String, Integer> st  = new SeparateChainingHashST<String, Integer>();
		st.put("a", 1);
		st.put("b", 2);
		st.delete("b");
		
		 for(String s : st.keys()) {
			 System.out.println(st.get(s));
		 }
		
	}
	
}
	