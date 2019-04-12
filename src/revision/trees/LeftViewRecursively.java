package revision.trees;


public class LeftViewRecursively {

	private static int desriredLevel = 1;
	public static void main(String[] args) {
		/*
		 * We can get the left view of a tree non-recursively using level order traversal technquie
		 * 
		 * 
		 */
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2; n1.right = n3;
		n3.left = n4; n4.right = n5;
		
		leftView(n1,1);

	}
	
	private static void leftView(TreeNode node, int currentLevel) {
		if(node == null) {
			return;
		}
		
		if(currentLevel == desriredLevel) {
			System.out.print(node.data + ",");
			desriredLevel++;
		}
		
		leftView(node.left,currentLevel+1);
		leftView(node.right, currentLevel+1);
	}

}
