package geeksforgeeks.trees;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfABinaryTree {

	private static Map<Integer, Integer> map = new HashMap();
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.right = n8;
		n8.left = n6; n8.right = n7;	
		
		maxWidth(n1,1);
		
		Collection<Integer> values = map.values();
		int max = Integer.MIN_VALUE;
		for(int value : values) {
			max = Math.max(max, value);
		}

		System.out.print(max);
	}
	
	private static void maxWidth(TreeNode node, int level) {
		if(node == null)
			return;
		
		if(map.get(level) != null) {
			int value = map.get(level) + 1;
			map.put(level, value);
		} else {
			map.put(level, 1);
		}
		maxWidth(node.left, level+1);
		maxWidth(node.right, level + 1);
		
	}

}
