package revision3;

public class IsBST {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		
		boolean isBST = isBST(n1);
		System.out.print(isBST);

	}
	
	/*
	 * 1. Inorder traversal of binary search tree is always sorted, we can use this property to know if a tree is BST or not
	 * 
	 */
	private static boolean isBST(TreeNode node) {
		if(node == null || (node.left == null && node.right == null)) {
			return true;
		}
		
		boolean left = isBST(node.left);
		boolean right = isBST(node.right);
		
		if(left == false || right == false) {
			return false;
		} else {
			TreeNode maximum = getMaximum(node.left);
			TreeNode minimum = getMinimum(node.right);
			
			if(maximum != null && maximum.data > node.data) {
				return false;
			}
			
			if(minimum != null && minimum.data < node.data) {
				return false;
			}
			
			return true;
		}
	}
	
	private static TreeNode getMaximum(TreeNode node) {
		if(node == null)
			return null;
		
		while(node.right != null) {
			node = node.right;
		}
		
		return node;
	}
	
	private static TreeNode getMinimum(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}

}
