package com.structy.LinkedList;

public class RemoveNode {

    public Node removeNode(Node head, String target){
        if(target.equals(head.strVal)){
            return head.next;
        }
        Node current = head;
        Node prev = null;
        while (current!=null){
            if(target.equals(current.strVal)){
               prev.next = current.next;
               //Need to break for another removal
                break;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    public Node removeNodeRec(Node head, String target){
        if(head == null)
            return null;

        if(target.equals(head.strVal)){
            return head.next;
        }
        head.next = removeNodeRec(head.next, target);
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        RemoveNode removeNode = new RemoveNode();
        Node result  = removeNode.removeNodeRec(a, "f");
        Node tmp = result;
        while (tmp!=null){
            System.out.print(tmp.strVal);
            tmp = tmp.next;
        }
    }
}
