package geeksforgeeks.trees;

import java.util.Stack;

public class MergeTwoBSTWithNoExtraSpace {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(4);
		
		n1.left = n2; n1.right = n3;
		
		TreeNode n11 = new TreeNode(8);
		TreeNode n22 = new TreeNode(6);
		TreeNode n33 = new TreeNode(10);
		
		n11.left = n22; n11.right = n33;
		
		merge(n11, n1);

	}
	
	private static void merge(TreeNode n1, TreeNode n2) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		
		TreeNode currentNode1 = n1;
		TreeNode currentNode2 = n2;
		
		while(true) {
			
			while(currentNode1 != null) {
				stack1.push(currentNode1);
				currentNode1 = currentNode1.left;
			}
			
			while(currentNode2 != null) {
				stack2.push(currentNode2);
				currentNode2 = currentNode2.left;
			}
			
			TreeNode poppedNode1 = null;
			TreeNode poppedNode2 = null;
			
			if(currentNode1 == null && !stack1.isEmpty()) {
				 poppedNode1 = stack1.pop();	
			} 
			
			
			if(currentNode2 == null && !stack2.isEmpty()) {
				 poppedNode2 = stack2.pop();
			}
			
		
			
			if(poppedNode1!= null && poppedNode2 != null ) {
				if(poppedNode1.data < poppedNode2.data) {
					System.out.print(poppedNode1.data + ",");
					currentNode1 = poppedNode1.right;
					stack2.push(poppedNode2);
				} else {
					System.out.print(poppedNode2.data + ",");
					currentNode2 = poppedNode2.right;
					stack1.push(poppedNode1);
				}
			}
			if(poppedNode1 == null && poppedNode2 == null)
				return;
			
			if(poppedNode1 == null) {
				System.out.print(poppedNode2.data + ",");
				currentNode2 = poppedNode2.right;
				//continue;
			}
			
			if(poppedNode2 == null) {
				System.out.print(poppedNode1.data + ",");
				currentNode1 = poppedNode1.right;
				//continue;
			}
	}
	}

}
