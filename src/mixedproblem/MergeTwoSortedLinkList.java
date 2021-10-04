package mixedproblem;




/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.

	Example:
	
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLinkList {

	public static void main(String[] args) {
		MergeTwoSortedLinkList obj = new MergeTwoSortedLinkList();
		obj.head1 = obj.new ListNode(1);
		obj.head1.next = obj.new ListNode(2);
		obj.head1.next.next = obj.new ListNode(4);
		obj.head2 = obj.new ListNode(1);
		obj.head2.next = obj.new ListNode(3);
		obj.head2.next.next = obj.new ListNode(4);

		ListNode resultList = mergetwosortedlist(obj.head1, obj.head2);
		for (ListNode x = resultList; x != null; x = x.next) {
			System.out.print(" " + x.item);
			System.out.print("->");
		}

	}

	static ListNode head1;
	static ListNode head2;
	static ListNode dummy;

	private class ListNode {
		ListNode next;
		int item;

		ListNode(int n) {
			this.item = n;
		}
	}

	public static ListNode mergetwosortedlist(ListNode l1, ListNode l2) {
		MergeTwoSortedLinkList obj = new MergeTwoSortedLinkList();
		obj.dummy = obj.new ListNode(0);
		ListNode l3 = dummy;
		while (l1 != null && l2 != null) {
			if (l1.item <= l2.item) {
				l3.next = l1;
				l1 = l1.next;
			} else {
				l3.next = l2;
				l2 = l2.next;
			}
			l3 = l3.next;
		}
		if (l1 != null) {
			l3.next = l1;
		}
		if (l2 != null) {
			l3.next = l2;
		}
		return dummy.next;
	}
}
