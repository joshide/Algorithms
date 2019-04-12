package revision.trees;


public class ConvertBSTToDLL {

	private static TreeNode nextNode = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		
		convertToDLL(n1);
		
		while(n4 != null) {
			System.out.print(n4.data + ",");
			n4 = n4.right;
		}

	}
	
	private static TreeNode convertToDLL(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		convertToDLL(node.right);
		node.right = nextNode;
		if(nextNode != null) {
			nextNode.left = node;
		}
		nextNode = node;
		convertToDLL(node.left);
		return node;
	}

}
