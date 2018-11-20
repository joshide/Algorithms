package geeksforgeeks.trees;

import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

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
		
		spiralLevelOrderTraversal(n1);

	}
	
	private static void spiralLevelOrderTraversal(TreeNode node) {
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		stack1.push(node);
		
		while(true) {
			
			while(!stack1.isEmpty()) {
				
				TreeNode poppedNode = stack1.pop();
				System.out.print(poppedNode.data + ",");
				if(poppedNode.right != null) {
					stack2.push(poppedNode.right);
				}
				if(poppedNode.left != null) {
					stack2.push(poppedNode.left);
				}
			}
			
			while(!stack2.isEmpty()) {
				TreeNode poppedNode = stack2.pop();
				System.out.print(poppedNode.data +",");
				if(poppedNode.left != null) {
					stack1.push(poppedNode.left);
				}
				if(poppedNode.right != null) {
					stack1.push(poppedNode.right);
				}
			}
			
			if(stack1.isEmpty() && stack2.isEmpty()) {
				return;
			}
		}
	}

}
