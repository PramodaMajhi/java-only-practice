package com.structy.LinkedList;

public class MergeList {

    public Node merge(Node head1, Node head2) {

        Node dummy = new Node(-1);
        Node tail = dummy;
        Node current1 = head1;
        Node current2 = head2;
        while (current1 != null && current2 != null) {

            if (current1.val > current2.val) {
                tail.next = current2;
                current2 = current2.next;
            } else {
                tail.next = current1;
                current1 = current1.next;
            }
            tail = tail.next;
        }

        if (current1 != null)
            tail.next = current1;
        if (current2 != null)
            tail.next = current2;
        return dummy.next;
    }

    public Node mergeRec(Node head1, Node head2) {
        if(head1 == null && head2 == null) return null;
        if(head1 == null)
            return head2;
        if(head2 == null)
            return  head1;
        if(head1.val < head2.val){
            head1.next = mergeRec(head1.next, head2);
            return head1;
        }
        else {
            head2.next = mergeRec(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        /**
         * Test data
         */
        Node a = new Node(5);
        Node b = new Node(7);
        Node c = new Node(10);
        Node d = new Node(12);
//        Node e = new Node(20);
//        Node f = new Node(28);
        a.next = b;
        b.next = c;
        c.next = d;

        Node p = new Node(6);
        Node q = new Node(8);
        Node r = new Node(9);
        // Node s = new Node(25);
        p.next = q;
        q.next = r;
        // r.next = s;

        MergeList mergeList = new MergeList();
        Node list = mergeList.mergeRec(a, p);
        Node temp = list;
        while (temp != null) {
            System.out.print("-> " + temp.val);
            temp = temp.next;
        }
    }
}
