package com.concept.recursion;

public class ReverseLinkedList {

    private static class Node {
        private Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return next;
        }
    }

    public static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        /**
         *  1 -> 2 -> 3 -> 4 -> 5 -> 6
         *  					node <-6 
         */
        Node p = reverseList(node.next);
        node.next.next = node; // node <- 6
        node.next = null; // remove cyclic dependencies 
        return p; // return head node.

    }

    public static void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(" " + temp.val);
            temp = temp.getNext();
        }
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        Node reversed = reverseList(n1);
        System.out.println("");
        printLinkedList(reversed);

    }

}