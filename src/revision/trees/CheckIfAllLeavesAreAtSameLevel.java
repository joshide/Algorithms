package revision.trees;

public class CheckIfAllLeavesAreAtSameLevel {

	private static int firstFoundLevel = -1;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		
		boolean result = areLeavesAtSameLevel(n1, 1);
		System.out.println(result);

	}
	
	private static boolean areLeavesAtSameLevel(TreeNode node, int level) {
		if(node == null)
			return true;
		
		if(node.left == null && node.right == null) {
			if(firstFoundLevel == -1) {
				firstFoundLevel = level;
				return true;
			} else {
				if(level == firstFoundLevel) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		boolean left = areLeavesAtSameLevel(node.left, level+1);
		boolean right = areLeavesAtSameLevel(node.right, level+1);
		
		return left && right;
		
		
	}

}
