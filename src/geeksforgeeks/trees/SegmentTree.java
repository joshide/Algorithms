package geeksforgeeks.trees;

public class SegmentTree {

	public static void main(String[] args) {
		// In segment tree, every leaf node is the element of the array
		// every internal node is some merge of the leaf node
		// Since Segment tree is built using divide and conquer rule, Segment Tree is Full binary tree
		// Total number of nodes = n + (n-1). n-1 internal nodes. n leaf nodes or array element.
		// height of segment tree : logn
		// space is 2 * (2n-1), since we need to store the range in each node too.
		// Segment tree can be represented in array form by doing level order traversal
		// left node will be 2i+1, right will be 2i+2 and parent will be (i-1)/2
		
		int[] arr = {1,3,5,7,9,11};
		
		TreeNode root = buildSegmentTree(arr,0,arr.length-1);
		
		TreeNode.inorder(root);
		
		//Sum of Given Range
		int sum = findSum(root,5,5);
		System.out.println("\n"+sum);
		
		// update an index
		// 1. start from the root and add diff(value) in the node (preorder traversal) 
		// if the index is in range of nodes left and right index
		// other wise return
		
		// Range minimum query
		// 1. build tree the same way except merge operation here is the minimum of values except sum
		// 2. find the minimum in the segment tree same way we find the sum between two values but except sum
		// it will be min operation
		

	}
	
	private static int findSum(TreeNode node, int leftIndex, int rightIndex) {
		
		if(leftIndex <= node.leftIndex && rightIndex >= node.rightIndex)
			return node.data;
		
		if (rightIndex < node.leftIndex || leftIndex > node.rightIndex)
			return 0;
		
		return findSum(node.left, leftIndex, rightIndex) + 
				findSum(node.right, leftIndex, rightIndex);
	}
	
	private static TreeNode buildSegmentTree(int[] arr, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex) {
			TreeNode node = new TreeNode(arr[leftIndex]);
			node.leftIndex = leftIndex;
			node.rightIndex = rightIndex;
			return node;
		}
		
		int mid = (leftIndex + rightIndex)/2;
		TreeNode leftValue = buildSegmentTree(arr, leftIndex, mid);
		TreeNode rightValue = buildSegmentTree(arr, mid+1, rightIndex);
		TreeNode node = new TreeNode(leftValue.data + rightValue.data);
		node.leftIndex = leftIndex;
		node.rightIndex = rightIndex;
		node.left = leftValue;
		node.right = rightValue;
		return node;
	}

}
