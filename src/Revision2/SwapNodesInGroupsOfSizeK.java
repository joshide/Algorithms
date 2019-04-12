package Revision2;

public class SwapNodesInGroupsOfSizeK {

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
		
		int k = 2;
		SLNode head = reverse(n1,k);
		
		while(head != null) {
			System.out.print(head.data + ",");
			head = head.next;
		}

	}
	
	private static SLNode reverse(SLNode node, int k) {
		
		if(node == null) {
			return null;
		}
		
		SLNode currentNode = node;
		
		for(int i = 1; i <=k; i++) {
			if(node != null) {
				node = node.next;
			}
		}
		
		SLNode nextNode = reverse(node,k);
		
		SLNode current = currentNode;
		SLNode previous = null;
		SLNode next = currentNode.next;
		
		for(int i = 0; i < k; i++) {
			currentNode.next = previous;
			previous = currentNode;
			currentNode = next;
			if(currentNode != null) {
				next = currentNode.next;
			} else {
				break;
			}
		}
		
		current.next = nextNode;
		return previous;
	}

}
