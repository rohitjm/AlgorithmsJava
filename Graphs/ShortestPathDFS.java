import java.util.*;

public class DFTInvestigation {

	public static void main(String[] args) {
		System.out.println("Use DFS to find the shortest path!!");
		HashMap<Integer, Integer[]> adjList = new HashMap<Integer, Integer[]>();

		Integer[] list = {2,3};
		adjList.put(0, list);
		Integer[] list2 = {0,4};
		adjList.put(1, list2);
		Integer[] list3 = {1};
		adjList.put(2, list3);

		System.out.println("Recursive: ");
		DFT(0, adjList);
		System.out.println("Iterative: ");
		DFTStack(0, adjList);
	}

	static void DFT(Integer root, HashMap<Integer, Integer[]> adjList) {
		boolean[] visited = new boolean[10];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		DFTHelper(root, visited, adjList);
	}

	static void DFTHelper(Integer curr, boolean[] visited, HashMap<Integer, Integer[]> adjList) {
		if(curr == null) {
			return;
		}
		visited[curr] = true;
		System.out.print(curr + " ");
		Integer[] currChildren = adjList.get(curr);
		if(currChildren == null) {
			return;
		}
		for(int i = 0 ; i < currChildren.length; i++) {
			if(!visited[currChildren[i]]) {
				DFTHelper(currChildren[i], visited, adjList);
			}			
		}
	}

	static void DFTStack(Integer root, HashMap<Integer, Integer[]> adjList) {
		Deque<Integer> s = new LinkedList<Integer>();
		boolean[] visited = new boolean[10];
		s.push(root);

		while(s.size() != 0) {
			Integer curr = s.pop();
			System.out.print(curr+" ");
			visited[curr] = true;
			Integer[] currChildren = adjList.get(curr);
			if(currChildren == null) {
				continue;
			}
			for(int i = 0; i < currChildren.length; i++) {
				if(!visited[currChildren[i]]) {
					s.push(currChildren[i]);
				}
			}
		}
	}

	static void printArr(Integer[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i]+" ");	
		}
	}
}
