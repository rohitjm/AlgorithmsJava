import java.util.*;

public class ZombieClusters {

	public static void main(String[] args) {

		System.out.println("Zombie Clusters!!");

		int[][] adj = new int[4][4];

		adj[0][0] = 1;
		adj[0][1] = 1;
		adj[0][2] = 0;
		adj[0][3] = 0;
		adj[1][0] = 1;
		adj[1][1] = 1;
		adj[1][2] = 0;
		adj[1][3] = 0;
		adj[2][0] = 0;
		adj[2][1] = 0;
		adj[2][2] = 0;
		adj[2][3] = 0;
		adj[3][0] = 0;
		adj[3][1] = 0;
		adj[3][2] = 0;
		adj[3][3] = 1;

		findClusters(adj);
	}

	static int findClusters(int[][] adj) {

		int numClusters = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[adj.length-1];

		for(int i = 0; i < adj.length; i++) {
			if(!visited[i] && adj[i][i] == 1) {
				q.add(i);
				numClusters++;	
			} 
			while(!q.isEmpty()) {
				Integer current = q.poll();
				visited[current] = true;

				for(int j = 0; j < adj[current].length; j++) {
					if(!visited[j] && adj[i][j] == 1) {
						q.add(j);
					}
				}
			}			
		}

		return numClusters;
	}
}




