package revision3;

public class ReverseAlternateKNodes {

	public static void main(String[] args) {
		SLNode n1 = new SLNode(1);
		SLNode n2 = new SLNode(2);
		SLNode n3 = new SLNode(3);
		SLNode n4 = new SLNode(4);
		SLNode n5 = new SLNode(5);
		SLNode n6 = new SLNode(6);
		SLNode n7 = new SLNode(7);
		SLNode n8 = new SLNode(8);
		SLNode n9 = new SLNode(9);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7; n7.next = n8; n8.next = n9;
		
		SLNode node = reverseAlternateKNode(n1, 4);
		
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}


	}
	
	private static SLNode reverseAlternateKNode(SLNode node, int k) {
		if(node == null || node.next == null) {
			return node;
		}
		
		int count = k;
		SLNode previous = null;
		SLNode current = node;
		SLNode next = node.next;
		
		while(count != 0 && current != null) {
			current.next = previous;
			previous = current;
			current = next;
			if(current != null) {
				next = current.next;
			}
			count--;
		}
		
		node.next = current;
		if(current == null) {
			return previous;
		}
		
		count = k;
		SLNode prev2 = previous;
		while(count != 0 && current != null) {
			if(current != null) {
				prev2 = current;
				current = current.next;
			}
			count--;
		}
		prev2.next = reverseAlternateKNode(current, k);
		
		return previous;
	}

}
