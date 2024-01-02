package com.structy.LinkedList;

public class AddLists {

    public Node addLists(Node head1, Node head2){

        Node dummy = new Node(-1);
        int remainder = 0;
        int sum = 0;
        Node tail = dummy;
        Node current1 = head1;
        Node current2 = head2;
        while (current1!=null || current2!=null || remainder!=0){
            int val1 = current1 == null ? 0 : current1.val;
            int val2 = current2 == null ? 0 : current2.val;
            sum = remainder + val1 + val2;
            remainder = sum > 9 ? 1 : 0;
            sum = sum % 10;
            tail.next = new Node(sum);
            tail = tail.next;
            if(current1!=null)
                current1 = current1.next;
            if(current2!=null)
                current2 = current2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(6);
        a1.next = a2;
        a2.next = a3;
        // 1 -> 2 -> 6

        Node b1 = new Node(4);
        Node b2 = new Node(5);
        Node b3 = new Node(3);
        b1.next = b2;
        b2.next = b3;
        // 4 -> 5 -> 3
        AddLists addLists = new AddLists();
        Node result = addLists.addLists(a1, b1);
        // 5 -> 7 -> 9
        Node temp = result;
        while (temp!=null){
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
    }
}
