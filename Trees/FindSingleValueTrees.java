import java.util.*;

public class FindSingleValueTrees {

    public static void main(String[] args) {
        System.out.println("Find # of single value trees in Binary Tree!!");

        //Make a tree and pass the 
        Node root = new Node(5);

        System.out.println(findSingleValueTrees(root));
    }

    static int findSingleValueTrees(Node n) {
        int counter = 0;
        findUnivalUtil(n, counter);
        return counter;
    }
    
    static boolean findUnivalUtil(Node currNode, int counter) {
        
        if(currNode == null) {
            return true;
        }
        
        boolean leftExists = findUnivalUtil(currNode.left, counter);
        boolean rightExists = findUnivalUtil(currNode.right, counter);
        
        if(leftExists && rightExists) {
            Node left = currNode.left;
            Node right = currNode.right;
            
            if(left == null && right == null) {
                counter++;
                return true;
            }
            
            if(left != null && left.val == currNode.val && right != null && right.val == currNode.val) {
                counter++;
                return true;
            }
            
            if(left != null && left.val == currNode.val) {
                counter++;
                return true;
            }
            
            if(right != null && right.val == currNode.val) {
                counter++;
                return true;
            }
        }
        return false;
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}



