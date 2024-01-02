package com.structy.LinkedList;

public class IsUnivalueList {

    public boolean isUnivalueList(Node head){
        if(head == null) return true;
        int firstVal = head.val;
        Node current = head.next;
        while (current!=null){
            int nextVal = current.val;
            if(firstVal!=nextVal){
               return false;
            }
           current = current.next;
        }
        return true;
    }
    public boolean isUnivalueListRec(Node head){

        return helper(head, head.val);
    }
    private boolean helper(Node head, int firstVal){
        if(head == null) return true;
        if(firstVal != head.val)
            return false;
        else
            return helper(head.next, firstVal);
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(1);
        Node c  = new Node(1);
        a.next = b;
        b.next = c;
        IsUnivalueList isUnivalueList = new IsUnivalueList();
        System.out.println(isUnivalueList.isUnivalueList(a));
    }
}
