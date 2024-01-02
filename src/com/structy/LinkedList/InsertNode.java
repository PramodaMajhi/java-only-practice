package com.structy.LinkedList;

import com.gfg.Searching.BinarySearch;

public class InsertNode {
    public Node insertNode(Node head, String target, int index){
        if(index == 0){
            Node newHead = new Node(target);
            newHead.next = head;
            return newHead;
        }

        Node current  = head;
        int count = 0;
        while (current!=null){
            if(count == index -1){
             Node next  = current.next;

             current.next = new Node(target);
             current.next.next = next;
            }
            count++;
            current = current.next;
        }
        return head;
    }

    public Node insertNodeRec(Node head, String target, int index){

        return helper(head, target, index, 0);
    }
    private Node helper(Node head, String target, int index, int count){
        if(head == null)
            return null;
        if(index == 0){
            Node newHead = new Node(target);
            newHead.next = head;
            return newHead;
        }
        if(count == index -1){
            Node tmp = head.next;
            head.next = new Node(target);
            head.next.next =  tmp;
            return head;
        }
        helper(head.next, target, index, count + 1);
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.next = b;
        b.next = c;
        c.next = d;

        InsertNode insertNode = new InsertNode();
        Node result = insertNode.insertNodeRec(a, "x", 2);
        Node tmp = result;
        while (tmp!=null){
            System.out.print(tmp.strVal);
            tmp = tmp.next;
        }
    }
}
