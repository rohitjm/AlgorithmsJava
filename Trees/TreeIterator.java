import java.util.*;

public class TreeIterator {

	public static void main(String[] args) {

		System.out.println("Treeee Iterator!!");

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
		nine.left = eight;
		nine.right = ten;
		seven.left = five;
		seven.right = nine;

		Deque<Node> q = new LinkedList<Node>();
		q.add(seven);

		//BFS(q);

		TIterator myIterator = new TIterator(seven);
		while(myIterator.hasNext()) {
			System.out.print(" "+myIterator.next());
		}
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

class TIterator {

	Deque<Node> stk;

	TIterator(Node root) {
		stk = new LinkedList<Node>();
		while(root != null) {
			stk.push(root);
			root = root.left;
		}
	}

	boolean hasNext() {
		return stk.size() != 0;
	}

	int next() {
		Node currNode = stk.pop();
		int res = currNode.val;
		if(currNode.right != null) {
			currNode = currNode.right;
			while(currNode != null) {
				stk.push(currNode);
				currNode = currNode.left;
			}
		}

		return res;
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