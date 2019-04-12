package revision3;

public class AncestorsOfANode {

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
		
		findAncestors(root,n5);
		
	}
	
	private static boolean findAncestors(TreeNode root, TreeNode node) {
		if(root == null) {
			return false;
		}
		
		if(root == node) {
			System.out.print(root.data + ",");
			return true;
		}
		
		boolean left = findAncestors(root.left, node);
		boolean right = findAncestors(root.right, node);
		
		if(left == true || right == true) {
			System.out.print(root.data + ",");
			return true;
		} else {
			return false;
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
