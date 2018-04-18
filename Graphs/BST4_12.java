import java.io.*;
import java.util.*;

class BST {
	
	private Node root;

	BST(int value) {
		Node newNode = new Node(value);
		this.root = newNode;
	}

	class Node {
		int value;
		Node right;
		Node left;

		Node(int value) {
			this.value = value;
			this.right = null;
			this.left = null;
		}
	}

	void add(int value) {
		this.root = add_Rec(value, root);
	}

	Node add_Rec(int value, Node current) {
		if(current == null) {
			return new Node(value);
		}
		if(value < current.value) {
			current.right = add_Rec(value, current.right);
		}
		if(value > current.value) {
			current.left = add_Rec(value, current.left);
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
		System.out.print(" ", current.value);
		DFT_Rec(current.right);
		DFT_Rec(current.left);
	}

	public static void main(String[]args) {
		System.out.println("Binary Search Tree implemented in Java");
		BST myBST = new BST(5);
		myBST.add(6);
		myBST.add(3);
		myBST.add(8);
		myBST.DFT();
	}
}