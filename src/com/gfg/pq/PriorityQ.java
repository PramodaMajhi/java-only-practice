package com.gfg.pq;

import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.add(10);
        pq.add(20);
        pq.add(15);
        System.out.println(pq);
        System.out.println("Peek"+ pq.peek());
        System.out.println("Poll" + pq.poll());
        System.out.println("Peek"+ pq.peek());
        System.out.println(pq);
    }
}
