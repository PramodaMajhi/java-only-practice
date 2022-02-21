package com.symboltable;

import java.util.Arrays;
/**
 * As insert front and delete front O(n),
 * Now are changing our implementation to circular array
 * so that we can have all operations O(1) time.
 * We have added new variable called front and initialized to 0
 * We don't need any variable for rear, we will get hold of rear by
 * simple formula : rear = (front + size -1) % capacity
 *
 */
 public class DequeArray {
    int size;
    int capacity;
    int[]arr;
    int front;
    DequeArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
        front = 0;
    }

    public int getFront() {
        if(isEmpty()) return  -1;
        else    return arr[front];
    }
    public int getRear() {
        if(isEmpty()) return  -1;
        else return arr[(front+size-1)%capacity];
    }
/*
Complexity O(n)
 */
    public void insertFront(int x) {
        if(isFull()) return;
        // [10, 0, 0, 0, 0]
//        for (int i = size -1; i >=0; i--) {
//            arr[i+1] = arr[i]; // shifting right
//        }
//        arr[0] = x; //Always need to add into the front
         front = (front + capacity-1) % capacity;
         arr[front] = x;
         size++;
    }
    // O(1)
    public void insertRear(int x) {
        if(isFull()) return;
      //   arr[size] = x;
        // rear = (rear + 1) % capacity
       //  rear = (front + size -1) % capacity  // find rear equation
        int new_rear =  (front + size) % capacity;
        arr[new_rear] = x;
        size++;
    }
    /*
       Complexity O(n) operations
     */
    public void deleteFront(){
        // [10, 20, 0, 0, 0] - Initial
        // [20, 0, 0, 0,0] - final
        if(isEmpty()) return;
//        for (int i = 0; i < size-1; i++) {
//            arr[i] = arr[i+1];
//        }
         front = (front +1) % capacity;
        size--;
    }
    /*
    O(1)
     */
    public void deleteRear(){
        if(isEmpty()) return ;
        size--;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public boolean isFull() {
      return (size == capacity);
    }

    public static void main(String[] args) {
        DequeArray dequeArray = new DequeArray(5);
        dequeArray.insertFront(20);
        dequeArray.insertRear(10);
       // dequeArray.deleteRear();
      //  dequeArray.deleteFront();
        System.out.println("Front " +dequeArray.getFront());
        System.out.println("Rear " +dequeArray.getRear());
    }

}
