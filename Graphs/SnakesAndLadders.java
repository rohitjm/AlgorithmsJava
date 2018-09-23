import java.util.*;

public class SnakesAndLadders {
	public static void main(String[] args) {
		System.out.println("Find Min Paths w/ Snakes and Ladders!!");
		int[] moves = {-1, 18, -1, -1, -1, -1, -1, -1, 3, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1};
		System.out.println("Min Path: "+findMinPath(moves));
	}

	static int findMinPath(int[] moves) {
		Deque<Node> q = new LinkedList<Node>();
		Node root = new Node(0,0);
		q.add(root);
		return findMinPathHelper(q, moves, moves.length-1);
	}

	static int findMinPathHelper(Deque<Node> q, int[] moves, int end) {
		if(q.size() == 0) {
			return -1;
		}
		Node curr = q.pop();
		int v = curr.val;
		System.out.println("val: "+v+" end: "+end);
		Node n;		
		if(v == end) {
			return curr.steps;
		}
		for(int i = v; i < v+6; i++) {
			if(i > end) {
				break;
			}
			if(moves[i] != -1) {
				n = new Node(moves[i], curr.steps+1);
			} else {
				n = new Node(i, curr.steps+1);
			}
			System.out.println("Adding: "+n.val);
			q.add(n);
		}
		return findMinPathHelper(q, moves, end);
	}
}

class Node {	
	int val;
	int steps;

	Node(int val, int steps) {
		this.val = val;
		this.steps = steps;
	}
}