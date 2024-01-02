package com.structy.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListValues {
    private static class Node{
        Object val;
        Node next;
        Node(String val) {
            this.val = val;
            this.next = null;
        }
    }
    public List<String> linkedListValues(Node head){
        List<String> ans = new ArrayList<>();
//        Node current = head;
//        while(current!=null){
//            ans.add(current.val);
//            current = current.next;
//        }
       return helper(head, ans);
       // return ans;
    }
    private List<String> helper(Node head, List<String> ans){
            if(head == null)
                return ans;
            ans.add((String) head.val);
           return helper(head.next, ans);
    }


    public static void main(String[] args) {
        LinkedListValues linkedList = new LinkedListValues();
        Node p = new Node("papa");
        Node m = new Node("mama");
        Node parin = new Node("parin");
        Node arka  = new Node("arka");
        p.next = m;
        m.next = parin;
        parin.next = arka;
        List<String> result = linkedList.linkedListValues(p);
        for(String name : result)
            System.out.print(name +" -> ");
    }
}
