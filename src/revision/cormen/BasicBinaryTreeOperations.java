package revision.cormen;

import org.w3c.dom.Node;

public class BasicBinaryTreeOperations {

	private static TreeNode root = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(50);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(80);
		TreeNode n4 = new TreeNode(10);
		TreeNode n5 = new TreeNode(30);
		TreeNode n6 = new TreeNode(60);
		TreeNode n7 = new TreeNode(90);
		
		insert(n1);insert(n2);insert(n3);insert(n4);insert(n5);insert(n6);insert(n7);
		
		// inorder traversal of binary search tree always gives an sorted output
		// We have other way to traverse the binary tree like preorder, postorder or level order traversal
		inorderTraversal(n1);
		
		TreeNode node = getMax(n1);
		
		System.out.println("\nMaximum Value of the tree is : " + node.data);
		
		System.out.println("Successor : " + inorderSuccessor(n3).data);

	}
	
	private static TreeNode inorderSuccessor(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		if(node.right != null) {
			return getMin(node.right);
		}
		
		TreeNode parent = node.parent;
		
		while(parent != null && parent.left != node) {
			node = parent;
			parent = node.parent;
		}
		
		return parent;
	}
	
	private static TreeNode getMin(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}
	
	private static TreeNode getMax(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		while(node.right != null) {
			node = node.right;
		}
		
		return node;
	}
	
	private static void inorderTraversal(TreeNode node) {
		if(node == null)
			return;
		inorderTraversal(node.left);
		System.out.print(node.data + ",");
		inorderTraversal(node.right);
	}
	
	// Time Complexity : O(logn)
	private static void insert(TreeNode node) {
		if(root == null) {
			root = node;
			return;
		}
		
		TreeNode parentNode = null;
		TreeNode currentNode = root;
		
		while(currentNode != null) {
			if(node.data < currentNode.data) {
				parentNode = currentNode;
				currentNode = currentNode.left;
			} else {
				parentNode = currentNode;
				currentNode = currentNode.right;
			}
		}
		
		if(node.data < parentNode.data) {
			parentNode.left = node;
			node.parent = parentNode;
		} else {
			parentNode.right = node;
			node.parent = parentNode;
		}
	}

}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	TreeNode(int data) {
		this.data = data;
	}
}
