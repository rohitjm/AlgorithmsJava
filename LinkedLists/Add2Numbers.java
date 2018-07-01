import java.util.*;

public class Add2Nums {
	public static void main(String args[]) {
		System.out.println("Add 2 Numbers!");

		printLinkedList()
	}

	static int sumList(ListNode root) {
		int total = 0;
		ListNode curr = root;
		while(curr != null) {
			total = total + Math.pow(10, curr.val);
			curr = curr.next;
		}
		return total;
	}

	static LinkedList<Integer> buildList(ListNode l1, ListNode l2) {
		int total = 0;
		List<Integer> result = new LinkedList<Integer>();

		total += sumList(l1);
		total += sumList(l2);

		System.out.println("Total: "+ total);

		while(total > 0) {
			ListNode newNode = new ListNode(total % 10);
			resultList.add(newNode);
			total = total / 10;

		}
		return result.getFirst();
	}



}


// For LeetCode submission - bad for very large inputs - need to convert from int to double and back again. 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // get the sum total of the 2 LinkedLists
		double total = 0;
		total += sumList(l1);
		total += sumList(l2);
		
        // System.out.println("total1: "+sumList(l1)+" total2: "+sumList(l2));
        // System.out.println("total1: "+ total);
        
		// if(total == 0) {
		//     return null;
		// }

        System.out.println("inittotal: "+ total);
        
		//Create the head Node w/ the last digit from the total
        int val = (int)total % 10;
		ListNode head = new ListNode(val);
		total = total / 10;
		ListNode tail = head;

		while(total >= 1) {
            val = (int)total % 10;
            System.out.println("totalinLoop: "+total+" val: "+val);
			tail = _insert_node_into_singlylinkedlist(head, tail, val);
			total = total / 10;
            // System.out.println("totalinLoop: "+ total);
		}
		return head;
    }
    
    static double sumList(ListNode root) {
		double total = 0;
		ListNode curr = root;
		int tenpow = 0;
		while(curr != null) {
            // if(tenpow == 9) System.out.println("pre: "+total);
            // if(tenpow == 9) System.out.println("addends: "+curr.val+ " * "+(int) Math.pow(10, tenpow));
			total = total + (curr.val * Math.pow(10, tenpow));
            // if(tenpow == 9) System.out.println("post: "+total);
			curr = curr.next;
			tenpow++;
		}
        // System.out.println("Returning: "+total);
		return total;
	}
    
    public static ListNode _insert_node_into_singlylinkedlist(ListNode head, ListNode tail, int val){
        if(head == null) {
            head = new ListNode(val);
            tail = head;
        }
        else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return tail;
    }
}