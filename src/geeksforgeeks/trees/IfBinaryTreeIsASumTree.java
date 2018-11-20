package geeksforgeeks.trees;

public class IfBinaryTreeIsASumTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(26);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(3);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		
		boolean result = isSumTree(n1);
		System.out.println(result);
		
	}
	
	private static boolean isSumTree(TreeNode node) {
		if(node == null)
			return true;
		
		if(node.left == null && node.right == null)
			return true;
		
		if(isSumTree(node.left) && isSumTree(node.right)) {
			
			int ls = 0;
			int rs = 0;
			
			TreeNode leftNode = node.left;
			TreeNode rightNode = node.right;
			
			if(leftNode == null)
				ls = 0;
			else if(leftNode.left == null && leftNode.right == null)
				ls = leftNode.data;
			else
				ls = 2 * leftNode.data;
			
			
			if(rightNode == null)
				rs = 0;
			else if(rightNode.left == null && rightNode.right == null)
				rs = rightNode.data;
			else
				rs = 2 * rightNode.data;
			
			if(node.data == ls + rs)
				return true;
			else
				return false;	
		}
		return false;
	}

}
