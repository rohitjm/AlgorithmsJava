import java.util.*;

public class DeepCopyGraph {

	public static void main(String[] args) {
		System.out.println("Deep Copy Undirected Cyclic Graph!!!");
		
		// Build a graph
	}

	static UndirectedGraphNode deepCopy(UndirectedGraphNode node) {		
		
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Deque<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        
        System.out.println(node.label);
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        
        hm.put(node, clone);
        q.add(node);
        
        while(!q.isEmpty()) {
            
            UndirectedGraphNode curr = q.poll();             
            UndirectedGraphNode c_Clone = hm.get(curr);
            
            if(curr.neighbors != null) {
                
                for(UndirectedGraphNode gNode : curr.neighbors) {                    
                    UndirectedGraphNode gClone = hm.get(gNode);
                    if(gClone == null) {
                        q.add(gNode);
                        gClone = new UndirectedGraphNode(gNode.label);
                        hm.put(gNode, gClone);                        
                    }
                    c_Clone.neighbors.add(gClone);                    
                }                
            }                                
        }                        
        return clone;
    }
}

 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };