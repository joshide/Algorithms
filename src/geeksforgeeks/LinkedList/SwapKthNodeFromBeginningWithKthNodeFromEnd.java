package geeksforgeeks.LinkedList;

public class SwapKthNodeFromBeginningWithKthNodeFromEnd {
	
	private static SLLNode head = null;
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
		
		head = n1;
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7; n7.next = n8; n8.next = n9;
		
		int k = 7;
		swap(k);
		
		SLLNode node = head;
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
			
		}
		
	}
	
	private static void swap(int k) {
		int size = getSize(head);
		
		// outside range
		if(k > size || k <= 0) {
			return;
		}
		int firstIndex = k;
		int lastIndex = size - (k - 1);
		
		// // same nodes being swapped	
		if(firstIndex == lastIndex) { 
			return;
		}
		
		// Node being swapped are first and last node
		
		if(k == 1) {
			SLLNode firstNode = findNode(firstIndex);
			SLLNode lastNode = findNode(lastIndex);
			SLLNode prevLastNode = findNode(lastIndex - 1);
			prevLastNode.next = firstNode;
			lastNode.next = firstNode.next;
			firstNode.next = null;
			head = lastNode;
			return;
			
		}
		// swapped nodes are in between
		SLLNode firstNode = findNode(firstIndex);
		SLLNode firstNodePrev = findNode(firstIndex-1);
		SLLNode secondNode = findNode(lastIndex);
		SLLNode secondNodePrev = findNode(lastIndex - 1);
		
		SLLNode secondNodeNext = secondNode.next;
		
		firstNodePrev.next = secondNode;
		secondNode.next = firstNode.next;
		
		secondNodePrev.next = firstNode;
		firstNode.next = secondNodeNext;
		
		return;
		
	}
	
	private static SLLNode findNode(int k) {
		SLLNode node = head;
		for(int i = 1; i < k; i++) {
			node = node.next;
		}
		return node;
		
	}
	private static int getSize(SLLNode node) {
		int size = 0;
		while(node != null) {
			node = node.next;
			size++;
		}
		return size;
		
	}

}
