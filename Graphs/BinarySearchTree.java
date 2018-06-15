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

	static boolean isBST(Node root) {
        ArrayList<Integer> flat = new ArrayList<Integer>();
        flat = BFT(root, flat);
        return checkBST(flat);
    }
    
    static ArrayList<Integer> BFT(Node root, ArrayList<Integer> arr) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(queue.peek() != null) {
            Node curr = queue.poll();
            arr.add(curr.value);
            queue.add(curr.left);
            queue.add(curr.right);
        }

        return arr;
    }
    
    static boolean checkBST(ArrayList<Integer> arr) {

    	for(int j = 0; j < arr.size(); j++) {
    		System.out.print(arr.get(j));
    	}

        for(int i = 0; i < arr.size(); i++) {
        	int leftIndex = 2*i + 1;
        	int rightIndex = 2*i + 2;

			// check if the left child is smaller
        	if(leftIndex < arr.size()) {
        		if (arr.get(leftIndex) > arr.get(i)) {
        			return false;
        		}
        	}

        	// check if the right child is greater
        	if(rightIndex < arr.size()) {
        		if (arr.get(rightIndex) < arr.get(i)) {
        			return false;
        		}
        	}
        }
        return true;
    }


	public static void main(String[] args) {

		BinarySearchTree b = new BinarySearchTree(5);
		b.add(2);
		b.add(1);
		b.add(9);
		b.add(2);
		b.add(11);
		b.add(55);
		b.add(23);
		b.add(6);
		b.add(8);
		b.add(2);
		b.add(7);

		System.out.println(b.find(7));
		b.delete(7);
		System.out.println(b.find(7));
		System.out.println(b.BFS(9));

		System.out.println("Is BST: "+isBST(b.root));
	}

}
