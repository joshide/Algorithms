package geeksforgeeks.trees;

public class FindMaxLeafWhichContributeToMaximumSumFromRootToLead {

	private static int maxSumSoFar = Integer.MIN_VALUE;
	private static TreeNode targetLeaf = null;
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
		
		findTargetLeaf(n1, 0);
		
		System.out.println(targetLeaf.data);
		
		printPathToTargetLeaf(n1, targetLeaf);
		
	}
	
	private static void findTargetLeaf(TreeNode node, int currentSum) {
		if(node == null)
			return;
		
		currentSum = currentSum + node.data;
		
		if(currentSum > maxSumSoFar) {
			targetLeaf = node;
			maxSumSoFar = currentSum;
		}
		
		findTargetLeaf(node.left, currentSum);
		findTargetLeaf(node.right, currentSum);
		
	}
	
	private static boolean printPathToTargetLeaf(TreeNode node, TreeNode targetLeaf) {
		if(node == null)
			return false;
		
		if(node.data == targetLeaf.data ||
				printPathToTargetLeaf(node.left, targetLeaf) ||
				printPathToTargetLeaf(node.right, targetLeaf)) {
			System.out.print(node.data +" > ");
			return true;
		}
		return false;
			
			
	}

}
