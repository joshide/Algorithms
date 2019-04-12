package revision.trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTreeIteratively {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2; n1.right = n3;
		n3.left = n4; n4.right = n5;
		
		int height = height(n1);
		System.out.print(height);

	}
	
	private static int height(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(node);
		int count = 0;
		while(!queue.isEmpty()) {
			count++;
			int size = queue.size();
			
			while(size != 0) {
				TreeNode dequeuedNode = queue.poll();
				size--;
				if(dequeuedNode.left != null)
					queue.add(dequeuedNode.left);
				if(dequeuedNode.right != null)
					queue.add(dequeuedNode.right);
			}
		}
		return count;
	}

}
