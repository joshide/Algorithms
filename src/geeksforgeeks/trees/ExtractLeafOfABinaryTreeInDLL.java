package geeksforgeeks.trees;

public class ExtractLeafOfABinaryTreeInDLL {

	private static TreeNode previousNode = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		
		n2.parent = n1; n3.parent = n1;
		n4.parent = n2; n5.parent = n2;
		n6.parent = n3; n7.parent = n3;
		
		extractLeafNodesOfABinaryTreeInDLL(n1);
		
		while(previousNode != null) {
			System.out.print(previousNode.data + "<>");
			previousNode = previousNode.left;
		}
		
		TreeNode.inorder(n1);

	}
	
	private static void extractLeafNodesOfABinaryTreeInDLL(TreeNode node) {
		
		if(node == null)
			return;
		
		TreeNode leftNode = node.left;
		TreeNode rightNode = node.right;
		if(node.left == null && node.right == null) {
			if(previousNode != null) {
				previousNode.right = node;
			}
			node.left = previousNode;
			previousNode = node;
			
			if(node == node.parent.left) {
				node.parent.left = null;
			} else {
				node.parent.right = null;
			}
			//System.out.print(previousNode.data +",");
			//return;
		}
		
		extractLeafNodesOfABinaryTreeInDLL(leftNode);
		extractLeafNodesOfABinaryTreeInDLL(rightNode);
	}

}
