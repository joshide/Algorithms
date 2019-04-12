package revision.trees;

public class SumOfAllNumbersRootToLeaf {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(4);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		n5.left = n7; n5.right = n8;
		
		int sum = sumRootToLeaf(n1, 0);
		System.out.println(sum);
		

	}
	
	private static int sumRootToLeaf(TreeNode node, int value) {
		if(node == null)
			return 0;
		
		if(node.left == null && node.right == null) {
			return value + node.data;
		}
		
		int left = sumRootToLeaf(node.left, (node.data + value)*10);
		int right = sumRootToLeaf(node.right, (node.data + value)*10);
		return left + right;
		
	}

}
