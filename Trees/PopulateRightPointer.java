import java.util.*;

public class PopulateRightPointer {

	public static void main(String[] args) {

		System.out.println("Populate Right Pointer!!!");

		// Build a binary tree w/ all right nodes being leaves
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

		BFS(seven);
		System.out.println("");
		populatePointers(seven);
		System.out.println("");
		BFSRightPointer(seven);
	}


	static void populatePointers(Node root) {
		// Keep a queue like for BFS and find a way to demarcate levels
		// Add a level# in each node?
		// traverse down the rightmost path and add a rightpointer -> null on every node, then do normal BFS not add a rightpointer to node that have a rightpointer -> null

		Deque<Node> q = new LinkedList<Node>();

		q.add(root);
		q.add(null);

		while(q.size() != 0) {
			Node curr = q.pop();
			if(curr != null) {
				//System.out.print(curr.val + " ");
				curr.rightPointer = q.peek();
				if(curr.left != null) {
					q.add(curr.left);	
				}
				if(curr.right != null) {
					q.add(curr.right);					
				}	
			} else if(q.size() != 0) {
				//System.out.println("adding null");
				q.add(null);
			}
		}
	}

	static void BFSRightPointer(Node root) {
		Deque<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.size() != 0) {
			Node curr = q.pop();
			if(curr == null) {
				return;
			}
			if(curr.rightPointer != null) {
				System.out.println(curr.val+" -> "+curr.rightPointer.val);
			} else {
				System.out.println(curr.val+" -> null");
			}
			
			q.add(curr.left);
			q.add(curr.right);
		}
	}

	static void BFS(Node root) {
		Deque<Node> q = new LinkedList<Node>();
		q.add(root);

		while(q.size() != 0) {
			Node curr = q.pop();
			if(curr == null) {
				return;
			}		
			System.out.print(curr.val+" ");
			q.add(curr.left);
			q.add(curr.right);				
		}
	}	
}

class Node {
	int val;
	Node left;
	Node right;
	Node rightPointer;
	Node(int val) {
		rightPointer = null;
		this.val = val;
	}
}