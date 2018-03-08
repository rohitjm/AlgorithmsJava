public class Main {
	
	public static void main(String[]args) {
		LinkedList myLinkedList = new LinkedList(5);
    	System.out.println(myLinkedList.head.vaue);
	}

	public static class LinkedList {
		private Node head;
		private int listCount;

		public LinkedList(int headVal) {
			head = new Node(headVal);
			listCount = 0;
		}

		public void add(int nodeVal) {
			Node nodeToAdd = new Node(nodeVal);
			Node current = this.head;

			while(current.next != null) {
				current = current.next;
			}

			current.next = nodeToAdd;
			this.listCount++;
		}
	}

	public static class Node {
		private int value;
		private Node next;

		public Node(int myValue) {
			value = myValue;
			next = null;
		}
	}
}