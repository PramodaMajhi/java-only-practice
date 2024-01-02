package com.structy.LinkedList;

public class LongestStreak {
    public int longestStreak(Node head){
        int maxStreak = 0 ;
        if(head == null) return maxStreak;
        int currentStreak  = 0;
        int firstVal = Integer.MIN_VALUE;
        Node current = head;

        while (current!=null){
            if(firstVal == current.val){
                firstVal = current.val;
                currentStreak++;
            }else {
                currentStreak = 1;
                firstVal = current.val;
            }
            maxStreak = Math.max(maxStreak,currentStreak);
            current = current.next;
        }
        return maxStreak;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(5);
//        Node c = new Node(7);
//        Node d = new Node(7);
//        Node e = new Node(7);
//        Node f = new Node(6);
        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
        LongestStreak longestStreak = new LongestStreak();
        System.out.println(longestStreak.longestStreak(a));
    }
}
