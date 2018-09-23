import java.util.*;

public class TopologicalSort {

	public static void main(String[] args) {

		System.out.println("Topological Sort!!");

		// Build a graph w/ no cycles
		HashMap<Integer, Integer[]> adjList = new HashMap<Integer, Integer[]>();
		Integer[] values1 = {4,2,3}; 
		Integer[] values2 = {3};
		Integer[] values3 = {};
		Integer[] values4 = {5};
		Integer[] values5 = {6}; 
		Integer[] values6 = {}; 
		adjList.put(1, values1);
		adjList.put(2, values2);
		adjList.put(3, values3);
		adjList.put(4, values4);
		adjList.put(5, values5);
		adjList.put(6, values6);

		topoSort(adjList);
	}

	public static void topoSort(HashMap<Integer, Integer[]> adjList) {

		// iterate through the unvisited nodes and dfs on each of them, adding the nodes to an array as we reach them
		boolean[] visited = new boolean[7];
		int[] ordering = new int[7];
		int index = ordering.length - 1;

		for(int i = 0; i < adjList.size(); i++) {
			visited[i] = false;
		}

		for(Map.Entry<Integer, Integer[]> entry : adjList.entrySet()) {
			if(!visited[entry.getKey()]) {
				index = DFS(entry.getKey(), visited, ordering, index, adjList);
			}
		}

		//print out the ordering array
		printArr(ordering);
	}

	static int DFS(Integer curr, boolean[] visited, int[] ordering, int index, HashMap<Integer, Integer[]> adjList) {
		visited[curr] = true;
		Integer[] children = adjList.get(curr);
		for(int i = 0; i < children.length; i++) {
			if(!visited[children[i]]) {
				index = DFS(children[i], visited, ordering, index, adjList);
			}
		}
		ordering[index] = curr;
		return index - 1;		
	}

	static void printArr(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i]+" ");	
		}
	}


}