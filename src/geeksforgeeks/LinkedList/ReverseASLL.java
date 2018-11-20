package geeksforgeeks.LinkedList;

public class ReverseASLL {

	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(1);
		SLLNode n2 = new SLLNode(2);
		SLLNode n3 = new SLLNode(3);
		
		n1.next = n2; n2.next = n3;
		
		SLLNode head = n1;
		
		while(n1 != null) {
			System.out.print(n1.data + ",");
			n1 = n1.next;
		}
		
		head = reverse(head);
		
		System.out.println("\nAfter Reverse");
		while(head != null) {
			System.out.print(head.data + ",");
			head = head.next;
		}

	}
	
	private static SLLNode reverse(SLLNode node) {
		SLLNode prev = null;
		SLLNode current = node;
		SLLNode next = current.next;
		
		while(current != null) {
			current.next = prev;
			prev = current;
			current = next;
			if(current != null)
				next = current.next;
		}
		
		return prev;
				
	}

}
