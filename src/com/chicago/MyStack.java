package com.chicago;

import java.util.LinkedList;
import java.util.Queue;
/*
n is the total items between the 2 stacks (in the overarching queue)

Time: O( 1 ) - amortized (for enqueue and dequeue operations)
Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]
 */
public class MyStack {

    Queue<Integer> first = new LinkedList<Integer>();


    public MyStack() {

    }
    public void push(int x) {

        first.add(x);
        int n = first.size();
        while ((n-- > 1)) {
            first.add(first.poll());
        }
    }

    public int pop() {
        return first.poll();
    }

    public int top() {
        return first.peek();
    }

    public boolean empty() {

        return first.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
    }
}
