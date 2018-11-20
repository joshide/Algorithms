package geeksforgeeks.trees;

import static geeksforgeeks.trees.TreeNode.inorder;
public class MirrorTree {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node3;
		node1.right =  node2;
		node2.left = node5;
		node2.right = node4;
		
		mirrorTree(node1);
		
		inorder(node1);

	}
	
	private static void mirrorTree(TreeNode node) {
		if(node == null)
			return;
		
		mirrorTree(node.left);
		mirrorTree(node.right);
		
		TreeNode left = node.left;
		node.left = node.right;
		node.right = left;
	}

}
