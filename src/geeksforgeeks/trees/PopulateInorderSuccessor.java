package geeksforgeeks.trees;

public class PopulateInorderSuccessor {

	private static TreeNode nextNode = null;
	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
			
		node1.left = node2; node1.right = node3;
		
		node2.left = node4; node2.right = node5;
		
		node3.left = node6; node3.right = node7;
		
		populateInorderTraversal(node1);
		
		TreeNode node = node4;
		
		while(node != null) {
			System.out.print(node.data +",");
			node = node.next;
		}

	}
	
	private static void populateInorderTraversal(TreeNode node) {
		// using stack and reverse inorder traversal we can do this.
		
		// Using static variable
		if(node == null)
			return;
		
		populateInorderTraversal(node.right);
		node.next = nextNode;
		nextNode = node;
		populateInorderTraversal(node.left);	
	}
	
	private static void populateInorderTraversalWithoutStaticVariable(TreeNode node, TreeNode nextNode) {
		
		if(node == null)
			return;
		
		populateInorderTraversalWithoutStaticVariable(node.right, nextNode);
		node.next = nextNode;
		nextNode = node;
		populateInorderTraversalWithoutStaticVariable(node.left, nextNode);
		
		
	}

}
