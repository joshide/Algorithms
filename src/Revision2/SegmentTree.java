package Revision2;

public class SegmentTree {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11};
		
		TreeNode node = buildSegmentTree(arr,0,arr.length-1);
		
		inorder(node);
		
		int sum = findSum(node,1,4, 0, arr.length-1);
		System.out.println("\n"+sum);

	}
	
	private static int findSum(TreeNode node, int left, int right, int start, int end) {
		if(right < start || left > end) {
			return 0;
		}
		
		if(left <= start && right >= end) {
			return node.data;
		}
		
		int mid = (start + end) /2;
		int leftData = findSum(node.left, left, right, start, mid);
		int rightData = findSum(node.right, left, right, mid+1, end);
		return leftData + rightData;
	}
	
	private static TreeNode buildSegmentTree(int[] arr, int start, int end) {
		if(start == end) {
			return new TreeNode(arr[start]);
		}
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		TreeNode left = buildSegmentTree(arr, start, mid);
		TreeNode right = buildSegmentTree(arr, mid+1, end);
		TreeNode root = new TreeNode(left.data + right.data);
		root.left = left;
		root.right = right;
		return root;
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
