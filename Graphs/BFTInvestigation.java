import java.util.*;

public class BFTInvestigation {

	public static void main(String[] args) {
		System.out.println("BFT Investigation!!");
		HashMap<Integer, Integer[]> adjList = new HashMap<Integer, Integer[]>();

		Integer[] list = {2,3};
		adjList.put(0, list);
		Integer[] list2 = {0,4};
		adjList.put(1, list2);
		Integer[] list3 = {1};
		adjList.put(2, list3);

		System.out.print("Recursive: ");
		BFT(0, adjList);
		System.out.println("");
		System.out.print("Iterative: ");
		BFTQueue(0, adjList);
	}

	static void BFTQueue(Integer root, HashMap<Integer, Integer[]> adjList) {

		Deque<Integer> q = new LinkedList<Integer>();
		q.add(root);
		boolean[] visited = new boolean[10];

		while(q.size() != 0) {
			Integer curr = q.pop();
			System.out.print(curr+" ");
			visited[curr] = true;
			Integer[] currChildren = adjList.get(curr);
			if(currChildren == null) {
				continue;
			}
			for(int i = 0; i < currChildren.length; i++) {
				if(!visited[currChildren[i]]) {
					q.add(currChildren[i]);
				}
			}
		}
	}

	static void BFT(Integer root, HashMap<Integer, Integer[]> adjList) {
		boolean[] visited = new boolean[10];
		Deque<Integer> q = new LinkedList<Integer>();
		q.add(root);
		BFTHelper(adjList, q, visited);
	}

	static void BFTHelper(HashMap<Integer, Integer[]> adjList, Deque<Integer> q, boolean[] visited) {
		if(q.size() == 0) {
			return;
		}

		Integer curr = q.poll();
		System.out.print(curr+" ");
		visited[curr] = true;
		Integer[] currChildren = adjList.get(curr);
		if(currChildren != null) {
			for(int i = 0; i < currChildren.length; i++) {
				if(!visited[currChildren[i]]) {
					q.add(currChildren[i]);
				}
			}			
		}
		BFTHelper(adjList, q, visited);
	}

}