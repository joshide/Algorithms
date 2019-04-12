package revision3;

public class TreeToDoubleLinkedList {

	private static TreeNode previous = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		
		TreeNode node = convertToDLL(n1);
		
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.right;
		}
		
	}
	
	private static TreeNode convertToDLL(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		convertToDLL(node.right);
		node.right = previous;
		if(previous != null) {
			previous.left = node;
		}
		previous = node;
		convertToDLL(node.left);
		
		return previous;
	}

}
