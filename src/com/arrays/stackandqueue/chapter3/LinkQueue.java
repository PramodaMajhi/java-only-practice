package com.arrays.stackandqueue.chapter3;

import com.chicago.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkQueue <Item> implements Iterable<Item> {

    private Node<Item> first; // beginning of the queue
    private Node<Item> last; // end of the queue
    private int size; // size of the queue


    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }
    // create an empty queue
    public LinkQueue() {
        first = null;
        last = null;
        size = 0;
    }

    // add item into queue
    public void enqueue(Item item) {
        // add the item into the queue
        Node<Item>  lastOld = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            lastOld.next = last;
        }
        size++;
    }

    // remove the last recently added item
    public Item dequeue() {
        if(isEmpty()) throw  new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        size --;
        if(isEmpty()) last = null; // avoid loitering/ garbage collect
        return item;
    }

    /*
    Returns the item least recently added to this queue
     */

    public  Item peek() {
        if(isEmpty()) throw new  NoSuchElementException("Queue is underflow");
        return first.item;
    }
    // is the queue empty?

    public boolean isEmpty() {
        return first == null;
    }
    // number of items in the queue

    public int size () {
        return  size;
    }
// returns string representation of this queue

    /**
     *
     * @return an iterator that iterates over the items in this queue in FIFO
     */
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(Item item : this) {
            stringBuilder.append(item);
            stringBuilder.append(" ");
        }
        stringBuilder.append("]");
        return  stringBuilder.toString();

    }
    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }
    private class LinkedIterator implements  Iterator<Item>{
        private Node<Item> current;
        public LinkedIterator(Node<Item> first) {
           this.current = first;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw  new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.enqueue(1);
        linkQueue.enqueue(2);
        linkQueue.enqueue(3);
        linkQueue.dequeue();
        linkQueue.enqueue(4);
        linkQueue.enqueue(5);
        System.out.println(linkQueue.toString());
        System.out.println(linkQueue.size());
    }
}
