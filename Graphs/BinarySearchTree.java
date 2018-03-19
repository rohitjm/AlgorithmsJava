import java.io.*;
import java.util.*;

class BinarySearchTree {
	
	private Node root;

	BinarySearchTree(int rootVal) {
		Node newNode = new Node(rootVal);
		this.root = newNode;
	}

	class Node {
		private int value;
		private Node left;
		private Node right;
		Node(int value) {
			this.value = value;
		}
	}

	Node addRecursive(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		if(value < current.value) {
			current.left = addRecursive(current.left, value);
		}
		if(value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		return current;
	}

	void add(int value) {
		root = addRecursive(this.root, value);
	}

	boolean findRecursive(Node current, int value) {
		if(current == null) {
			return false;
		}
		if(current.value == value) {
			return true;
		}
		if(value < current.value) {
			return findRecursive(current.left, value);
		}
		if(value > current.value) {
			return findRecursive(current.right, value);
		}
		return false;
	}

	boolean find(int value) {
		return findRecursive(this.root, value);
	}

	private int findSmallestNode(Node root) {
		return root.left == null ? root.value : findSmallestNode(root.left);
	}

	private Node deleteRecursive(Node current, int value) {
		if(current.value == value) {
			// code for deletion
			if(current.left != null && current.right != null) {
				// if node has 2 child nodes
				int smallest = findSmallestNode(current.right);
				current.value = smallest;
				current.right = deleteRecursive(current.right, smallest);
				return current;			
			}
			if(current.left != null && current.right == null) {
				return current.left;
			}			
			if(current.right != null && current.left == null) {
				return current.right;
			}			
			if(current.left == null && current.right == null) {
				return null;
			}
		}
		if(current == null) {
			return null;
		}
		if(value < current.value) {
			current.left = deleteRecursive(current.left, value);
		}
		if(value > current.value) {
			current.right = deleteRecursive(current.right, value);
		}
		return null;
	}

	Node delete(int value) {
		return deleteRecursive(root, value);
	}

	boolean BFS(int value) {

		// ArrayList<Boolean> visited = new ArrayList<Boolean>();
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);

		while(!q.isEmpty()) {
			Node current = q.poll();
			System.out.println(current.value + " ");
			if(current.value == value) {
				return true;
			}
			// visited.add(current.value, true);

			if(current.left != null) {
				q.add(current.left);	
			}

			if(current.right != null) {
				q.add(current.right);	
			}

			// if(!visited.contains(current.left.value)) {
			// 	q.add(current.left);
			// }
			// if(!visited.contains(current.left.value)) {
			// 	q.add(current.right);
			// }
		}
		return false;
	}


	public static void main(String[] args) {

		BinarySearchTree b = new BinarySearchTree(5);
		b.add(2);
		b.add(1);
		b.add(9);
		b.add(2);
		b.add(7);

		System.out.println(b.find(7));

		b.delete(7);

		System.out.println(b.find(7));

		System.out.println(b.BFS(9));
	}

}
