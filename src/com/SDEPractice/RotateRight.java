package com.SDEPractice;

import java.util.List;

public class RotateRight {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

/*
61. Rotate List
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
 */
    public  static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-k%i;j>0;j--) //Get the i-k%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        ListNode head = first;
        rotateRight(head, 2);

    }
}
