package geeksforgeeks.trees;

public class IfTreeisBST {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(10);
		TreeNode n5 = new TreeNode(3);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		
		boolean isBST = isBST(n1);
		
		System.out.println(isBST);

	}
	
	private static boolean isBST(TreeNode node) {
		// a binary tree is BST is its inorder is a sorted traversal otherwise not
		// we can use this information to test if the tree is BST or not
		
		// below is a different recusrive algorithm
		
		if(node == null)
			return false;
		
		if(node.left == null && node.right == null) {
			return true;
		}
		
		TreeNode leftMaximum = getMaximum(node.left);
		TreeNode rightMinimum = getMinimum(node.right);
		
		if(leftMaximum != null) {
			if(leftMaximum.data > node.data) {
				return false;
			}
		}
		
		if(rightMinimum != null) {
			if(rightMinimum.data < node.data) {
				return false;
			}
		}
		
		boolean leftResult = isBST(node.left);
		boolean rightResult = isBST(node.right);
		
		return leftResult && rightResult;
	}
	
	private static TreeNode getMaximum(TreeNode node) {
		if(node == null)
			return null;
		
		if(node.left == null && node.right == null)
			return node;
		
		return getMaximum(node.right);
	}
	
	private static TreeNode getMinimum(TreeNode node) {
		if(node == null)
			return null;
		
		if(node.left == null && node.right == null)
			return node;
		
		return getMaximum(node.left);
	}
		
		
}
