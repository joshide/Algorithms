package geeksforgeeks.LinkedList;

public class InplaceConversionOfSortedDLLToBST {

	private static DLLNode head = null;
	public static void main(String[] args) {
		//1,2,3,4,5,6,7
		DLLNode n1 = new DLLNode(1);
		DLLNode n2 = new DLLNode(2);
		DLLNode n3 = new DLLNode(3);
		DLLNode n4 = new DLLNode(4);
		DLLNode n5 = new DLLNode(5);
		DLLNode n6 = new DLLNode(6);
		DLLNode n7 = new DLLNode(7);
		
		head = n1;
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		n7.prev = n6; n6.prev = n5; n5.prev = n4; n4.prev = n3; n3.prev = n2; n2.prev = n1;
		
		DLLNode node = convertToBSTInPlace(n1,0,6);
		System.out.println(n1.data + " " + n1.next + " " +n1.prev);
		System.out.println(n2.data + " " + n2.prev.data + " " +n2.next.data);
		System.out.println(n3.data + " " + n3.next + " " +n3.prev);
		System.out.println(n4.data + " " + n4.prev.data + " " +n4.next.data);
		System.out.println(n5.data + " " + n5.prev + " " +n5.prev);
		System.out.println(n6.data + " " + n6.prev.data + " " +n6.next.data);
		System.out.println(n7.data + " " + n7.prev + " " +n7.next);
		
		
		

	}
	
	private static DLLNode convertToBSTInPlace(DLLNode node, int start, int end) {
		if(start == end) {
			node.prev = null;
			node.next = null;
			return node;
		}
			
		
		int mid = (start+end)/2;
		DLLNode midNode = findNode(node, mid);
		DLLNode left = convertToBSTInPlace(node, 0, mid-1-start);
		DLLNode right = convertToBSTInPlace(midNode.next, 0, end-(mid+1));
		midNode.prev = left;
		midNode.next = right;
		
		
		return midNode;
		
	}
	
	private static DLLNode findNode(DLLNode node, int index) {
		DLLNode currentNode = node;
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.next;
			
		}
		return currentNode;
	}

}
