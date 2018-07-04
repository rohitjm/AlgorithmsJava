import java.util.*;

public class LRUCache {
	
	public static void main(String[] args) {

		System.out.println("Design and Implement an LRU Cache!");

		//Create a valid set of inputs
		int capacity
		int[] query_type = null;
		int[] key = null;
		int[] value = null;

		implement_LRU_cache(capacity, query_type, key, value);
	}
     
     
    public static class Node {
        int key;
        int value;
        Node next;
    } 
     
    static int[] implement_LRU_cache(int capacity, int[] query_type, int[] key, int[] value) {
        int n = query_type.length-1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Node> cache = new LinkedList<Node>();
        
        for(int i = 0; i < n; i++) {
            
            int op = query_type[i];
            int k = key[i];
            int val = value[i];
            
            // For add/update operations
            if(op == 1) {
                //get the head of the list
                Node head = null;
                head = cache.getFirst();
                
                //iterate through the list and update if key is found
                boolean found = false;
                while(head != null) {
                    if(head.key == k) {
                        found = true;
                        head.value = val;
                        Node temp = head;
                        cache.remove(head);
                        cache.addFirst(temp);
                        break;
                    }
                    head = head.next;
                }
                
                // if not found then create a new Node and add at the top of the cache
                if(!found) {
                    Node newNode = new Node();
                    newNode.key = k;
                    newNode.value = val;
                    cache.addFirst(newNode);
                    found = false;
                }
                cleanCache(cache, capacity);
            }
            
            // For search operations
            if(op == 0) {
                Node head = cache.getFirst();
                boolean found = false;
                while(head != null) {
                    if(head.key == k) {
                        result.add(head.value);    
                        Node temp = head;
                        cache.remove(head);
                        cache.addFirst(temp);
                        break;
                    }
                    head = head.next;
                }
                if(!found) {
                    result.add(-1);
                }
            }
        }
        
        // convert the ArrayList into int array
        int[] arr = convertIntegers(result);
        return arr;
    }
    
    static void cleanCache(LinkedList<Node> cache, int capacity) {
        Node head = cache.getFirst();
        int count = 1;
        while(count <= capacity) {
            head = head.next;
            count++;
        }
        head.next = null;
    }
    
    static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}