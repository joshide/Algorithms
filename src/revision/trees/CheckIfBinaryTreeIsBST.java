package revision.trees;


public class CheckIfBinaryTreeIsBST {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(7);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6;
		
		boolean isBST = isBST(n1);
		
		System.out.println(isBST);

	}
	
	/*
	 * 1. A Binary tree is BST if the inorder of it is a sorted output
	 * 2. Below is another way to check if tree is BST or not
	 */
	private static boolean isBST(TreeNode node) {
		if(node == null) {
			return true;
		}
		
		if(node.left == null && node.right == null) {
			return true;
		}
		
		boolean leftResult = isBST(node.left);
		boolean rightResult = isBST(node.right);
		
		if(leftResult && rightResult) {
			TreeNode leftMaximum = getMaximum(node.left);
			TreeNode rightMinimum = getMinimum(node.right);
			
			if(leftMaximum != null && leftMaximum.data > node.data) {
				return false;
			}
			
			if(rightMinimum != null && rightMinimum.data < node.data) {
				return false;
			}
			
			return true;
			
		} else {
			return false;
		}
	}
	
	private static TreeNode getMaximum(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		while(node.right != null) {
			node = node.right;
		}
		
		return node;
	}
	
	private static TreeNode getMinimum(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}

}
