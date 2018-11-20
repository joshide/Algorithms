package geeksforgeeks.trees;

public class DifferenceBetweenSumOfEvenAndOddLevel {

	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(12);
		TreeNode n3 = new TreeNode(16);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(17);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		
		int diff = findDiff(n1, 1);
		System.out.println(diff);

	}
	
	private static int findDiff(TreeNode node, int level) {
		if(node == null)
			return 0;
		
		int rootSum = node.data;
		int leftSum = findDiff(node.left,level +1);
		int rightSum = findDiff(node.right, level+1);
		
		return rootSum - (leftSum+rightSum);
	}

}
