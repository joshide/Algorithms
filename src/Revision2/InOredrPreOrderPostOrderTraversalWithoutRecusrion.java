package Revision2;

import java.util.Stack;

public class InOredrPreOrderPostOrderTraversalWithoutRecusrion {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		
		System.out.println("Inorder");
		inorder(n1);
		System.out.println("\nPreorder");
		preorder(n1);
		System.out.println("\nPostorder");
		postorder(n1);

	}
	
	private static void inorder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = node;
		while(true) {
			while(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			
			if(currentNode == null && !stack.isEmpty()) {
				TreeNode poppedNode = stack.pop();
				System.out.print(poppedNode.data + ",");
				currentNode = poppedNode.right;
			}
			
			if(currentNode == null && stack.isEmpty()) {
				return;
			}
		}
	}
	
	private static void preorder(TreeNode node) {
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
	
	private static void postorder(TreeNode node) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		stack1.push(node);
		
		while(!stack1.isEmpty()) {
			TreeNode poppedNode = stack1.pop();
			stack2.push(poppedNode);
			if(poppedNode.left != null) {
				stack1.push(poppedNode.left);
			}
			
			if(poppedNode.right != null) {
				stack1.push(poppedNode.right);
			}
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + ",");
		}
	}

}
