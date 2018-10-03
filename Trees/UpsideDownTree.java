import java.util.*;

public class UpsideDownTree {

	public static void main(String[] args) {

		System.out.println("Turn this tree upside down!!!");

		// Build a binary tree w/ all right nodes being leaves
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		four.left = six;
		four.right = seven;

		two.left = four;
		two.right = five;

		one.left = two;
		one.right = three;

		DFS(one);
		Node newRoot = flipTree(one);
		System.out.println("");
		DFS(newRoot);
	}

	static Node flipTree(Node root) {
		if(root == null) {
			return null;
		}

		if(root.left == null && root.right == null) {
			return root;
		}

		Node newRoot = flipTree(root.left);

		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;

		return newRoot;
	}

	static void BFS(Deque<Node> q) {
		if(q.size() == 0) {
			return;
		}
		Node currNode = q.pop();
		if(currNode == null) {
			return;
		}
		System.out.print(currNode.val+" ");
		q.add(currNode.left);
		q.add(currNode.right);
		BFS(q);
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