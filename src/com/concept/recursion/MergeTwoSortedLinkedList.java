package com.concept.recursion;

/**
 * Merge two sorted linked list n1 = 1-2-3-4-5 n2 = 6-7-8-9-10 result =
 * 1-2-3-4-5-6-7-8-9-10
 */

public class MergeTwoSortedLinkedList {

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

    public static void main(String args[])
    {
        // 1 -> 8
        Node n1 = new Node(1);
        Node n2 = new Node(8);

        n1.setNext(n2);
        // 4 -> 11
        Node k1 = new Node(4);
        Node k2 = new Node(11);
        k1.setNext(k2);

        Node sortedList  = sortMerge(n1, k1);
        System.out.print("");
        printList(sortedList);

    }
    /**
     * A = 1 -> 8
     * B = 4 -> 11
     */
    public static Node sortMerge(Node A, Node B) {
        if(A == null) {
            return B;
        }
        if(B == null) {
            return A;
        }

        if(A.val <= B.val) {
            A.next = sortMerge(A.next, B);
            return A;
        } else  {
            B.next = sortMerge(A, B.next);
            return B;
        }


    }



    public static void printList(Node mergeList) {

        // for (String string : mergeList) {
        //     System.out.println(string);
        // }
        Node temp = mergeList;
        while(temp!=null) {
            System.out.print(temp.val + " ");
            temp = temp.getNext();
        }
    }

    

}
