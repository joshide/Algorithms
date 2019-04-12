package revision.linkedlists;

public class ReverseAlternateKNodes {

	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(1);
		SLLNode n2 = new SLLNode(2);
		SLLNode n3 = new SLLNode(3);
		SLLNode n4 = new SLLNode(4);
		SLLNode n5 = new SLLNode(5);
		SLLNode n6 = new SLLNode(6);
		SLLNode n7 = new SLLNode(7);
		SLLNode n8 = new SLLNode(8);
		SLLNode n9 = new SLLNode(9);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7; n7.next = n8; n8.next = n9;
		
		SLLNode node = reverseAlternateKNodes(n1,null,2);
		
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		
		

	}
	
	private static SLLNode reverseAlternateKNodes(SLLNode node,SLLNode previousNode, int k) {
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
		
		node.next = current;
		
		SLLNode prevNode = getKthNode(current,variable);
		SLLNode nextNode = prevNode == null ? null :prevNode.next;
		
		SLLNode attachedNode = reverseAlternateKNodes(nextNode, prevNode,variable);
		
		if(prevNode != null) {
			prevNode.next = attachedNode;
		}
		return previous;
	}
	
	private static SLLNode getKthNode(SLLNode node, int k) {
		if(node == null || node.next == null) {
			return node;
		}
		for(int i = 1; i < k; i++) {
			if(node != null) {
				node = node.next;
			}
		}
		
		return node;
	}

}
