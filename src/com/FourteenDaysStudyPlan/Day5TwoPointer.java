package com.FourteenDaysStudyPlan;

public class Day5TwoPointer {
    private static class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
//        Node two = new Node(2);
//        Node three = new Node(3);
//        Node four = new Node(4);
//        Node five = new Node(5);
//        Node six = new Node(6);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = six;

        Node middle  = removeNthFromEnd(one, 1);
        printNode(middle);
    }
/*
19. Remove Nth Node From End of List
Given the head of a linked list,
 remove the nth node from the end of the list and return its head.
 */
    public static  Node removeNthFromEnd(Node head, int n) {
     if(n<=0) return head;
     Node dummy  = new Node(-1);
     dummy.next = head;
     Node slow = dummy;
     Node fast = dummy;
     while(fast!=null && fast.next!=null) {
         fast = fast.next;
         if(n--<=0) { // maintaining the gap
             slow  = slow.next; // Not moving the slow pointer to maintain gap
         }
     }
        slow.next = slow.next.next;
     return dummy.next;
    }


    /*
      The approach is first and slow pointer
      when traversing the list with pointer slow, make another pointer fast that
      traverse twice as fast, when first reaches at the end of the list,
      slow must be in the  middle.
     */
    public static Node middleNodeApproachSecond(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Time Complexity: O(n), where N is the number of nodes in the give list
     * Space Complexity : O(n) the space used by array.
     * @param head
     * @return
     */
    public static Node middleNodeApproachOne(Node head) {
        Node arr[]  =  new Node[100];
        int count  = 0;
        while (head!=null) {
            arr[count++] = head;
            head = head.next;
        }
        return arr[count/2];

    }

    /**
     * Time Complexity is n^2 because of two loops in the worst case.
     * Space Complexity: O(1) we did not use any additional memory.
     * @param head
     * @return
     */
    public static Node middleNode(Node head) {
        Node current  = head;
        int count  = 0;
        while(current!=null) {
            count++;
            current = current.next;
        }
        int i =0;
        Node temp  = head;
        while (i < count/2 && temp!=null) {
            temp = temp.next;
            i++;
        }
        return  temp;
    }

    public static void printNode(Node head) {
        while (head!=null)
        {
            System.out.print("=>" +head.val);
            head = head.next;
        }
    }



}
