package Revision2;

public class TreeBasicOperations {

	private static TreeNode root = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(15);
		TreeNode n7 = new TreeNode(40);
		
		insert(n1); insert(n2); insert(n3); insert(n4); insert(n5); insert(n6); insert(n7);
		
		inorder(root);
		
		System.out.println("\nInorder Successor: " + inorderSuccessor(n6).data );

	}
	
	//O(logn)
	private static TreeNode inorderSuccessor(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		if(node.right != null) {
			return minimum(node.right);
		} else {
			TreeNode parent = node.parent;
			
			while(parent != null && node != parent.left) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	
	// O(logn)
	private static TreeNode minimum(TreeNode node) {
		if(node == null)
			return null;
		
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	
	//O(n)
	private static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + ",");
		inorder(node.right);
	}
	
	//O(logn)
	private static void insert(TreeNode node) {
		if(root == null) {
			root = node;
			return;
		}
		
		TreeNode parent = null;
		TreeNode currentNode = root;
		
		while(currentNode != null) {
			if(node.data < currentNode.data) {
				parent = currentNode;
				currentNode = currentNode.left;
			} else {
				parent = currentNode;
				currentNode = currentNode.right;
			}
		}
		
		node.parent = parent;
		if(node.data < parent.data) {
			parent.left = node;
		} else {
			parent.right = node;
		}
	}

}
