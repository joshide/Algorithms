package geeksforgeeks.LinkedList;

public class AlternateSplitOfNodeInSLL {

	private static SLLNode nodeA = null;
	private static SLLNode nodeB = null;
	public static void main(String[] args) {
		
		//0,1,0,1,0,1
		SLLNode n1 = new SLLNode(0);
		SLLNode n2 = new SLLNode(1);
		SLLNode n3 = new SLLNode(0);
		SLLNode n4 = new SLLNode(1);
		SLLNode n5 = new SLLNode(0);
		SLLNode n6 = new SLLNode(1);
		SLLNode n7 = new SLLNode(0);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		
		splitAlternateNodes(n1);
		
		System.out.println("List A");
		while(nodeA != null) {
			System.out.print(nodeA.data + ",");
			nodeA = nodeA.next;
		}
		
		System.out.println("\nList B");
		while(nodeB != null) {
			System.out.print(nodeB.data + ",");
			nodeB = nodeB.next;
		}

	}
	
	private static void splitAlternateNodes(SLLNode node) {
		if(node == null) {
			return;
		}
		
		SLLNode currentNode = node;
		SLLNode nextNode = currentNode.next;
		
		nodeA = currentNode;
		nodeB = nextNode;
		
		while(nextNode != null) {
			currentNode.next = nextNode.next;
			currentNode = currentNode.next;
			
			if(currentNode != null) {
				nextNode.next = currentNode.next;
			} 
			
			if(currentNode != null) {
				nextNode = currentNode.next;
			} else {
				nextNode = null;
			}
		}
			
	}

}
