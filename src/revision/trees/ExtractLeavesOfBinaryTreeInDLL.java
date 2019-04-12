package revision.trees;

public class ExtractLeavesOfBinaryTreeInDLL {

	private static TreeNode currentLeafNode = null;
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
		
		extractLeafNode(n1, null);
		
		while(n4 != null) {
			System.out.print(n4.data + ",");
			n4 = n4.right;
		}
		
		inorder(n1);

	}
	
	private static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + ",");
		inorder(node.right);
	}
	
	private static void extractLeafNode(TreeNode node, TreeNode parent) {
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null) {
			if(currentLeafNode != null) {
				currentLeafNode.right = node;
			}
			node.left = currentLeafNode;
			currentLeafNode = node;
			
			if(parent.left == node) {
				parent.left = null;
			} 
			
			if(parent.right == node) {
				parent.right = null;
			}
			
			node.parent = null;
			return;
		}
		
		extractLeafNode(node.left, node);
		extractLeafNode(node.right, node);
		
	}

}
