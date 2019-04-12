package revision3;

public class SegmentTree {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11};
		
		TreeNode root = buildSegmentTree(arr,0, arr.length-1);

		int sum = findSum(root,1,4,0,arr.length-1);
		System.out.println(sum);
	}
	
	private static int findSum(TreeNode root, int left, int right, int start, int end) {
		if(right < start || left > end) {
			return 0;
		}
		
		if(left <= start && right >= end) {
			return root.data;
		}
		
		int mid = (start+end)/2;
		int leftSum = findSum(root.left,left,right,start,mid);
		int rightSum = findSum(root.right,left,right,mid+1,end);
		return leftSum+rightSum;
	}
	
	
	
	private static TreeNode buildSegmentTree(int[] arr, int start, int end) {
		if(start > end) {
			return null;
		}
		if(start == end) {
			TreeNode node = new TreeNode(arr[start]);
			return node;
		}
		
		int mid = (start+end)/2;
		TreeNode leftNode = buildSegmentTree(arr, start, mid);
		TreeNode rightNode = buildSegmentTree(arr, mid+1, end);
		TreeNode root = new TreeNode(leftNode.data + rightNode.data);
		root.left = leftNode;
		root.right = rightNode;
		return root;
	}

}
