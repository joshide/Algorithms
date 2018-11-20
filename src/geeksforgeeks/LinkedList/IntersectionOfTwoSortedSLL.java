package geeksforgeeks.LinkedList;

public class IntersectionOfTwoSortedSLL {

	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(1);
		SLLNode n2 = new SLLNode(2);
		SLLNode n3 = new SLLNode(3);
		SLLNode n4 = new SLLNode(4);
		SLLNode n5 = new SLLNode(6);

		// 1,2,3,4,6
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		
		//2,4,6,8
		SLLNode n11 = new SLLNode(2);
		SLLNode n22 = new SLLNode(4);
		SLLNode n33 = new SLLNode(6);
		SLLNode n44 = new SLLNode(8);
		
		n11.next = n22; n22.next = n33; n33.next = n44;
		
		//2,4,6
		SLLNode node = intersection(n1, n11);
		
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
	}
	
	private static SLLNode intersection(SLLNode node1, SLLNode node11) {
		
		SLLNode head = null;
		SLLNode currentNode = null;
		
		while(true) {
			if(node1 == null || node11 == null) {
				return head;
			}
			
			if(node1.data == node11.data) {
				if(head == null) {
					head = new SLLNode(node1.data);
					currentNode = head;
					
				} else {
					SLLNode node = new SLLNode(node1.data);
					currentNode.next = node;
					currentNode = node;
				}
				node1 = node1.next;
				node11 = node11.next;
			} else if (node1.data < node11.data) {
				node1 = node1.next;
			} else {
				node11 = node11.next;
			}	
			
		}
	}

}
