public class ConvertBSTDoublyLinkedList {

	static Node prev = null;
	
	public static void main(String[] args) {
		System.out.println("Convert a BST into a Doubly Linked List!!");

		// Create a BST and return the root
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

		Node head = null;
		convertBST(seven, head);

		// traverse LinkedList to confirm
		System.out.print(head);
		while(head != null) {
			System.out.print(head.val+" ");
			head = head.left;
		}

		System.out.print(head);
	}

	static void convertBST(Node root, Node head) {
		if(root == null) {
			return;
		}

		convertBST(root.left, head);

		if(prev == null) {
			System.out.println("Setting");
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		convertBST(root.right, head);
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