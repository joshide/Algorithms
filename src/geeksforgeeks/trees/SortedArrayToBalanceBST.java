package geeksforgeeks.trees;

public class SortedArrayToBalanceBST {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		TreeNode rootNode = buildBalanceBST(arr, 0, arr.length-1);
		
		TreeNode.inorder(rootNode);
		System.out.println("");
		TreeNode.preorder(rootNode);

	}
	
	private static TreeNode buildBalanceBST(int[] arr, int start, int end) {
		if(start == end)
			return new TreeNode(arr[start]);
		
		if(start > end)
			return null;
		
		int mid = (start+end)/2;
		
		TreeNode node = new TreeNode(arr[mid]);
		TreeNode leftNode = buildBalanceBST(arr, start, mid-1);
		TreeNode rightNode = buildBalanceBST(arr, mid+1, end);
		
		node.left = leftNode;
		node.right = rightNode;
		
		return node;
		
	}

}
