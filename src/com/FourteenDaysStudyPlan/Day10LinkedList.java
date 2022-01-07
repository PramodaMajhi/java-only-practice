package com.FourteenDaysStudyPlan;

import java.util.List;

public class Day10LinkedList {
    public static class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
    public static ListNode reverseListIterative(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current!=null) {
            ListNode next = current.next;
            current.next = prev;
            current = next;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head; //
        head.next = null;
        return  p;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null ) return list2;
        if(list2==null) return list1;

        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return  list2;
        }

    }
}
