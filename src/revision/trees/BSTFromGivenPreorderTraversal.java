package revision.trees;

public class BSTFromGivenPreorderTraversal {

	public static void main(String[] args) {
		int[] arr = {10,5,1,7,40,50};
		TreeNode root = constructBST(arr, 0, arr.length - 1);
		
		inorder(root);
	}
	
	private static TreeNode constructBST(int[] arr, int start, int end) {
		if(start == end) {
			return new TreeNode(arr[start]);
		}
		
		if(start > end) {
			return null;
		}
		
		TreeNode node = new TreeNode(arr[start]);
		int index = findFirstMax(arr, start, end);
		TreeNode leftNode = constructBST(arr, start+1, index-1);
		TreeNode rightNode = constructBST(arr, index, end);
		
		node.left = leftNode;
		node.right = rightNode;
		
		return node;
		
		
	}
	
	private static int findFirstMax(int[]arr, int start, int end) {
		int value = arr[start];
		for(int i = start+1; i <= end; i++) {
			if(arr[i] > value) {
				return i;
			}
		}
		return end+1;
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
