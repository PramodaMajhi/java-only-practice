package com.structy.LinkedList;

public class LinkedListFind {
    public static class Node{
        String val;
        Node next;
        Node(String val){
            this.val = val;
            this.next = null;
        }
    }
    public boolean linkedListFind(Node head, String target){
            if(head ==null) return false;
            if(head.val.equals(target))
                return true;
            return linkedListFind(head.next, target);
    }
    public String getNodeValue(Node head, int index){
        if(head == null)
            return null;
        if(index == 0)
            return head.val;
        return getNodeValue(head.next, index-1);
    }

    public static void main(String[] args) {
        /**
         * Test data
         */
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        a.next = b;
        b.next = c;
        c.next = d;

        Node x = new Node("x");
        Node y = new Node("y");
        Node z = new Node("z");

        x.next = y;
        y.next = z;
// x -> y -> z
        LinkedListFind find  = new LinkedListFind();
        Node list = find.zipperLists(a,x);

        Node current = list;
        while (current!=null){
            System.out.print("-> " + current.val);
            current = current.next;
        }
    }
    // a -> b -> c -> d
    // x -> y -> z
    // a -> x -> b -> y -> c -> z -> d
    public Node zipperLists(Node head1, Node head2){
        Node tail = head1; // assigning head1
        int count = 0;
        Node current1 = head1.next;
        Node current2 = head2;
        while (current1!=null && current2!=null){
            if(count % 2 == 0) {
                tail.next = current2; // tail.next -> ->x
                current2 = current2.next;
            }else{
                tail.next = current1;
                current1 = current1.next;
            }
            count++;
            tail = tail.next;
        }
        if(current1!=null) {
            tail.next = current1;
        }
        if(current2!=null){
            tail.next = current2;
        }
        return head1;
    }
    public Node zipperListsRec(Node head1, Node head2){
        if(head1 == null && head2 == null)
            return null;
        if(head1 == null )
            return head2;
        if(head2 == null)
            return head2;
        return null;
    }
    // a->b->c->d->null
    public Node reverseListItr(Node head){
        Node prev = null;
        Node current = head;
        while (current!=null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node reverseList(Node head){
        if(head == null || head.next == null)
            return head;
        Node lastNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }
}
