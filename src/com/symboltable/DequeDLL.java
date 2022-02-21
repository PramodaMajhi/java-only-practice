package com.symboltable;

import sun.util.locale.provider.JRELocaleProviderAdapter;

/**
 * We will be using double linklist for the Dque implementation
 * you can check circular array implementation for the same.
 */
public class DequeDLL {
    Node front;
    Node rear;
    int size;
    private class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    DequeDLL(){
        front = rear = null;
        size = 0;
    }
    public void insertFront(int data) {
       if(isEmpty()) {
           front = new Node(data);
           rear = front;
       } else {
           Node oldHead  = front;
           front = new Node(data);
           front.next = oldHead;
           oldHead.prev = front;
       }
       size++;

    }
    public void insertRear(int data) {

    }
    public void deleteFront() {

    }
    public void deleteRear(){

    }
    public int getFront() {
        return -1;
    }

    public int getRear() {
        return -1;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DequeDLL dequeDLL = new DequeDLL();
        dequeDLL.insertFront(10);
        dequeDLL.insertFront(3);
        Node head  = dequeDLL.front;
        System.out.print("[ ");
        while (head!=null) {
            System.out.print(head.data +", ");
            head = head.next;
        }
        System.out.print(" ]");
    }
}
