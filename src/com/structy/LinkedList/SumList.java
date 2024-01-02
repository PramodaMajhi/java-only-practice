package com.structy.LinkedList;

public class SumList {
    private static class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    // // 2 -> 8 -> 3 -> -1 ->7->null
    public int sumList(Node head){
        Node current  = head;
        int sum = 0;
        while(current!=null){
            sum = sum + current.val;
            current = current.next;
        }
        return sum;
    }
    public int sumListRec(Node head){
        if(head == null) return 0;
        return head.val + sumListRec(head.next);
    }

    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(8);
        Node c = new Node(3);
        Node d = new Node(-1);
        Node e = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        SumList sumList = new SumList();
        System.out.println("Your sum is : " + sumList.sumList(a));
        System.out.println("Your sum is : " + sumList.sumListRec(a));
    }
}
