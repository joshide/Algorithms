package revision3;

import java.util.Stack;

public class AllTreeTraversalWithoutRecursion {

	private static TreeNode root = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(15);
		TreeNode n7 = new TreeNode(25);
		
		insert(n1); insert(n2); insert(n3); insert(n4); insert(n5); insert(n6); insert(n7);
		
		System.out.println("inorder traversal");
		inorderTraversal(n1);
		
		System.out.println("\npreorder traversal");
		preorderTraversal(n1);

	}
	
	private static void preorderTraversal(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			TreeNode poppedNode = stack.pop();
			System.out.print(poppedNode.data +",");
			if(poppedNode.right != null) {
				stack.push(poppedNode.right);
			}
			if(poppedNode.left != null) {
				stack.push(poppedNode.left);
			}
		}
	}
	
	private static void inorderTraversal(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(true) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			
			if(node == null && !stack.isEmpty()) {
				TreeNode poppedNode = stack.pop();
				System.out.print(poppedNode.data + ",");
				if(poppedNode.right != null) {
					node = poppedNode.right;
				}
			} else {
				return;
			}
		}
	}
	
	private static void insert(TreeNode node) {
		if(root == null) {
			root = node;
			return;
		}
		
		TreeNode parent = null;
		TreeNode currentNode = root;
		
		while(currentNode != null) {
			parent = currentNode;
			if(node.data < currentNode.data) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		
		if(node.data < parent.data) {
			parent.left = node;
		} else {
			parent.right = node;
		}
		node.parent = parent;
	}

}
