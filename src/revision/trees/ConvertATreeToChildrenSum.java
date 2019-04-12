package revision.trees;

public class ConvertATreeToChildrenSum {

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
		
		convertTree(n1);
		
		inorder(n1);

	}
	
	private static void inorder(TreeNode node) {
		if(node == null) 
			return;
		
		inorder(node.left);
		System.out.print(node.data + ",");
		inorder(node.right);
	}
	
	private static TreeNode convertTree(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		if(node.left == null && node.right == null) {
			return node;
		}
		
		TreeNode leftNode = convertTree(node.left);
		TreeNode rightNode = convertTree(node.right);
		
		int sum = 0;
		if(leftNode != null) {
			sum = sum + leftNode.data;
		}
		
		if(rightNode != null) {
			sum = sum + rightNode.data;
		}
		
		int diff = sum - node.data;
		
		if(diff == 0) {
			return node;
		}
		
		if(diff > 0) {
			node.data = node.data + diff;
			return node;
		}
		
		if(diff < 0) {
			incrementChildNodes(node,Math.abs(diff));
			return node;
			
		}
		
		return node;
	}
	
	private static void incrementChildNodes(TreeNode node, int diff) {
		TreeNode leftNode = node.left;
		TreeNode rightNode = node.right;
		
		if(leftNode != null) {
			leftNode.data = leftNode.data + diff;
			incrementChildNodes(leftNode, diff);
		} else if(rightNode != null){
			rightNode.data = rightNode.data + diff;
			incrementChildNodes(rightNode, diff);
		}
	}

}
