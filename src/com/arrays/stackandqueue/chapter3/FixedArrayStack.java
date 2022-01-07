package com.arrays.stackandqueue.chapter3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class FixedArrayStack<Item> implements  Iterable<Item> {

    private Item [] arr;
    private int size;
    private static final int INITIAL_CAPACITY = 5;
    FixedArrayStack() {
        arr = (Item[])new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean isFull() {
        return arr.length == size;
    }
    public boolean isEmpty(){
        return  size == 0;
    }

    public Item peek() {
        return arr[size-1];
    }

    /**
     * We double the size of the array in push() if it is full;
     *
     * @param item
     */
    public void push(Item item) {
        // dynamic array resize
        if(arr.length == size) {
            resize(2*arr.length);
        }
        arr[size++] = item;
    }

    /**
     * We halve the size of the array in pop() if it is less than one-quarter full.
     * @return
     */
    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item  = arr[size -1];
        arr[size-1] = null; // loitering/ garbage collection
        size --;
        // Shrink size of array if necessary,
        // We halve the size of the array in pop() if it is less than one-quarter full.
        if(size > 0 && size == arr.length/4){
            resize(arr.length/2);
        }
        return item;

    }

    /**
     * resize the underlying array holding the elements
     * @param capacity
     */
    private void resize(int capacity) {
        assert capacity >= size;
        // text book implementation
        Item[] copy  = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[i];
        }
        arr = copy;
    }

    public int size() {
        return size;
    }


    public Iterator<Item> iterator()  { return new ReverseArrayIterator(); }


    public class ReverseArrayIterator implements Iterator<Item> {
        private int i = size-1;

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arr[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public static void main(String[] args) {

        FixedArrayStack stack = new FixedArrayStack();

        for (int i = 500; i > 0; i--) {
            stack.push(i);
        }


        Iterator itr = stack.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

}
