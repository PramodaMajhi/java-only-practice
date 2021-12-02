
/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *
 * 1 ->0 -> 1
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 */

import java.util.Stack;

/**
 *
 */
public class BinaryToDecimal {

     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(0);
    ListNode  c = new ListNode(1);
    a.next = b;
    b.next =c;

        System.out.println(getDecimalValue(a));
        System.out.println(getDecimalValue2(a));
    }
    /*
       There are two approach,
       1) first we can, traverse through the linked list and push into the stack
       and apply for formula from binary to decimal starting from
       the least significant bit to most significant bit
       The disadvantage of using extra space to store all the list.
       2) (((0*2)+1)*2 +1)*2+0
       in general a->b->c = ((((0*2)+a)2) + b)2+c
       Now, a will multiply 2 times
       a*2^2+ b*2^1+c*2^0

       Time Complexity : O(n)
       Space Complexity: O(1)
     */
    public static int getDecimalValue2(ListNode head) {
        int num =0;
        while(head!=null) {
           num = num*2 + head.val;
            head = head.next;
        }

        return  num;
    }
    public static int getDecimalValue(ListNode head) {
        Stack<Integer>  stack = new Stack<Integer>();
        while(head!=null) {
            stack.push(head.val);
            head = head.next;
        }
        int i =0;
        int num = 0;
        while (!stack.isEmpty()) {
            int pow  = (int)Math.pow(2,i);
            num+= (stack.pop())*pow;
            i++;
        }
        return  num;
    }

}

