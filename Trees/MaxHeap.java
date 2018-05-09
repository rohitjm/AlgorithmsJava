public class MaxHeap {

	Node root;

	public void MaxHeap(int rootVal) {
		Node newRoot = new Node(rootVal);
		this.root = newRoot;
	}

	public void maxHeapify() {}


	public static void main(String [] args) {
		System.out.println("MaxHeap implemented in Java");
	}

	public class Node {
		int value;
		Node left;
		Node right;
		public void Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

}