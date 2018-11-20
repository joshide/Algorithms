package geeksforgeeks.LinkedList;

public class ReverseALinkedListInGroupsOfGivenSize {

	public static void main(String[] args) {
		//1,2,3,4,5,6,7,8
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
		int k = 4;
		
		//3,2,1,6,5,4,8,7
		SLLNode node = reverseInGroup(n1,k);
		
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}

	}
	
	private static SLLNode reverseInGroup(SLLNode node, int k) {
		if(node == null)
			return null;
		
		if(node.next == null)
			return node;
		
		// recursion : reverse node which is k distance away from current node
		SLLNode currentNode = node;
		for(int i = 0; i < k; i++) {
			if(currentNode != null) {
				currentNode = currentNode.next;
			}
		}
		
		SLLNode nextNode = reverseInGroup(currentNode,k);
		SLLNode headNode = reverse(node,k);
		node.next = nextNode;
		return headNode;
		
		
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
