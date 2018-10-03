import java.io.*;
import java.util.*;

public class FindLongestPathDAG {
	public static void main(String[] args) {

		System.out.println("Find the longest path from A to B in a DAG!!!");
		
		// Build a DAG w/ weighted edgeswp
		HashMap<Integer, Integer[][]> adjList = new HashMap<Integer, Integer[][]>();

		Integer[][] values1 = {{2,3}, {3,4}, {4,10}};
		Integer[][] values2 = {{5,10}, {4,3}};
		Integer[][] values3 = {{6,3}, {4,5}};
		Integer[][] values4 = {{5,4}, {7,6}};
		Integer[][] values5 = {};
		Integer[][] values6 = {{7,7}};
		Integer[][] values7 = {};										
		adjList.put(1, values1);
		adjList.put(2, values2);
		adjList.put(3, values3);
		adjList.put(4, values4);
		adjList.put(5, values5);
		adjList.put(6, values6);
		adjList.put(7, values7);

		// List<Integer> result = findLongestPath(adjList);
		System.out.println("Longest Path: " + findLongestPath(adjList));
		// printArr(result);
	}

	static Integer findLongestPath(HashMap<Integer, Integer[][]> adjList) {
	// static List<Integer> findLongestPath(HashMap<Integer, Integer[][]> adjList) {

		// Do a topological sort and and get the ordering array
		Integer[] ordering = topSort(adjList);
		printArr(ordering);

		// build a map of the Nodes and the shortest path to them
		// Keep in mind for the longest path we must flip their signs

		HashMap<Integer, Integer> pathLens = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, Integer[][]> entry : adjList.entrySet()) {
			pathLens.put(entry.getKey(), Integer.MAX_VALUE);
		}

		pathLens.put(ordering[0], 0);

		Integer[][] edges;
		Integer node;
		Integer weight;
		Integer currWeight;
		Integer nodeWeight;
		Integer currLow = Integer.MAX_VALUE;

		for(int i = 0; i < ordering.length; i++) {
			edges = adjList.get(ordering[i]);
			nodeWeight = pathLens.get(ordering[i]);
			for(int j = 0; j < edges.length; j++) {
				node = edges[j][0];
				weight = nodeWeight + edges[j][1] * -1;

				currWeight = pathLens.get(node);
				if(weight < currWeight) {
					pathLens.put(node, weight);	
				}

				if(weight < currLow) {
					currLow = weight;
				}				
			}
		}

		return currLow*-1;
	}

	static Integer[] topSort(HashMap<Integer, Integer[][]> adjList) {

		Integer[] ordering = new Integer[7];
		boolean[] visited = new boolean[7];
		int index = adjList.size()-1;

		for(Map.Entry<Integer, Integer[][]> entry : adjList.entrySet()) {
			if(!visited[entry.getKey()-1]) {
				index = topSortUtil(entry.getKey(), visited, ordering, index, adjList);
			}
		}
		return ordering;
	}

	static int topSortUtil(Integer currNode, boolean[] visited, Integer[] ordering, int index, HashMap<Integer, Integer[][]> adjList) {		
		visited[currNode-1] = true;
		Integer[][] children = adjList.get(currNode);
		for(int i = 0; i < children.length; i++) {
			if(!visited[children[i][0]-1]) {
				index = topSortUtil(children[i][0], visited, ordering, index, adjList);	
			}		
		} 
		ordering[index] = currNode;
		return index-1;
	}

	static void printArr(Integer[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");		
		}
		System.out.println("");
	}


}