package com.arrays.stackandqueue.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * The class represents a last-in-first-out(LIFO) stack for generic items
 * This implementation uses a single link list with a static nested class for link list node
 * 
 * See {@link ResizingArrayStack} for a version that uses a resizing array.
 *  The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 */
public class LinkStack<Item> implements Iterable<Item> {

	private Node<Item> first; // top of stack 
	private int n;  // size of the stack
	
	private static class Node<Item>  {
		private Item item;
		private Node<Item> next;
	}
	
	// Initializes an empty stack
	
	public  LinkStack() {
		first = null;
		n = 0;
	}
	
	/*
	 * 
	 * Returns true if this stack is empty, false otherwise
	 * 
	 */
	
	public boolean isEmpty() {
		return first ==  null;
	}
	
	// returns the number of items in the stack
	
	public int size() {
		return n;
	}
	
	// add the item to this stack
	
	public void push(Item item) {
		Node<Item> oldfirst = first;
		first  = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		
	}
	
	public Item pop() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		
		Item item = first.item;  // Save item to return
		first = first.next;						 // delete first node
		n--;
		return item;
	}
	
	/*
	 * Returns 	(but does not remove) the item most recently added to this stack
	 */
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}
	
	
	/*
	 * 
	 * Returns a string representation of this stack
	 * Return the sequence of items in this stack in LIFO order, separated by spaces
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		for(Item item : this) {
			s.append(item);
			s.append(" ");
		}
		
		return s.toString();
		
	}
	
	  /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
	
public static void main(String args[]) {
		
	LinkStack<String> s= new LinkStack<String>();
	
	s.push("a");
	s.push("b");
	s.push("c");
	
	Iterator itr = s.iterator();
	while (itr.hasNext()) {
		System.out.println(itr.next());
		
	}
	
	
	}
    
    
    

}
