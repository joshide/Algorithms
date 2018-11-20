package geeksforgeeks.trees;

public class PrintNodeAtAGivenLevelK {

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
		
		printNodeAtLevelK(n1,3, 1);

	}
	
	private static void printNodeAtLevelK(TreeNode node, int k, int level) {
		if(node == null)
			return;
		
		if(level > k) {
			return;
		}
		if(level == k) {
			System.out.print(node.data + ",");
			return;
		}
		
		printNodeAtLevelK(node.left, k, level+1);
		printNodeAtLevelK(node.right, k, level+1);
		
		
	}

}
