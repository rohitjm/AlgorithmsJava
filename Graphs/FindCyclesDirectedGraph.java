import java.util.*;

public class FindCyclesDirectedGraph {

	public static void main(String[] args) {
		System.out.println("Find the Cycles in a Directed Graph!!");

		// Build a graph w/ some cycles
		HashMap<Integer, Integer[]> adjList = new HashMap<Integer, Integer[]>();
		Integer[] values1 = {4,2,3}; 
		Integer[] values2 = {3};
		Integer[] values3 = {};
		Integer[] values4 = {5};
		Integer[] values5 = {6}; 
		Integer[] values6 = {4}; 
		adjList.put(1, values1);
		adjList.put(2, values2);
		adjList.put(3, values3);
		adjList.put(4, values4);
		adjList.put(5, values5);
		adjList.put(6, values6);
		System.out.println(findCycle(adjList));
	}

	static boolean findCycle(HashMap<Integer, Integer[]> adjList) {
		boolean[] visited = new boolean[7];
		boolean[] stk = new boolean[7];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
			stk[i] = false;
		}
		return findCycleUtil(1, visited, stk, adjList);
	}

	static boolean findCycleUtil(Integer curr, boolean[] visited, boolean[] stk, HashMap<Integer, Integer[]> adjList) {
		if(!visited[curr]) {

			System.out.println(curr+"");
			visited[curr] = true;
			stk[curr] = true;

			Integer[] children = adjList.get(curr);
			for(int i = 0; i < children.length; i++) {
				if(!visited[children[i]] && findCycleUtil(children[i], visited, stk, adjList)) {
					return true;
				} else if (stk[children[i]]) {
					return true;
				}
			}
			stk[curr] = false;
			return false;
		} else {
			return false;
		}
	}
}