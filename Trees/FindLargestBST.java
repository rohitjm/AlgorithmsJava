import java.util.*;

public class FindLargestBST {

	public static void main(String[] args) {

		System.out.println("Find the largest BST in a Binary Tree");

		// Build a Binary Tree
		Node three = new Node(3);
		Node nine = new Node(9);
		Node six = new Node(6);
		Node ten = new Node(10);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node five = new Node(5);

		five.left = three;
		five.right = six;
		nine.right = eight;
		nine.left = ten;
		seven.left = five;
		seven.right = nine;

		Deque<Node> q = new LinkedList<Node>();
		q.add(seven);

		BFS(q);
		
		Helper res = findBST(seven);
		System.out.println("The max BST is: "+res.size);

	}

	static Helper findBST(Node curr) {
		Helper newLeaf = new Helper();

		//if the node is null return 0
		if(curr == null) {
			newLeaf.isBST = true;
			return newLeaf;
		}

		// get the left and right trees
		Helper left = findBST(curr.left);
		Helper right = findBST(curr.right);

		if(left.isBST && right.isBST && (left.max <= curr.val) && (right.min >= curr.val)) {
			newLeaf.min = Math.min(curr.val, left.min);
			newLeaf.max = Math.max(curr.val, right.max);
			newLeaf.isBST = true;
			newLeaf.size = left.size + right.size + 1;
		} else {
			newLeaf.size = Math.max(left.size, right.size);
			newLeaf.isBST = false;
		}		
		return newLeaf;
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

class Helper {
	Integer	min = Integer.MAX_VALUE;
	Integer	max = Integer.MIN_VALUE;
	int size;
	boolean isBST;
	public void Helper() {
		size = 0;
		isBST = false;
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