import java.io.*;
import java.util.*;



class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
    Graph g = new Graph(4);

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

  private static class Graph {
    int nodes = 0;
    List
  }


}



class Graph {
  
  private int V;
  private LinkedList<Integer> adj[];
  
  //Constructor
  Graph (int v){
    V = v;
    adj = new LinkedList[v];
    for(int i = 0; i < V; i++) {
      adj[i] = new LinkedList();
    }
  }
  
  //Add Edges
  void addEdge(int v, int w) {
    adj[v].add(w);
  }
  
  // BFS given a source s
  void BFS(int s) {
    boolean visited = new boolean[V];
    
    LinkedList<Integer> queue = new LinkedList<Integer>();
    
    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.add(s);
    
    while(queue.size != 0) {
      
      // Dequeue a vertex and print it
      s = queue.poll();
      System.out.println(s+" ");
      
      Itertor<Integer> = adj[s].listIterator();
      while(i.hasNext()) {
        int n = next();
        if(!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
  
  //BFS bymyself
  // public void BFS(int s) {
    
  //   LinkedList<Integer> queue = new LinkedList<Integer>();
  //   boolean visited = new boolean[V];
  //   int bfsResult = new int[];
    
  //   // start with the source node
  //   queue.enqueue(s);
    
  //   int track = 0;
  //   while(queue.size != 0) {
  //     int current = queue.poll();
  //     visited[current] = true;
  //     bfsResult[track] = current;
      
  //     for(int i = 0; i < adj[current].length; i++) {
  //       visited[adj[current][i]] = true;
  //       queue.add(adj[current][i]);
  //     }
  //   }
  // }
  

}

