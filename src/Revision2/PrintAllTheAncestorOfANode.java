package Revision2;

public class PrintAllTheAncestorOfANode {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(26);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(20);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n5.right = n6; n6.left = n7;
		
		printAllAncestor(n1,n7);

	}
	
	private static boolean  printAllAncestor(TreeNode root, TreeNode node ) {
		if(root == null) {
			return false;
		}
		
		if(root == node) {
			return true;
		}
		
		boolean left = printAllAncestor(root.left, node);
		boolean right = printAllAncestor(root.right, node);
		
		if(left || right) {
			System.out.print(root.data + ",");
			return true;
		} else {
			return false;
		}
		
	}

}
