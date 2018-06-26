import java.util.*;

public class MaxInSlidingWindow {

	public static void main(String[] args) {

		System.out.println("Maximum in Sliding Window!");
		int[] inp = {1,3,-1,-3,5,3,6,7}; // 3,3,5,5,6,7
		int[] inp2 = {3,6,2,8}; //8
		int[] inp3 = {12, 1, 78, 90, 57, 89, 56};

		// printArrayOnOneLine(max_in_sliding_window(inp, 3));
		printArrayOnOneLine(max_in_sliding_window(inp3, 3));
	}

    static int[] max_in_sliding_window(int[] arr, int w) {
        
        int n = arr.length;
        int i;
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> q = new LinkedList<Integer>();
        
        for(i = 0; i < w; ++i) {
            while(!q.isEmpty() && arr[q.peekLast()] <=  arr[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        // continue with the rest of the array
        for( ;i < n; ++i) {
            
            res.add(arr[q.peekFirst()]);
            
            //remove any elements that are not in the window
            while((!q.isEmpty()) && q.peekFirst() <= i-w) {
                q.removeFirst();
            }
            
            while((!q.isEmpty()) && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            
            q.addLast(i);
        }
        
        // add the last max to the result array
        res.add(arr[q.peekFirst()]);

        int[] resultArr = new int[res.size()];

        for(int j = 0; j < res.size(); j++) {
            if (res.get(j) != null) {
                resultArr[j] = res.get(j);
            }
        }
        
        return resultArr;
    }

    static void printArrayOnOneLine(int[] arr) {
		System.out.println("");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}		
	}

}