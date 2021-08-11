

/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself
 */
public class AddedTwoNumberList {

	static Node head1, head2;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String args[]) {

		AddedTwoNumberList list = new AddedTwoNumberList();

		// creating first list

		list.head1 = new Node(2);
		list.head1.next = new Node(5);
		System.out.println("First list is");

		for (Node x = head1; x != null; x = x.next) {
			System.out.print("  " + x.data);
		}

		list.head2 = new Node(3);
		list.head2.next = new Node(7);
		System.out.println("");
		System.out.println("Second list is");

		for (Node x = head2; x != null; x = x.next) {
			System.out.print("  " + x.data);
		}
		
		Node rs = addTwoList(head1, head2);
		
		System.out.println("");
		System.out.println("Added List");
		
		for (Node x = rs; x != null; x = x.next) {
			System.out.print("  " + x.data);
		}

	}

	public static Node addTwoList(Node first, Node second) {

		Node res = null;
		Node prev = null;
		Node temp = null;
		int carry = 0, sum;

		while (first != null || second != null) {

			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;

			temp = new Node(sum);
			// if this is the first node them set it as head of the resultant list
			if (res == null) {
				res = temp;
			} else {
				res.next = temp;
			}

			prev = temp;

			if (first != null) {
				first = first.next;
			}
			if (second != null) {
				second = second.next;
			}

		}
		if(carry > 0) {
			temp.next = new Node(carry);
		}
		return res;
	}
}
