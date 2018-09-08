public class SwapKthNodesLinkedList {

	public static void main(String[] args) {
		System.out.println("Swapping the kth nodes in a given LinkedList!!");

		// Create a LinkedList and add some elements to it.
		int[] nums = {8,3,4,5,2,77,12,9};
		LinkedListNode head = new LinkedListNode(10);
		LinkedListNode toAdd = null;
		LinkedListNode currNode = head;
		for(int i = 0; i < nums.length; i++) {
			toAdd = new LinkedListNode(nums[i]);
			currNode.next = toAdd;
			currNode = currNode.next;
		}
		printList(head);
		swapKth(head,4);
		printList(head);		
	}

	static void swapKth(LinkedListNode head, int k) {
		if(head == null) {
			System.out.println("head ref is null");
		}

		LinkedListNode fastNode = head;
		LinkedListNode slowNode = head;
		boolean slowStarted = false;
		int fastCounter = 1;

		while(fastNode.next != null) {
			if(slowStarted) {
				slowNode = slowNode.next;
			}
			if(fastCounter == (k-1)) {
				slowStarted = true;
			}
			fastNode = fastNode.next;
			fastCounter++;
		}

		fastCounter = 1;
		fastNode = head;
		while(fastCounter != k) {
			fastNode = fastNode.next;
			fastCounter++;
		}

		// fastNode will be at the ene and slow will be at end - k
		System.out.println("Swapping");

		swap(slowNode, fastNode, head);
	}

	static void swap(LinkedListNode fromEnd, LinkedListNode fromStart, LinkedListNode head) {
		// get the refs for the nodes directly preceding the kth and kth from end Nodes
		// swap the next
		LinkedListNode swap1 = walkToParent(head, fromEnd);
		LinkedListNode swap2 = walkToParent(head, fromStart);
		swap1.next = fromStart;
		swap2.next = fromEnd;
		LinkedListNode temp = fromStart.next;
		fromStart.next = fromEnd.next;
		fromEnd.next = temp;
	}

	static LinkedListNode walkToParent(LinkedListNode head, LinkedListNode target) {
		LinkedListNode curr = head;
		while(curr != null && curr.next != target) {
			curr = curr.next;
		}
		return curr;
	}

	static void printList(LinkedListNode head) {
		if(head == null) {
			System.out.println("head ref is null");
		}
		LinkedListNode curr = head;
		while(curr.next != null) {
			System.out.print(" "+curr.val);
			curr = curr.next;
		}
		System.out.print(" "+curr.val);
		System.out.println("");
	}

}

class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode(int val) {
    	this.val = val;
    }
};