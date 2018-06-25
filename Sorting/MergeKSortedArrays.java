import java.util.*;

public class MergeKSortedArrays {

	public static void main(String args[]) {

		System.out.println("Merge K Sorted Arrays!");

		int arr[][] = { {1, 3, 5, 7},
            {2, 2, 2, 2},
            {0, 9, 10, 11}};


        printArray(mergeArrays(arr, 3, 4));    
	}

	static int[] mergeArrays(int[][] arr, int k, int n) {
		// k = number of arrays
		// n = the # of elements in every array
		//first find out the sort order - if its increasing we'll need a min head, if decreasing then a max-heap

		String order = "";
		int result[] = new int[k*n];
		int index = 0;

		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] > arr[i][n-1]) {
				order = "dec";
			} else if(arr[i][0] < arr[i][n-1]) {
				order = "inc";
			}
		}

		//if inc implement a min-heap if dec max-heap
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		for(int j = 0; j < arr.length; j++) {
			for(int s = 0; s < arr[j].length; s++) {
				q.add(arr[j][s]);
			}
		}

		for(int r = 0; r < k*n; r++) {
			result[index] = q.poll();
			index++;
		}

		System.out.println(order);		
		return result;
	}

	public class HeapNode {
		int value;
		HeapNode leftChild;
		HeapNode rightChild;
		HeapNode(int val) {
			this.value = val;
		}
	}

	static void printArray(int[] arr) {
		System.out.println("[");
		for(int i = 0; i < arr.length; i++) {			
			System.out.print(arr[i]+",");
		}
		System.out.print("]");
	}


}