public class PrintAllPaths {
	
    static void printAllPaths(Node root) {
        // ArrayList<Integer> s = new ArrayList<Integer>();
        int[] path = new int[100];
        int pathLen = 0;
        printPath(root, path, pathLen);    
    }
    
    static void printPath(Node current, int[] path, int pathLen) {
        if(current == null) {
            return;
        }
        
        // Add the current element to the path array
        path[pathLen] = current.val;
        pathLen++;

        // If its a leaf print everything in the length array
        if(current.left == null && current.right == null) {
            printArray(path, pathLen);                
        }

        // If not lead then continue recusing down the tree
        printPath(current.left, path, pathLen);
        printPath(current.right, path, pathLen);
    }
    
    static void printArray(int[] arr, int pathLen) {
        System.out.println("");
        for(int i = 0; i < pathLen; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
    	System.out.println("Print All Paths in a BST!");

    }


}