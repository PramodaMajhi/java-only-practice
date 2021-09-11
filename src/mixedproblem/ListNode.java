package mixedproblem;

/*LeetCode 19
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5

https://www.youtube.com/watch?v=Kka8VgyFZfc
 */
public class ListNode {

	ListNode next;
	int val;

	ListNode(int x) {
		this.val = x;
	}

	// One pass solution to use two pointers slow(slow) fast (fast) both are pointing
	/* to starting position of the dummy node
	 *
	 */
	public static ListNode removeNthElementFromEnd(ListNode head, int nthPosition) {
		
		if(nthPosition <= 0) {
			return head;
		}
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode slow = dummy ;
		ListNode fast = dummy;
		
		while(fast.next !=null) {
			fast = fast.next;
			// Move the  slow pointer  as we make a distance of nthPosition between slow and fast
			if(nthPosition-- <= 0) { // found the correct distance
				slow = slow.next; // moving slow pointer				
			}
		}
		slow.next = slow.next.next ; // established the connection i.e node link has been broken
		return dummy.next;
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {

		/*
		 * Two pass algorithm
		 */
		if (n <= 0) {
			return head;
		}
		// create dummy node and assign -1 to it, so that we can return dummy.next as
		// head of the original node
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		int length = 0;

		// Approach to find the length of the link list
		ListNode first = head;
		while (first != null) {
			length++;
			first = first.next;
		}
		// we can check if user input position is out of bound if we know the length
		length = length - n; // find the location to delete from the link list
		first = dummy;
		while (length > 0) { // reach to the point where to delete

			length--;
			first = first.next;
		}

		first.next = first.next.next; // connect the link

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);

		first.next = second;
		second.next = third;
		third.next = fourth;

		fourth.next = fifth;
		
		for (ListNode x = first; x != null; x = x.next) {
			System.out.print(" ");
			System.out.print(" -> " + x.val);
		}

		// ListNode lstNode = removeNthElementFromEnd(first,6);
		ListNode lstNode = removeNthFromEnd(first, 6);
		System.out.println();
		for (ListNode x = lstNode; x != null; x = x.next) {

			System.out.print(" -> " + x.val);
		}

	}

}
