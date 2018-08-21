// public class TreeDiameter {

// 	public static void main(String[] args) {
// 		System.out.println("Find the Diameter of a Tree!");
// 		System.out.println(findDiameter(root));
// 	}

// 	static int findDiameter(Node n) {

// 		if(n == null) {
// 			return 0;
// 		}

// 		// get the height of the 2 longest subtrees
// 		int max1 = 0;
// 		int max2 = 0;
// 		for(int i = 0; i < n. children.length; i++) {
// 			int currChildHeight = getHeight(n.children[i]);
// 			if( > max2) {
// 				max2 = currChildHeight;
// 				if(currChildHeight > max1) {
// 					int temp = max1;
// 					max1 = currChildHeight;
// 					max2 = temp;
// 				}
// 			}
// 		}

// 		// get the max diameter
// 		int maxChildDiameter = 0;
// 		for(int i = 0; i < n.children.length; i++) {
// 			int currChildDiameter = findDiameter(n.children[i]);
// 			if(currChildDiameter > maxChildDiameter) {
// 				maxChildDiameter = currChildDiameter;
// 			}
// 		}

// 		// return the max of the maxChildDiameter and 1+height of subtree1+height of subtree2
// 		return Math.max(maxChildDiameter, 1+max1+max2);
// 	}

// 	static int getHeight(Node n) {

// 		if(n == null) {
// 			return 0;
// 		}

// 		int maxChildHeight = 0;
// 		for(int i = 0; i < n.children.length; i++) {
// 			int h = getHeight(n.children[i]);
// 			if(h > maxChildHeight) {
// 				maxChildHeight = h;
// 			}
// 		}
// 		return maxChildHeight;
// 	}

// }

/**** Correct Solution ***/

public class TreeDiameter {

	public static void main(String[] args) {
		System.out.println("Find the Diameter of a Binary Tree!");
		System.out.println(findDiameter(root));
	}

	static int findDiameter(Node n) {

		if(n == null) {
			return 0;
		}

		// get the height of the 2 longest subtrees
		int lHeight = getHeight(n.left);
		int rHeight = getHeight(n.right);

		// get the max diameter
		int lDiameter = findDiameter(n.left);
		int rDiameter = findDiameter(n.right);


		// return the max of the maxChildDiameter and 1+height of subtree1+height of subtree2
		return Math.max(rDiameter, lDiameter, 1+lHeight+rHeight);
	}

	static int getHeight(Node n) {
		if(n == null) {
			return 0;
		}
		return Math.max(getHeight(n.left)+1, getHeight(n.right)+1);
	}
}