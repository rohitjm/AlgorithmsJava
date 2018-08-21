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