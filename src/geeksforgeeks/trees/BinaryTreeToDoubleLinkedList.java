package geeksforgeeks.trees;

public class BinaryTreeToDoubleLinkedList {

	private static TreeNode previousNode = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		
		convertToDLL(n1);
		
		TreeNode headNode = previousNode;
		while(headNode != null) {
			System.out.print(headNode.data + "<>");
			headNode = headNode.right;
		}
	}
	
	private static void convertToDLL(TreeNode node) {
		if(node == null)
			return;
		
		convertToDLL(node.right);
		node.right = previousNode;
		if(previousNode != null) {
			previousNode.left = node;
		}
		previousNode = node;
		convertToDLL(node.left);
	}

}
