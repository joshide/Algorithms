package revision.trees;

public class SpecialBinaryTreefromGivenPreorderTraversal {

	private static int index = 0;
	public static void main(String[] args) {
		int[] pre = {10,30,20,5,15};
		String[] leafs = {"N", "N", "L", "L", "L"};
		
		TreeNode node = constructTree(pre,leafs);
		
		inorder(node);
				
	}
	
	private static TreeNode constructTree(int[] pre, String[] leafs) {
		
		if(leafs[index].equals("L")) {
			TreeNode node = new TreeNode(pre[index]);
			index++;
			return node;
		}
		
		TreeNode node = new TreeNode(pre[index]);
		index++;
		node.left = constructTree(pre, leafs);
		node.right = constructTree(pre, leafs);
		return node;
	}
	
	private static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + ",");
		inorder(node.right);
	}

}
