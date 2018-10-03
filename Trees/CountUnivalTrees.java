import java.util.*;

public class CountUnivalTrees {

	public static void main(String[] args) {

		System.out.println("Count all the unival Trees!!");

		// Build N-ary tree

		//unival tree w/ all 1's
		Node[] empty = new Node[0];
		Node one1 = new Node(1, empty);
		Node one2 = new Node(1, empty);
		Node one3 = new Node(1, empty);
		Node[] uniRoot = { one1, one2, one3 };
		Node one = new Node(1, uniRoot);

		// rest of the tree
		Node five = new Node(5, empty);
		Node eight = new Node(8, empty);
		Node[] 2ndLevel = { one, five, eight };
		Node six = new Node(6, 2ndLevel);

		/**
		
		6
		5 8 1
			1 1 1

		**/

		Helper res = CountUnivalTrees(six);
		System.out.println(res.count);
	}

	Helper CountUnivalTrees(Node root) {
		Helper thisHelper = new Helper();
		if(root == null) {
			return thisHelper;			
		}

		int currCount = 0;
		thisHelper.val = root.val;
		for(int i = 0; i < root.children; i++) {
			Helper thisChild = CountUnivalTrees(root.children[i]);
			if(!thisChild.isUnival || root.val != thisChild.val) {
				thisHelper.isUnival = false;
				currCount += thisChild.count;
			}
		}

		if(!thisHelper.isUnival) {
			thisHelper.count = currCount;
		} else {
			thisHelper.count = 1;
		}

		return thisHelper;
	}
}

class Helper {
	boolean isUnival;
	int val;
	int count;
	public void Helper() {
		this.isUnival = true;		
		this.count = 0;
	}
}

class Node {
	int val;
	Node[] children;
	public void Node(int val, Node[] children) {
		this.val = val;
		this.children = children;
	}
}