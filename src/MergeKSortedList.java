

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedList {
	
	static ListNode head1;
	static ListNode head2;
	static ListNode dummy;
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		  this.val = x;
		}
	}

	
	public static void main(String[] args) {
		
		MergeKSortedList first  = new MergeKSortedList();
		first.head1 = new ListNode(1);
				
	
	}

}
