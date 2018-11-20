package geeksforgeeks.trees;

import java.util.Stack;

public class PreorderTraversalWithoutRecursion {

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
		
		preorderTraversalWithoutRecursion(n1);
		

	}
	
	private static void preorderTraversalWithoutRecursion(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(node);
		
		while(!stack.isEmpty()) {
			TreeNode poppedNode = stack.pop();
			System.out.print(poppedNode.data + ",");
			if(poppedNode.right != null) {
				stack.push(poppedNode.right);
			}
			if(poppedNode.left != null) {
				stack.push(poppedNode.left);
			}
		}
	}

}
