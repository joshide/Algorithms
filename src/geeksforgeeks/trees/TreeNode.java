package geeksforgeeks.trees;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class TreeNode {
	
	int data;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	int leftIndex;
	int rightIndex;
	
	TreeNode(int data) {
		this.data = data;
	}
	
	public static void inorder(TreeNode node) {
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.data +",");
		inorder(node.right);
	}
	
	public static void preorder(TreeNode node) {
		if(node == null)
			return;
		
		System.out.print(node.data +",");
		preorder(node.left);
		preorder(node.right);
	}

}
