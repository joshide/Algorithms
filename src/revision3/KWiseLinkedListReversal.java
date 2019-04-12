package revision3;

public class KWiseLinkedListReversal {

	public static void main(String[] args) {
		SLNode n1 = new SLNode(1);
		SLNode n2 = new SLNode(2);
		SLNode n3 = new SLNode(3);
		SLNode n4 = new SLNode(4);
		SLNode n5 = new SLNode(5);
		SLNode n6 = new SLNode(6);
		SLNode n7 = new SLNode(7);
		SLNode n8 = new SLNode(8);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7; n7.next = n8;
		
		SLNode node = pairwiseSwap(n1,2);
		
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}

	}
	
	private static SLNode pairwiseSwap(SLNode node, int k) {
		if(node == null || node.next == null) {
			return node;
		}
		
		SLNode nextNode = node.next;
		for(int i = 1; i < k; i++) {
			if(nextNode != null) {
				nextNode = nextNode.next;
			}
		}
		
		SLNode result = pairwiseSwap(nextNode,k);
		int count = k;
		
		SLNode previous = null;
		SLNode current = node;
		SLNode next = current.next;
		while(count != 0 && current != null) {
			current.next = previous;
			previous = current;
			current = next;
			if(current != null) {
				next = current.next;
			}
			count--;
			
		}
		node.next = result;
		return previous;
		
	}
	

}
