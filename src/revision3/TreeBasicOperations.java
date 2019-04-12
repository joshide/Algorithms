package revision3;

public class TreeBasicOperations {

	private static TreeNode root = null;
	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(20);
		
		insert(n1); insert(n2); insert(n3);
		
		inorder(n1);
		
		System.out.println("\ninorderSuccessor: " + inorderSuccessor(n3));

	}
	
	private static TreeNode inorderSuccessor(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		if(node.right != null) {
			return minimum(node.right);
		} else {
			TreeNode currentNode = node;
			TreeNode parent = currentNode.parent;
			while(parent != null && parent.left != currentNode) {
				currentNode = parent;
				parent = currentNode.parent;
			}
			return parent;
		}
	}
	
	private static TreeNode minimum(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	private static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + ",");
		inorder(node.right);
	}
	
	private static void insert(TreeNode node) {
		if(root == null) {
			root = node;
			return;
		}
		
		TreeNode parent = null;
		TreeNode currentNode = root;
		
		while(currentNode != null) {
			parent = currentNode;
			if(node.data < currentNode.data) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		
		if(node.data < parent.data) {
			parent.left = node;
		} else {
			parent.right = node;
		}
		node.parent = parent;
	}
	
	

}
