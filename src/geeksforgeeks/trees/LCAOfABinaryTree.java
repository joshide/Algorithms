package geeksforgeeks.trees;

public class LCAOfABinaryTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n7.left = n8;
		
		TreeNode lca = lcaOfBinaryTree(n1, n6, n8);
		System.out.println(lca.data);

	}
	
	private static TreeNode lcaOfBinaryTree(TreeNode root, TreeNode n1, TreeNode n2) {
		
		if(root == null)
			return null;
		
		if(root.data == n1.data || root.data == n2.data)
			return root;
		
		TreeNode leftNode = lcaOfBinaryTree(root.left, n1, n2);
		TreeNode rightNode = lcaOfBinaryTree(root.right, n1, n2);
		
		if(leftNode == null && rightNode == null)
			return null;
		
		if(leftNode != null && rightNode != null)
			return root;
		
		if(leftNode == null && rightNode != null)
			return rightNode;
		
		return leftNode;
	}

}
