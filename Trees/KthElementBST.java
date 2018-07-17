import java.util.*;

/*
    For your reference:
    
    static class Node
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };
*/

public class KthElementBST {
	
	public static void main(String[] args) {
		System.out.println("Print the Kth smallest element in a BST");
		//initialize a BST and return the root element
		findKth(root);
	}

	findKth(TreeNode root, int k) {

		TreeNode curr = root;
		int x = 0;
		Stack<TreeNode> s = new Stack<TreeNode>();

		while(!s.isEmpty() || curr != null) {

			// Add all the left nodes to the stack
			while(curr != null) {
				s.push(curr);
				curr = s.left_ptr;
			}

			// get the curr node and proccess it
			curr = s.pop();
			x++;

			if(x == k) {
				return curr.val;
			}

			// After processing a Node, process its right child
			curr = curr.right_ptr;
		}
	}


}