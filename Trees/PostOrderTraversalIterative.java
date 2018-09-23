import java.util.*;

public class PostOrderTraversalIterative {

	public static void main(String[] args) {
		System.out.println("Post order traversal w/o Recursion!!");
		
		// Build a tree and pass the root
		Node root = new Node(5);
		Node left = new Node(7);
		Node right = new Node(8);
		root.left = left;
		root.right = right;
		postOrder(root);
	}

	static void postOrder(Node root) {

		Deque<Node> s = new LinkedList<Node>();
		s.push(root);

		while(s.size() != 0) {
			Node currNode = s.pop();
			System.out.print(currNode.val+" ");
			if(currNode.left != null) {
				s.push(currNode.left);			
			}
			if(currNode.right != null) {
				s.push(currNode.right);
			}			
		}
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