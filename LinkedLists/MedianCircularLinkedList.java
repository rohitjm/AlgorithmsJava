public class MedianCircularLinkedList {
	
	public static void main(String[] args) {
		System.out.println("Find the median of a circular singly linked list, given a pointer to an arbritary node");

		// Make a Sorted Linked List w/ all even numbers
		// Make a pointer to some node in the list
		LinkedListNode n;

		find_median(n);
	}

	static int find_median(LinkedListNode ptr) {
        int total = 1;
        int count = 0;
        LinkedListNode head = null;
        LinkedListNode origin = ptr;
        while(ptr != origin) {
            if(ptr.next.val < ptr.val) {
                head = ptr.next;
            }
            ptr = ptr.next;
            total++;
        }
        
        System.out.println("Total: "+total);
        System.out.println("Head: "+head.val);
        
        if(total % 2 == 0) {
            count = total/2-1;
            LinkedListNode slow = head;
            LinkedListNode fast = head.next;
            while(count >= 0) {
                slow = slow.next;
                fast = fast.next;
                count--;
            }
            return (slow.val + fast.val)/2;
        }
        count = total/2;
        LinkedListNode walk = head;
        while(count >= 0) {
            walk = walk.next;
            count--;
        }
        return walk.val;
    }
}