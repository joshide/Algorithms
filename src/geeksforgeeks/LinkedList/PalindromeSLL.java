package geeksforgeeks.LinkedList;

public class PalindromeSLL {

	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(1);
		SLLNode n2 = new SLLNode(2);
		SLLNode n3 = new SLLNode(3);
		SLLNode n4 = new SLLNode(2);
		SLLNode n5 = new SLLNode(1);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		
		// we can check if the SLL is palindrom with the help of the stack also
		// below is another mechanism to do that

		int sizeOfLinkedList = size(n1);
		System.out.println(sizeOfLinkedList);
		
		boolean isPalindrom = ifPalindrom(n1, sizeOfLinkedList);
		
		System.out.println(isPalindrom);
	}
	
	private static boolean ifPalindrom(SLLNode node, int size) {
		
		if(node == null || node.next == null)
			return true;
		
		int mid = size/2;
		
		SLLNode midNode = node;
		
		if(size%2 == 0) {
			mid --;
		}
		
		for(int i = 0; i < mid; i++) {
			midNode = midNode.next;
		}
		
		SLLNode node2 = reverse(midNode.next);	
		
		while(node2 != null) {
			if(node.data != node2.data) {
				return false;
			}
			node = node.next;
			node2 = node2.next;
		}
		
		return true;
		
	}
	
	private static SLLNode reverse(SLLNode node) {
		if(node == null || node.next == null) {
			return node;
		}
		
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
	
	private static int size(SLLNode node) {
		int size = 0;
		while(node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

}
