package geeksforgeeks.LinkedList;

public class ReverseAlternateKNodesInSLL {

	public static void main(String[] args) {
		//1,2,3,4,5,6,7,8,9
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
		int k = 2;
		
		SLLNode node = reverseAlternateKNodes(null,n1,k);
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}

	}
	
	private static SLLNode reverseAlternateKNodes(SLLNode prev, SLLNode node, int k) {
		if(node == null)
			return null;
		
		if(node.next == null)
			return node;
		
		SLLNode nextNode = findNextNode(node,k);
		SLLNode headNode = reverse(node, k);
		node.next = nextNode;
		nextNode = findNextNode(nextNode, k-1);
		if(nextNode != null)
			reverseAlternateKNodes(nextNode, nextNode.next, k);
		if(prev != null)
			prev.next = headNode;
		
		
		return headNode;
		
		
	}
	
	private static SLLNode findNextNode(SLLNode node, int k) {
		for(int i = 0; i < k; i++) {
			if(node != null) {
				node = node.next;
			}
		}
		return node;
	}
	
	private static SLLNode reverse(SLLNode node, int k) {
		SLLNode prev = null;
		SLLNode current = node;
		SLLNode next = current.next;
		
		while(current != null) {
			if(k == 0) {
				break;
			}
			k--;
			current.next = prev;
			prev = current;
			current = next;
			if(current != null)
				next = current.next;
		}
		return prev;		
	}

}
