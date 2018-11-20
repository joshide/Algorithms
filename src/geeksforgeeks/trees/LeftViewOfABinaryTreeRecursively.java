package geeksforgeeks.trees;

public class LeftViewOfABinaryTreeRecursively {

	private static int maxLevelSoFar = 0;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2; n1.right = n3;
		n3.left = n4; n4.right = n5;
		
		printLeftViewRecursively(n1, 1);

	}
	
	private static void printLeftViewRecursively(TreeNode node, int level) {
		if(node == null)
			return;
		
		if(level > maxLevelSoFar) {
			System.out.print(node.data + " ");
		}
		
		maxLevelSoFar = level;
		printLeftViewRecursively(node.left, level + 1);
		printLeftViewRecursively(node.right, level + 1);
		
	}
	

}
