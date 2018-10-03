public class BSTToCircularLinkedList {

	public static void main(String[] args) {

		System.out.println("Convert a BST into a Circular Doubly LinkedList!!");

		// Build a valid BST and return the root
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

		Node res = convertToList(seven);
		printList(res);
	}

	static Node convertToList(Node root) {
		if(root == null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			root.left = root;
			root.right = root;
			return root;
		}

		Node LNode = convertToList(root.left);
		Node RNode = convertToList(root.right);

		if(LNode != null && RNode != null) {
			return linkUtil(LNode, root, RNode); 
		}

		if(LNode != null) {
			Node temp = LNode.left;
			LNode.left = root;
			temp.right = root;
			root.left = temp;
			return LNode;
		}

		if(RNode != null) {
			Node temp = RNode.left;
			RNode.left = root;
			root.right = RNode;
			temp.right = root;
			root.left = temp;
			return root;
		}
		return null;	
	}

	static Node linkUtil(Node left, Node root, Node right) {
		Node leftEnd = left.left;
		Node rightEnd = right.left;

		// connect end of Right to beginning of left
		rightEnd.right = left;
		left.left = rightEnd;

		// connect end of left to root
		leftEnd.right = root;
		root.left = leftEnd;

		// connect root to beginning of right
		root.right = right;
		right.left = root;

		return left;
	}

	static void printList(Node root) {
		Node curr = root;
		while(curr.left != null && curr.right != root) {
			System.out.print(curr.val+" ");
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