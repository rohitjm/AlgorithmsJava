import java.util.*;

public class CheckValidBST {

	public static void main(String[] args) {

		System.out.println("Check if this is a valid BST!!!");

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

		// Build an invalid BST and return the root
		BFS(seven);
		// System.out.println(checkBST(seven));
		System.out.println(checkBST2(seven, null, null));

		System.out.println("");
		nine.left = ten;
		nine.right = eight;

		BFS(seven);
		// System.out.println(checkBST(seven));
		System.out.println(checkBST2(seven, null, null));
	}


	static boolean checkBST(Node root) {
		if(root == null) {
			return true;
		}
		boolean Lcheck = checkBST(root.left);
		boolean Rcheck = checkBST(root.right);

		Node left = root.left;
		Node right = root.right;

		if(Lcheck != false && Rcheck != false) {
			if(left == null && right == null) {
				return true;
			}

			if(left != null && (left.val < root.val) && right != null && (right.val > root.val)) {
				return true;
			}

			if(left != null && (left.val < root.val)) {
				return true;
			}

			if(right != null && (right.val > root.val)) {
				return true;
			}
		}
		return false;
	}

	static boolean checkBST2(Node root, Node left, Node right) {
		if(root == null) {
			return true;
		}
		if(left != null && !(root.val > left.val)) {
			return false;
		}
		if(right != null && !(root.val < right.val)) {
			return false;
		}
		return checkBST2(root.left, left, root) && checkBST2(root.right, root, right);
	}

	static void BFS(Node root) {
		Deque<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.size() != 0) {
			Node curr = q.pop();
			System.out.print(curr.val+" ");
			if(curr.left != null) {
				q.add(curr.left);	
			}
			if(curr.right != null) {
				q.add(curr.right);	
			}
		}
	}
}