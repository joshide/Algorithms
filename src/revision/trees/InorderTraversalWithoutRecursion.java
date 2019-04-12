package revision.trees;

import java.util.Stack;

public class InorderTraversalWithoutRecursion {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(50);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(30);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		
		inorderTraversalWithoutRecursion(n1);
		
		System.out.println("\nPreorder");
		preOrderTraversalWithoutRecursion(n1);
		
		System.out.println("\nPostOrder");
		postOrderTraversalWithoutRecursion(n1);

	}
	
	private static void inorderTraversalWithoutRecursion(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode currentNode = node;
		while(true) {
			
			while(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			
			if(currentNode == null && !stack.isEmpty()) {
				TreeNode poppedNode = stack.pop();
				System.out.print(poppedNode.data + ",");
				if(poppedNode.right != null) {
					currentNode = poppedNode.right;
				}
			}
			
			if(currentNode == null && stack.isEmpty()) {
				return;
			}
		}
	}
	
	private static void preOrderTraversalWithoutRecursion(TreeNode node) {
		Stack<TreeNode> stack = new Stack();
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
	
	private static void postOrderTraversalWithoutRecursion(TreeNode node) {
		Stack<TreeNode> stack1 = new Stack();
		Stack<Integer> stack2 = new Stack();
		
		stack1.push(node);
		while(!stack1.isEmpty()) {
			TreeNode poppedNode = stack1.pop();
			stack2.push(poppedNode.data);
			if(poppedNode.left != null) {
				stack1.push(poppedNode.left);
			}
			if(poppedNode.right != null) {
				stack1.push(poppedNode.right);
			}
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop() + ",");
		}
	}

}
