package geeksforgeeks.LinkedList;

public class ReverseADLL {

	public static void main(String[] args) {
		DLLNode n1 = new DLLNode(1);
		DLLNode n2 = new DLLNode(2);
		DLLNode n3 = new DLLNode(3);
		
		n1.next = n2; n2.next = n3;
		n3.prev = n2; n2.prev = n1;
		
		DLLNode head = n1;
		
		while(n1 != null) {
			System.out.print(n1.data + ",");
			n1 = n1.next;
		}
		
		head = reverse(head);
		
		System.out.println("\nAfter Reverse");
		while(head != null) {
			System.out.print(head.data + "<>");
			head = head.next;
		}

	}
	
	private static DLLNode reverse(DLLNode node) {
		DLLNode prev = null;
		DLLNode current = node;
		
		while(current != null) {
			current.prev = current.next;
			current.next = prev;
			
			prev = current;
			current = current.prev;
		}
		
		return prev;
		
	}

}
