package revision.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(50);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(30);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		
		connectNodesAtSameLevel(n1);
		
		System.out.println(n1.next);
		System.out.println(n2.next.data);
		System.out.println(n3.next);
		System.out.println(n4.next.data);
		System.out.println(n5.next.data);
		System.out.println(n6.next.data);
		System.out.println(n7.next);
		
		

	}
	
	private static void connectNodesAtSameLevel(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size != 0) {
				TreeNode dequeuedNode = queue.poll();
				dequeuedNode.next = queue.peek();
				size--;
				if(dequeuedNode.left != null) {
					queue.add(dequeuedNode.left);
				}
				if(dequeuedNode.right != null) {
					queue.add(dequeuedNode.right);
				}
				if(size == 0) {
					dequeuedNode.next = null;
				}
			}
		}
	}

}
