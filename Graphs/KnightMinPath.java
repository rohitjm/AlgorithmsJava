import java.util.*;

public class KnightMinPath {

	public static void main(String[] args) {

		System.out.println("Minimum steps to reach target by a Knight!");

		System.out.println("Min Steps: "+ findMinDis(0,0,4,1,5,5));

	}

	static class Node {
		int x;
		int y;
		int dist;
		Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.dist = distance;
		}
	}

	static boolean isInGrid(int x, int y, int rows, int columns) {
		if(x < rows && x >= 0 && y < columns && y >= 0) {
			return true;
		}
		return false;
	}

	static int findMinDis(int x, int y, int dx, int dy, int rows, int columns) {

		//create the visited grid and init all cells to false
		boolean visited[][] = new boolean[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				visited[i][j] = false;
			}
		}

		int poss_x[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    	int poss_y[] = {-1, -2, -2, -1, 1, 2, 2, 1};
 
		//create the origin Node w/ distance 0
		Node root = new Node(x, y, 0);

		//Create queue for BFS and add the root Node
		Queue<Node> q = new LinkedList<Node>();

		q.add(root);

		while(q.peek() != null) {

			// pop the last Node off the queue and process it
			Node curr = q.poll();

			// check if the current cell matches the destination
			if(curr.x == dx && curr.y == dy) {
				return curr.dist;
			}

			for(int k = 0; k < poss_x.length; k++) {
				int newx = curr.x + poss_x[k];
				int newy = curr.y + poss_y[k];

				if(isInGrid(newx, newy, rows, columns)) {
					if(!visited[newx][newy]) {
						Node newNode = new Node(newx, newy, curr.dist + 1);
						q.add(newNode);
						visited[newx][newy] = true;
					}
				}

			}
		}

		// if no path to destination is found return -1;
		return -1;
	}


}