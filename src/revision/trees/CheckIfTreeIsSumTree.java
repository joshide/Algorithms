package revision.trees;



public class CheckIfTreeIsSumTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(27);
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
		
		if(node.left == null && node.right == null) {
			return true;
		}
		
		boolean left = isSumTree(node.left);
		boolean right = isSumTree(node.right);
		
		if(left && right) {
			int leftSum = 0;
			int rightSum = 0;
			
			if(node.left == null)
				leftSum = 0;
			
			else if(node.left.left == null && node.left.right == null)
				leftSum = node.left.data;
			
			else
				leftSum = 2 * node.left.data;
			
			if(node.right == null)
				rightSum = 0;
			
			else if(node.right.left == null && node.right.right == null)
				rightSum = node.right.data;
			
			else 
				rightSum = 2 * node.right.data;
			
			int totalSum = leftSum + rightSum;
			int diff = totalSum - node.data;
			
			if(diff == 0)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

}
