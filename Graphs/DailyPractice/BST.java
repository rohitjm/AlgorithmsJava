import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
	Node root;

	BST(double value) {
		Node newNode = new Node(value);
		this.root = newNode;
	}

	class Node {
		double value;
		Node right;
		Node left;

		Node(double value) {
			this.value = value;
			this.right = null;
			this.left = null;
		}
	}

	void add(double value) {
		this.root = add_Rec(value, root);
	}

	Node add_Rec(double value, Node current) {
		if(current == null) {
			return new Node(value);
		}
		if(value < current.value) {
			current.left = add_Rec(value, current.left);
		}
		if(value > current.value) {
			current.right = add_Rec(value, current.right);
		}
		return current;
	}

	void DFT() {
		DFT_Rec(this.root);
	}

	void DFT_Rec(Node current) {
		if(current == null) {
			return;
		}
		System.out.print(" "+current.value);
		DFT_Rec(current.right);
		DFT_Rec(current.left);
	}

	void DFTUtil(String method) {
		if(method == "inOrder") {
			inOrderRec(this.root);	
		}
		if(method == "preOrder") {
			preOrderRec(this.root);	
		}
		if(method == "postOrder") {
			postOrderRec(this.root);	
		}		
	}

	void inOrderRec(Node current) {
		if(current != null) {
			inOrderRec(current.left);
			System.out.print(" "+current.value);
			inOrderRec(current.right);
		}
	}

		void preOrderRec(Node current) {
		if(current != null) {
			System.out.print(" "+current.value);
			preOrderRec(current.left);
			preOrderRec(current.right);
		}
	}

	void postOrderRec(Node current) {
		if(current != null) {
			postOrderRec(current.left);
			postOrderRec(current.right);
			System.out.print(" "+current.value);
		}
	}

  // This method mainly calls deleteRec()
  // void delete(double value)
  // {
  //     root = deleteRec(root, value);
  // }

  /* A recursive function to insert a new value in BST */
  // Node deleteRec(Node root, double value)
  // {
  //     /* Base Case: If the tree is empty */
  //     if (root == null)  return root;

  //     /* Otherwise, recur down the tree */
  //     if (value < root.value)
  //         root.left = deleteRec(root.left, value);
  //     else if (value > root.value)
  //         root.right = deleteRec(root.right, value);

  //     // if value is same as root's value, then This is the node
  //     // to be deleted
  //     else
  //     {
  //         // node with only one child or no child
  //         if (root.left == null)
  //             return root.right;
  //         else if (root.right == null)
  //             return root.left;

  //         // node with two children: Get the inorder successor (smallest
  //         // in the right subtree)
  //         root.value = minVal(root.right);

  //         // Delete the inorder successor
  //         root.right = deleteRec(root.right, root.value);
  //     }

  //     return root;
  // }

  void BFS() {
  	Queue<Node> queue = new LinkedList<Node>();
  	queue.add(root);
  	while(!queue.isEmpty()) {
  		Node current = queue.poll();
  		if(current != null) {
				System.out.print(" " + current.value);
  			queue.add(current.left);
  			queue.add(current.right);
  		}  		
  	}
  }

	void delete(double value) {
		root = delete_Rec(value, root);
	}

	Node delete_Rec(double value, Node current) {
		// Base case for recursion
		if(current == null) {
			return current;
		}

		//If value does not match recurse down the appropriate branch
		if(value < current.value) {
			current.left = delete_Rec(value, current.left);
		} else if(value > current.value) {
			current.right = delete_Rec(value, current.right);
		}

		//Value to delete and has 1 child node
		if(current.left == null) {
			return current.right;
		} else if(current.right == null) {
			return current.left;
		}

		//Value to delete and has both child nodes
		current.value = minVal(current.right);
		current.right = delete_Rec(current.value, current.right);

		return current;
	}

	double minVal(Node current) {
		double minVal = current.value;
		while(current.left != null)
		if(current.left != null) {
			current = current.left;
			minVal = current.value;
		}
		return minVal;
	}

	public static void main(String[]args) {
		System.out.println("Binary Search Tree implemented in Java");
		BST myBST = new BST(5);
		myBST.add(6);
		myBST.add(3);
		myBST.add(8);
		myBST.add(1);
		myBST.add(10);
		myBST.add(2);
		myBST.add(7);
		myBST.add(-2);
		myBST.add(4);
		myBST.add(2.5);

		// System.out.println("inOrder");
		// myBST.DFTUtil("inOrder");
		// System.out.println("preOrder");
		// myBST.DFTUtil("preOrder");
		// System.out.println("postOrder");
		// myBST.DFTUtil("postOrder");

		System.out.print(" ");

		// myBST.delete(2.5);
		System.out.print(" ");
		// myBST.DFTUtil("inOrder");
		myBST.BFS();
	}
}