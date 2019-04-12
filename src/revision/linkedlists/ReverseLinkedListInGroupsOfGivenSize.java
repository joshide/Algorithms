package revision.linkedlists;

public class ReverseLinkedListInGroupsOfGivenSize {

	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(1);
		SLLNode n2 = new SLLNode(2);
		SLLNode n3 = new SLLNode(3);
		SLLNode n4 = new SLLNode(4);
		SLLNode n5 = new SLLNode(5);
		SLLNode n6 = new SLLNode(6);
		SLLNode n7 = new SLLNode(7);
		SLLNode n8 = new SLLNode(8);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7; n7.next = n8;
		
		SLLNode node = reverseIngroup(n1,2);
		
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}

	}
	
	private static SLLNode reverseIngroup(SLLNode node, int k) {
		if(node == null || node.next == null) {
			return node;
		}
		
		
		SLLNode previous = null;
		SLLNode current = node;
		SLLNode next = node.next;
		
		int variable = k;
		while(k != 0) {
			current.next = previous;
			previous = current;
			current = next;
			if(current != null) {
				next = current.next;
				k--;
			} else {
				next = null;
				break;
			}	
		}
		
		node.next = reverseIngroup(current, variable);
		
		return previous;	
		
	}
	

}
