package geeksforgeeks.LinkedList;

public class DetectAndRemoveLoopFromSLL {

	private static SLLNode loopNode = null;
	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(1);
		SLLNode n2 = new SLLNode(2);
		SLLNode n3 = new SLLNode(3);
		SLLNode n4 = new SLLNode(4);
		SLLNode n5 = new SLLNode(5);
		SLLNode n6 = new SLLNode(6);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
		n6.next = n3;
		
		boolean isLoopPresent = isLoopPresent(n1);
		System.out.println(isLoopPresent);
		
		// How to remove the loop if its present	
		int loopSize = findLoopSize(loopNode);
		System.out.println(loopSize);
		
		//remove the loop
		SLLNode firstNodeOfTheLoop = findFirstNode(n1,loopSize);
		System.out.println("First Node of the loop is : " + firstNodeOfTheLoop.data);
		
		SLLNode endNode = findEndNode(firstNodeOfTheLoop, loopSize);
		System.out.println("End Node : " + endNode.data);
		endNode.next = null;
		
		System.out.println("Iterating SLL:");
		while(n1 != null) {
			System.out.print(n1.data + ",");
			n1 = n1.next;
		}
		
		

	}
	
	private static SLLNode findEndNode(SLLNode node, int size) {
		for(int i = 0; i < size-1; i++) {
			node = node.next;
		}
		return node;
	}
	
	private static SLLNode findFirstNode(SLLNode node, int size) {
		SLLNode firstNode = node;
		SLLNode secondNode = node;
		
		for(int i = 0; i < size; i++) {
			secondNode = secondNode.next;
		}
		
		while(firstNode != secondNode) {
			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}
		
		return firstNode;
	}
	
	private static int findLoopSize(SLLNode node) {
		int size = 0;
		
		SLLNode loopNode = node;
		
		while(node.next != loopNode) {
			size++;
			node = node.next;
		}
		
		return size+1;
	}
	
	// we can detect if the loop is present
	// 1. either by visited node or hashing mechanism
	// 2. or by using the hare tortoise algorithm
	private static boolean isLoopPresent(SLLNode node) {
		
		if(node == null || node.next == null) {
			return false;
		}
		
		SLLNode slowNode = node;
		SLLNode fastNode = node;
		
		while(fastNode != null) {
			slowNode = slowNode.next;
			if(fastNode.next != null) {
				fastNode = fastNode.next.next;
			} else {
				fastNode = null;
			}
			
			if(slowNode == fastNode) {
				loopNode = slowNode;
				return true;
			}
			
		}
		
		return false;
	}

}
