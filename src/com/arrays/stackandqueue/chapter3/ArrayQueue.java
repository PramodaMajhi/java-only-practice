package com.arrays.stackandqueue.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<Item> implements Iterable<Item>{
    private static final int INITIAL_CAPACITY = 5;
    private  Item arr[];
    private int first;
    private int last;
    private int size;

    public ArrayQueue() {
        arr = (Item[]) new Object[INITIAL_CAPACITY];
        first = 0;
        last = 0;
        size = 0;
    }

    // size
    public int size() {
        return size;
    }
    // empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // isFull
    public boolean isFull() {
       return size == arr.length;
    }

    public Item peek() {
        if(isEmpty()) throw  new NoSuchElementException("Queue underflow");
        Item item  = arr[first];
        return item;
    }
    // Double the size
    private void resize(int capacity) {
        assert capacity >= size;
        Item[] copy  = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[(first + i) % arr.length];
        }
        arr = copy;
        first = 0;
        last = size;
    }
    // enqueue
    public void enqueue(Item item) {
        if(size == arr.length) resize(2*arr.length);
        arr[last++] = item;
        if(last == arr.length) {
            last = 0;
        }
        size++;
    }

    // dequeue
    public Item dequeue() {
        Item item  = arr[first];
        arr[first] = null; // loitering
        first++;
        size--;
        if(first == arr.length) first = 0;
        // shrink the size
        if(size > 0  && size == arr.length/4) resize(arr.length/2);
        return item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < size;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = arr[(i + first) % arr.length];
            i++;
            return item;
        }
    }
    private class QueueIterator implements Iterator<Item> {
        private  int i =0;
        @Override
        public boolean hasNext() {return i < size;}

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item =  arr[(i + first) % arr.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 1; i <=50; i++) {
            arrayQueue.enqueue(i);
        }
        arrayQueue.dequeue();
        System.out.println("peek -> " +arrayQueue.peek());

        Iterator itr = arrayQueue.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
