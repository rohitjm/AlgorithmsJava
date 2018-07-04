public class LCABinaryTree {
	
    static Node findLCA(Node root, int n1, int n2) {
        
        ArrayList<Node> path1 = new ArrayList<Node>(); 
        ArrayList<Node> path2 = new ArrayList<Node>();
        int i = 0;
        int pathLen = 0;
        
        DFS(root, n1, path1, pathLen);
        DFS(root, n2, path2, pathLen);
        
        // printArr(n1arr);
        // printArr(n2arr);
        
        System.out.println("Path1 size: "+path1.size());
        
        while(path1.get(i) == path2.get(i)) {
            i++;
        }
        return path1.get(i-1);
    }
    
    static void printArr(Node[] arr) {
        System.out.println("");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].val+" ");
        }
    }
    
    static void DFS(Node current, int numToFind, ArrayList<Node> path, int pathLen) {
        
        if(current == null) {
            return;
        }
        
        path.add(pathLen, current);
        pathLen++;
        
        if(current.val == numToFind) {
            return;
        }
        
        DFS(current.left, numToFind, path, pathLen);
        DFS(current.right, numToFind, path, pathLen);
    }

    public static void main(String[] args) {
    	System.out.println("Find the LCA of 2 Nodes in a Ninary Tree!");

    	// Build Binary Tree and return the root Node and set 2 values to find

    	findLCA(root, n1, n2);
    }

}