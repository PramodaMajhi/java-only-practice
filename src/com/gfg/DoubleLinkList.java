package com.gfg;

public class DoubleLinkList {
    private static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public static Node insertRear(Node head, int data) {
        Node current  = head;
        Node temp = new Node(data);
        if(head == null) return  temp;
            while (current!=null && current.next!=null) {
                current = current.next;
            }
            current.next = temp;
            temp.prev = current;

        return head;
    }
    public static Node insertFront(Node head, int data) {
       //  if(head == null) return head;
        Node temp = new Node(data);
        temp.next = head;
        if(head!=null) head.prev = temp;
        return temp;
    }

    public static Node reverseDLL(Node head) {
        if(head == null || head.next == null) return  head;
        Node current = head;
        Node prev = null;
        // swapping of reference
        while (current!=null) {
            prev = current.prev; // prev is pointing to current node prev
            current.prev = current.next; // current node prev is pointing to current which was null before
            current.next = prev;
            current = current.prev;
        }
        return prev.prev;
    }
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second  = new Node(20);
        Node third = new Node(30);
        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;
        Node head  = first;
        Node  added = insertFront(head, 5);
        Node addedAtEnd = insertRear(added, 40);
        Node temp = reverseDLL(addedAtEnd);
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
