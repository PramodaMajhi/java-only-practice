package com.chicago;

import java.util.Stack;

/*
232. Implement Queue using Stacks
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
 */
public class Queue {
    Stack<Integer> push = new Stack<Integer>();
    Stack<Integer> pop = new Stack<Integer>();

    public Queue() {

    }
    // Push the element into the queue.
    public void push(int x) {
        push.push(x);
    }
    // Pop the element from the queue
    public int pop() {
        // pop all the items push stack and push all the element into to pop stack
        // then pop it from pop stack
        if(pop.isEmpty()) {
            while (!push.empty()){
                pop.push(push.pop());
            }
        }
        return pop.pop();

    }

    // Get the front element
    public int peek() {
        if(!pop.isEmpty()){
            return pop.peek();
        }else {
            while (!push.empty()){
                pop.push(push.pop());
            }
        }
        return pop.peek();
    }
    public boolean empty() {
        return push.empty() && pop.isEmpty();
    }
    public static void main(String[] args) {
        Queue myqueue = new Queue();

    }

}
