package geeksforgeeks.trees;

public class DiamtereOfABinaryTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(1);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(1);
		TreeNode n10 = new TreeNode(1);
		TreeNode n11 = new TreeNode(1);
		TreeNode n12 = new TreeNode(1);
		TreeNode n13 = new TreeNode(1);
		
		n1.left = n2; n1.right = n13;
		n2.left = n3; n2.right = n8;
		n3.left = n4; n3.right = n5;
		n5.left = n6;
		n6.right = n7;
		n8.right = n9;
		n9.left = n10; n9.right = n11;
		n11.left = n12;
		
		int diameter = diameter(n1);
		
		System.out.println(diameter);
		

	}
	
	private static int diameter(TreeNode node) {
		if(node == null)
			return 0;
		
		if(node.left == null && node.right == null)
			return 1;
		
		int leftDiameter = diameter(node.left);
		int rightDiameter = diameter(node.right);
		int crossOverDiameter = 1 + height(node.left) + height(node.right);
		
		if(leftDiameter > rightDiameter && leftDiameter > crossOverDiameter)
			return leftDiameter;
		
		if(rightDiameter > leftDiameter && rightDiameter > crossOverDiameter)
			return rightDiameter;
		
		else
			return crossOverDiameter;
	}
	
	private static int height(TreeNode node) {
		if(node == null)
			return 0;
		
		if(node.left == null && node.right == null)
			return 1;
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		return 1  + Math.max(leftHeight, rightHeight);
	}

}
