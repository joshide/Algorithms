package revision.linkedlists;

public class PairwiseSwap {

	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(1);
		SLLNode n2 = new SLLNode(2);
		SLLNode n3 = new SLLNode(3);
		SLLNode n4 = new SLLNode(4);
		SLLNode n5 = new SLLNode(5);
		SLLNode n6 = new SLLNode(6);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next =n6;
		
		SLLNode resultNode = pairwiseSwap(n1);
		
		while(resultNode != null) {
			System.out.print(resultNode.data + ",");
			resultNode = resultNode.next;
		}

	}
	
	private static SLLNode pairwiseSwap(SLLNode node) {
		if(node == null || node.next == null) {
			return node;
		}
		
		SLLNode resultNode = pairwiseSwap(node.next.next);
		SLLNode currentNode = node;
		SLLNode nextNode = node.next;
		
		nextNode.next = currentNode;
		currentNode.next = resultNode;
		
		return nextNode;
				
	}

}
