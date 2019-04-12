package revision.trees;


public class LCA_BinaryTree {

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
		
		TreeNode lcaNode = leastCommonAncestor(root,n7, n6);
		System.out.println(lcaNode.data);

	}
	
	private static TreeNode leastCommonAncestor(TreeNode node, TreeNode n1, TreeNode n2) {
		
		if(node == null) {
			return null;
		}
		
		if(n1 == node || n2 == node) {
			return node;
		}
		
		TreeNode leftNode = leastCommonAncestor(node.left, n1, n2);
		TreeNode rightNode = leastCommonAncestor(node.right, n1, n2);
		
		if(leftNode != null && rightNode != null) {
			return node;
		}
		
		return leftNode != null ? leftNode : rightNode;
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
