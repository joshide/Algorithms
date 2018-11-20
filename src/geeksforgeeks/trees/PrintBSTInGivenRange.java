package geeksforgeeks.trees;

public class PrintBSTInGivenRange {

	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(20);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(22);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(12);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		
		int k1 = 10;
		int k2 = 22;
		
		printKeysInAGivenRange(n1, k1, k2);

	}
	
	private static void printKeysInAGivenRange(TreeNode node, int k1, int k2) {
		if(node == null)
			return;
		
		if(node.data >=k1 && node.data <= k2) {
			System.out.print(node.data + ",");
			printKeysInAGivenRange(node.left, k1, k2);
			printKeysInAGivenRange(node.right, k1, k2);
		} else if(node.data < k1) {
			printKeysInAGivenRange(node.right, k1, k2);
		} else {
			printKeysInAGivenRange(node.left, k1, k2);
		}
		
	}

}
