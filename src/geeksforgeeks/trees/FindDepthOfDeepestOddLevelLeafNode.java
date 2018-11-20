package geeksforgeeks.trees;

public class FindDepthOfDeepestOddLevelLeafNode {

	private static int maxOddLevel = 0;
	private static TreeNode maxOddLevelLeadNode = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n7.left = n8; n7.right = n9;
		n8.left = n10;
		
		findDepthOfDeepestOddLevelLeafNode(n1, 1); 
		
		System.out.println(maxOddLevel +" " + maxOddLevelLeadNode.data);

	}
	
	private static void findDepthOfDeepestOddLevelLeafNode(TreeNode node, int level) {
		if(node == null)
			return;
		
		if(level%2 == 1) {
			if(level > maxOddLevel) {
				maxOddLevel = level;
				maxOddLevelLeadNode = node;
			}
		}
		
		findDepthOfDeepestOddLevelLeafNode(node.left, level+1);
		findDepthOfDeepestOddLevelLeafNode(node.right, level+1);
		
	}

}
