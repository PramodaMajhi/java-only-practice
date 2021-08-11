
public class Node {
	
	private Node next; // empty linked list
	private String item; // String variable to hold the value
	
	public static void main(String args[]) {
		Node  first  = new Node();  // first node
		first.item = "to";
		first.next =null;
		
		Node second = new Node(); // second node
			 second.item = "be";
			 first.next = second;
			 
		Node third = new Node();  // third node
			 third.item = "love" ;
			 second.next = third;
			 // Traversing the list
			 
			 for(Node x= first ; x!=null ; x = x.next) {
				 System.out.print("  "+ x.item);
			 }
			 
	}

}
