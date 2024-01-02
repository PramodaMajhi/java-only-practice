package com.structy.LinkedList;

public class CreateLinkedList {

    public Node createLinkedList(int[]nums){
        Node dummy = new Node(-1);
        Node tail = dummy;
        for (int num:nums) {
            tail.next = new Node(num);
            tail = tail.next;
        }
        return dummy.next;
    }
    public Node createLinkedListRec(int[]nums){
        return helper(nums, 0);
    }
    private Node helper(int[]nums, int start){
        if(nums.length == start){
            return null;
        }
        Node head = new Node(nums[start]);
        head.next = helper(nums, start+1);
        return head;
    }

    public static void main(String[] args) {
        CreateLinkedList createLinkedList = new CreateLinkedList();
        int[]nums = {1, 7, 1, 8};
        Node result = createLinkedList.createLinkedListRec(nums);
        Node tmp = result;
        while (tmp!=null){
            System.out.print(" ->" + tmp.val);
            tmp = tmp.next;
        }
    }
}
