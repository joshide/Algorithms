package revision.trees;

public class PopulateInorderSuccessor {

	private static TreeNode nextNode = null;
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
		
		populateInorderSuccessor(n1);
		
		while(n4!= null) {
			System.out.print(n4.data + ",");
			n4 = n4.next;
		}

	}
	
	private static void populateInorderSuccessor(TreeNode node) {	
		if(node == null)
			return ;
		
		populateInorderSuccessor(node.right);
		node.next = nextNode;
		nextNode = node;
		populateInorderSuccessor(node.left);
		
		
	}

}
