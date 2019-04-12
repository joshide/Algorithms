package Revision2;

public class IsTreeBST {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		
		boolean isBST = isBST(n1);
		System.out.println(isBST);

	}
	
	private static boolean isBST(TreeNode node) {
		if(node == null || (node.left == null && node.right == null)) {
			return true;
		}
		
		TreeNode leftMax = getLeftMax(node.left);
		TreeNode rightMinimum = getRightMinimum(node.right);
		
		if(leftMax.data > node.data || rightMinimum.data < node.data) {
			return false;
		}
		
		boolean left = isBST(node.left);
		boolean right = isBST(node.right);
		
		return left && right;
	}
	
	private static TreeNode getLeftMax(TreeNode node) {
		if(node == null || (node.left == null && node.right == null)) {
			return node;
		}
		
		while(node.right != null) {
			node = node.right;
		}
		
		return node;
	}
	
	private static TreeNode getRightMinimum(TreeNode node) {
		if(node == null || (node.left == null && node.right == null)) {
			return node;
		}
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}

}
