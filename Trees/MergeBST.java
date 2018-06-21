
public class MergeBST {

    public static void(String [] args) {
        System.out.println("Merge BST!");

        //need to create 2 BSTs
        mergeTrees(treeRoot1, treeRoot2);
    }

    static Node mergeTrees(Node n1, Node n2) {
        
        //traverse both trees and write their contents to a single ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        BFT(n1, list);
        BFT(n2, list);
        
        //sort the ArrayList
        Collections.sort(list);
        
        //contsruct new BST w/ the elements from the sorted ArrayList
        Node rootNode = createBST(list, 0, list.size()-1);
        return rootNode;
    }


    static void BFT(Node root, ArrayList list) {
        Queue<Node> s = new LinkedList<Node>();
        s.add(root);
        while(s.peek() != null) {
            Node current = s.poll();
            list.add(current.val);
            s.add(current.left);
            s.add(current.right);
        }
    }

    static Node createBST(ArrayList<Integer> list, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, start, mid-1);
        root.left = createBST(list, mid+1, end);
        return root;
    }    
}

