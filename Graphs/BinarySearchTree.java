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

	public static void main(String[] args) {

		BinarySearchTree b = new BinarySearchTree(5);
		b.add(2);
		b.add(1);
		b.add(9);
		b.add(2);
		b.add(7);

		System.out.println(b.find(7));
		System.out.println(b.find(14));
	}

}
