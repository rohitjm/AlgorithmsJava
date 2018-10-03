import java.util.*;

public class FlipBinaryTree {

	public static void main(String[] args) {
		System.out.println("Flip Binary Tree!!");
		System.out.println("");

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

		Deque<Node> q = new LinkedList<Node>();

		System.out.println("Original: ");
		q.add(root);
		BFS(q);

		System.out.println("");
		// flipTree(root);
		flipTreeRecursive(root);
		q = new LinkedList<Node>();

		System.out.println("Clone: ");
		q.add(root);
		BFS(q);
	}

	static void flipTree(Node root) {

		ArrayList<Node> q1 = new ArrayList<Node>();
		ArrayList<Node> q2 = new ArrayList<Node>();

		// Deque<Node> q1 = new LinkedList<Node>();
		// Deque<Node> q2 = new LinkedList<Node>();
		ArrayList<Node> currQueue = null;
		q1.add(root);

		while(q1.size() != 0 && q2.size() != 0) {

			// if q1 is not empty, reverse the values of everything in the queue then put the children of everything in the queue into q2 and vice versa
			if(q1.size() != 0) {
				currQueue = q1;	
			} else if(q2.size() != 0) {
				currQueue = q2;
			}

			while(currQueue.size() > 0) {
				// reverse everything in this queue
				// add all the children to the other queue
			}
		}
	}

	static void flipTreeRecursive(Node root) {
		if(root != null) {
			flipTreeRecursive(root.left);
			flipTreeRecursive(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return;
	}

	static void DFS(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val+" ");
		DFS(root.left);
		DFS(root.right);
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
}