public class CloneBinaryTree {

	public static void main(String[] args) {
		System.out.println("Clone a Binary Tree!!");

		 // Build a Binary Tree
		Node three = new Node(3);
		Node nine = new Node(9);
		Node six = new Node(6);
		Node ten = new Node(10);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node root = new Node(5);

		seven.left = three;
		seven.right = nine;
		eight.left = six;
		eight.right = ten;
		root.left = seven;
		root.right = eight;

		System.out.println("");

		System.out.println("Original: ");
		DFS(root);
		System.out.println("");
		System.out.println("Clone: ");
		// Node cloneRoot = cloneBinaryTreeTopDown(root);
		Node cloneRoot = cloneBinaryTreeBottomUp(root);
		DFS(cloneRoot);
	}

	// This doesnt work 
	static Node cloneBinaryTreeTopDown(Node root) {
		Node cloneRoot = null;
		cloneBinaryTreeUtil(root, cloneRoot);
		return cloneRoot;
	}	

	static void cloneBinaryTreeUtil(Node root, Node clone) {
		clone = new Node(root.val);
		//System.out.println(clone.val);
		if(root.left != null) {
			Node cLeft = null;
			clone.left = cLeft;
			cloneBinaryTreeUtil(root.left, cLeft);
		}
		if(root.right != null) {
			Node cRight = null;
			clone.right = cRight;
			cloneBinaryTreeUtil(root.right, cRight);
		}
		return;
	}

	static Node cloneBinaryTreeBottomUp(Node root) {
		if(root == null) {
			return null;
		}
		Node clone = new Node(root.val);
		clone.left = cloneBinaryTreeBottomUp(root.left);
		clone.right = cloneBinaryTreeBottomUp(root.right);
		return clone;
	}

	static void DFS(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val+" ");
		DFS(root.left);
		DFS(root.right);
	}
}

class Node {
	int val;
	Node left;
	Node right;
	Node(int val) {
		this.val = val;
	}
}