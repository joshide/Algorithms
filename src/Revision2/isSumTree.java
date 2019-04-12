package Revision2;

public class isSumTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(26);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(3);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		
		boolean isSumTree = isSumTree(n1);
		
		System.out.println(isSumTree);

	}
	
	private static boolean isSumTree(TreeNode node) {
		if(node == null || (node.left == null && node.right == null)) {
			return true;
		}
		
		TreeNode leftNode = node.left;
		TreeNode rightNode = node.right;
		int rootData = node.data;
		int leftData = 0;
		int rightData = 0;
		
		if(leftNode == null) {
			leftData = 0;
		} else {
			leftData = leftNode.data;
			if(leftNode.left != null || leftNode.right != null) {
				leftData = 2*leftNode.data;
			}
		}
		
		
		
		if(rightNode == null) {
			rightData = 0;
		} else {
			rightData = rightNode.data;
			if(rightNode.left != null || rightNode.right != null) {
				rightData = 2*rightNode.data;
			}
		}
		
		if(rootData == leftData + rightData) {
			return isSumTree(node.left) && isSumTree(node.right);
		} else {
			return false;
		}
		
		
	}

}
