package coreman;

public class BasicTreeOperations {
	
	// Red-Black Tree is the variation of binary search tree where the height of the tree is log n.
	// B tree is another variation of binary search tree which is used for maintaining database on 
	// secondary memory i.e hard-disks

	private static TreeNode root = null;
	public static void main(String[] args) {
		
		int[] arr = {12, 5, 18, 2, 9, 15, 19, 13, 17};
		
		for(int data : arr) {
			TreeNode node = new TreeNode(data);
			insert(node);
		}
		
		
		//in-order traversal : O(n)
		inorder(root);
		
		// Minimum : O(log n)
		TreeNode minimumNode = minimum(root);
		System.out.println("\nMinimum: " + minimumNode.data);
		
		// Maximum : O(log n)
		TreeNode maximumNode = maximum(root);
		System.out.println("Maximum: " + maximumNode.data);
		
		// Search : O(log n)
		TreeNode searchedNode = search(root, 17);
		System.out.println("Searched node: " + searchedNode);
		
		// Successor: O(log n)
		TreeNode successor = successor(searchedNode);
		System.out.println("Successor: " + successor.data);
		
		
	}
	
	private static TreeNode successor(TreeNode node) {
		if(node.right != null)
			return minimum(node.right);
		
		TreeNode parent = node.parent;
		
		while(parent != null && parent.left != node) {
			node = parent;
			parent = node.parent;
		}
		
		return parent;
	}
	
	private static TreeNode search(TreeNode node, int value) {
		if(node == null) {
			return null;
		}
		
		if(node.data == value) {
			return node;
		}
		
		if(value < node.data)
			return search(node.left, value);
		else
			return search(node.right, value);
	}
	private static TreeNode minimum(TreeNode node) {
		if(node.left == null) 
			return node;
		
		return minimum(node.left);
	}
	
	private static TreeNode maximum(TreeNode node) {
		if(node.right == null)
			return node;
		return maximum(node.right);
	}
	
	private static void inorder(TreeNode node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data +",");
		inorder(node.right);
	}
	
	private static void insert(TreeNode node) {
		if(root == null) {
			root = node;
			return;
		}
		
		TreeNode parentNode = null;
		TreeNode currentNode = root;
		
		while(currentNode != null) {
			parentNode = currentNode;
			if(node.data < currentNode.data) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		
		node.parent = parentNode;
		if(node.data < parentNode.data) {
			parentNode.left = node;
		} else {
			parentNode.right = node;
		}
	}

}


class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	TreeNode(int data) {
		this.data = data;
	}
}
