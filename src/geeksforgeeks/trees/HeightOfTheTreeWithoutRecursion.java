package geeksforgeeks.trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTheTreeWithoutRecursion {

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
		n3.left = n6; n3.right = n7;
		n7.left = n8;
		
		int height = heightOfTreeWithoutRecursion(n1);
		System.out.println(height);

	}
	
	private static int heightOfTreeWithoutRecursion(TreeNode node) {
		// we can make use of level order traversal to know the height of the tree without recursion
		
		Queue<TreeNode> queue = new LinkedList();
		
		queue.add(node);
		int level = 0;
		
		while(!queue.isEmpty()) {	
			int count = queue.size();
			level++;
			while(count != 0) {
				TreeNode dequeuedNode = queue.poll();
				count --;
				if(dequeuedNode.left != null)
					queue.add(dequeuedNode.left);
				if(dequeuedNode.right != null)
					queue.add(dequeuedNode.right);
			}
		}
		return level;
		
		
	}

}
