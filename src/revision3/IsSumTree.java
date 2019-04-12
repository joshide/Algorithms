package revision3;


public class IsSumTree {

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
		
		boolean isSumTree = isSumTree(n1);
		System.out.println(isSumTree);

	}
	
	private static boolean isSumTree(TreeNode node) {
		
		if(node == null || (node.left == null && node.right == null)) {
			return true;
		}
		
		boolean left = isSumTree(node.left);
		boolean right = isSumTree(node.right);
		
		if(left == false || right == false) {
			return false;
		}
		
		int rootData = node.data;
		int leftData = node.left == null ? 0 : node.left.data;
		int rightData = node.right == null ? 0 : node.right.data;
		int sum = leftData + rightData;
		
		if(sum != rootData) {
			return false;
		} else {
			node.data = 2 * rootData;
			return true;
		}
		
	}

}
