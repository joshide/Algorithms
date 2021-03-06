package revision.trees;

public class PrintAllAncestor {

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
		
		printAllAncestor(n1, n7);

	}
	
	private static TreeNode printAllAncestor(TreeNode node, TreeNode nodeToBeFound) {
		if(node == null) {
			return null;
		}
		
		if(node == nodeToBeFound) {
			System.out.print(node.data + ",");
			return node;
		}
		
		TreeNode leftResult = printAllAncestor(node.left, nodeToBeFound);
		TreeNode rightResult = printAllAncestor(node.right, nodeToBeFound);
		
		if(leftResult == null && rightResult == null)
			return null;
		
		if(leftResult != null || rightResult != null) {
			System.out.print(node.data + ",");
		}
		
		return node;
	}

}
