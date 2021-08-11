

/*
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5
 */
public class ListNode {
	
	ListNode next;
	int val;
		
	ListNode(int x) {
			this.val = x;
		}

	
	
 public static ListNode removeNthFromEnd(ListNode head, int n) {
	 
	 /*
	  * Two pass algorithm
	  */
	 if(n <= 0 ) {
		 return head;
	 }
	 ListNode dummy = new ListNode(0);
	 dummy.next = head;
	 int length = 0;
	 
	 ListNode first = head;
	 while(first!=null) {
		 length ++;
		 first  = first.next ;
	 }
	 
	 length  = length - n ;
	 first = dummy;
	 while(length > 0) {
		 
		 length -- ;
		 first = first.next;
		 
	 }
	 
	 first.next = first.next.next ;
	
	 
	 return dummy.next;
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode first = new  ListNode(1);
		ListNode second  = new ListNode(2);
		ListNode third  = new ListNode(3);
		ListNode fourth  = new ListNode(4);
		ListNode fifth  = new ListNode(5);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		
		fourth.next = fifth;
		
		ListNode lstNode = removeNthFromEnd(first, 2);
		
		for(ListNode x = lstNode; x!=null; x = x.next) {
			
			System.out.println("" + x.val);
		}
		
		
	}

}
