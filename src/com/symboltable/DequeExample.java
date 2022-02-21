package com.symboltable;
import java.util.*;

public class DequeExample {

    public static void main(String[] args) {


        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);

        for (Integer element: deque) {
            System.out.println("Element => " +element);
        }
        deque.clear(); // clear all the element
        System.out.println("-----Clear-------");
        // adding first
        deque.addFirst(120);
        deque.addFirst(130);
        // adding last
        deque.addLast(500);
        deque.addLast(600);
        // Display message
        for(Iterator itr = deque.iterator(); itr.hasNext();) {
            System.out.println("ascending => " +itr.next());
        }

        // Descending Iterator
        // To reverse the deque order
        for (Iterator itr = deque.descendingIterator(); itr.hasNext();){
            System.out.println("descending =>"+itr.next() );
        }
        System.out.println("Head of the Deque  => " + deque.element());
        System.out.println("head of the element using get first" +deque.getFirst());
        System.out.println("Get last element" + deque.getLast() );
        Object[] toarray = deque.toArray();
        System.out.println("Object array length  : " +toarray.length);
        for (int i = 0; i <toarray.length ; i++) {
            System.out.println(" " + toarray[i]);
        }
        System.out.println("head of the element peek => " + deque.peek());
        System.out.println("Poll : => " + deque.poll());
        // Display message
        for(Iterator itr = deque.iterator(); itr.hasNext();) {
            System.out.println("after poll => " +itr.next());
        }
        deque.push(256);
        deque.push(956);
        System.out.println("remove =>  " + deque.remove());

        // Display message
        for(Iterator itr = deque.iterator(); itr.hasNext();) {
            System.out.println("ascending => " +itr.next());
        }

    }

}
