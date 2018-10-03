import java.util.*;

public class PostOrderTraversalIterative {

	public static void main(String[] args) {
		System.out.println("Post order traversal w/o Recursion!!");
		
		// Build a tree and pass the root
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

		postOrderIterative(root);
		System.out.println("");
		postOrderRecursive(root);
	}

	static void postOrderIterative(Node root) {

		Deque<Node> s = new LinkedList<Node>();
		Deque<Node> post = new LinkedList<Node>();
		
		s.push(root);

		while(s.size() != 0) {

			Node currNode = s.pop();
			
			if(currNode.left != null) {
				s.push(currNode.left);			
			}
			if(currNode.right != null) {
				s.push(currNode.right);
			}

			post.push(currNode);			
		}

		while(post.size() != 0) {
			if(post.size() == 1) {
				System.out.print(post.pop().val);	
			} else {
				System.out.print(post.pop().val+" ");
			}			
		}
	}

	static void postOrderRecursive(Node root) {
		if(root == null) {
			return;
		}

		postOrderRecursive(root.left);
		postOrderRecursive(root.right);

		System.out.print(root.val+" ");
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