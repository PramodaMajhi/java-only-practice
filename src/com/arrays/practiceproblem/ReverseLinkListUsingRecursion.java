package com.arrays.practiceproblem;


public class ReverseLinkListUsingRecursion {

    private static class Node {
        private int val;
        private Node next ;
        public Node(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static Node reverse(Node head) {
        if(head == null || head.next == null) {
            return  head;
        }
        Node lastNode  = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return lastNode;
    }

    public static void main(String[] args) {
        Node  n1 = new Node(1);
        Node  n2 = new Node(2);
        Node  n3 = new Node(3);
        Node  n4 = new Node(4);
        Node  n5 = new Node(5);
        Node  n6 = new Node(6);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);

        Node reversed = reverse(n1);
        while (reversed!=null) {
            System.out.print("=> " + reversed.val);
            reversed = reversed.next;
        }

    }
}
