public class DeepCopyGraph {

	public static void main(String[] args) {
		System.out.println("Deep Copy Undirected Cyclic Graph!!!");
		HashMap<Node, Node[]> adjList = new HashMap<Node, Node[]>();


	}

	static HashMap<Node, Node[]> deepCopy(HashMap<Node, Node[]> adjList, Node root) {		
		
		Deque<Node[]> q = new LinkedList<Node[]>();
		q.add([root, null]);

		while(!q.isEmpty()) {
			
		}



	}

}

class Node {
	int val;
}