package revision.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SegmentTreeAndSumOfGivenRange {

	public static void main(String[] args) {
		// An array can be represented as a segment tree
		// In segment tree, array elements are the leaf nodes of the tree
		// Segment tree is a full binary tree
		// it has n leaf nodes and n-1 internal nodes
		// Level order traversal of the tree is the array representation of the segment tree
		// keep null entries for null nodes
		// for index i, left children can be found at index 2i+1 and right index can be found at index 2i+2
		// parent will be at index (i-1)/2
		// each internal node represents some merge of the leaf nodes
		// This merging can be sum of leaf nodes or minimum/maximum of leaf nodes for example
		// root nodes represents the sum of all the nodes
		// left node represent sum of first half, right node represents sum of 2nd half and so on
		
		int[] arr = {1,3,5,7,9,11};
		
		TreeNode node = convertArrayToSegmentTree(arr, 0, arr.length-1);
		
		levelOrderTraversal(node);
		
		int sum = findSum(node,0,5,1,5);
		System.out.println("\n"+sum);

	}
	
	private static int findSum(TreeNode node, int start, int end, int left, int right) {
		
		if(left <= start && right >= end )
			return node.data;
		
		if(right < start || left > end) {
			return 0;
		}
		
		int mid = (start+end)/2;
		return findSum(node.left,start,mid,left,right) + findSum(node.right,mid+1,end,left,right);
	}
	
	private static TreeNode convertArrayToSegmentTree(int[] arr, int start, int end) {
		if(start == end) {
			return new TreeNode(arr[start]);
		}
		
		int mid = (start+end)/2;
		TreeNode leftNode = convertArrayToSegmentTree(arr, start, mid);
		TreeNode rightNode = convertArrayToSegmentTree(arr, mid+1, end);
		TreeNode root = new TreeNode(leftNode.data + rightNode.data);
		root.left = leftNode;
		root.right = rightNode;
		return root;
	}
	
	private static void levelOrderTraversal(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();
			System.out.print(n.data + ",");
			if(n.left != null)
				queue.add(n.left);
			if(n.right != null)
				queue.add(n.right);
		}
	}

}
