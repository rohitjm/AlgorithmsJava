import java.io.*;
import java.util.*;


class GraphBFS {

	private int V;
	private LinkedList<Integer> adj[];

	GraphBFS(int v) {
		V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int v) {

		boolean visited[] = new boolean[V];
		visited[v] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(v);

		while(!queue.isEmpty()) {
			int s = queue.poll();
			System.out.print(s+" ");
			visited[s] = true;
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int j = i.next();
				if(!visited[j]) {
					visited[j] = true;
					queue.add(j);
				}
			}
		}
	}

	public static void main(String[] args) {
    System.out.println("Hello world!");
    GraphBFS g = new GraphBFS(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal "+
                       "(starting from vertex 2)");
    g.BFS(2);    
  }  
}

